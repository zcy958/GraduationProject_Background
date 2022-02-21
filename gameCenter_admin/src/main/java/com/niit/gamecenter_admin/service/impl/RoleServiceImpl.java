package com.niit.gamecenter_admin.service.impl;

import ch.qos.logback.core.BasicStatusManager;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niit.gamecenter_admin.mapper.RoleMapper;
import com.niit.gamecenter_admin.service.RoleService;
import com.niit.gamecenter_pojo.Result;
import com.niit.gamecenter_pojo.page.dto.PageDto;
import com.niit.gamecenter_pojo.page.vo.PageVo;
import com.niit.gamecenter_pojo.admin.role.dto.RoleDto;
import com.niit.gamecenter_pojo.admin.role.dto.RoleEditDto;
import com.niit.gamecenter_pojo.admin.role.pojo.Role;
import com.niit.gamecenter_pojo.admin.role.vo.RoleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public List<Role> queryAllRole() {
        return roleMapper.selectList(null);
    }

    @Override
    public Result addRole(RoleDto roleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDto,role);
        int i = roleMapper.insert(role);
        return new Result(i>0,i>0?"添加成功":"添加失败",null);
    }

    @Override
    public Result deleteRole(String id) {
        QueryWrapper<Role> queryWrapper= new QueryWrapper<>();
        queryWrapper.like("role_id",id);
        roleMapper.delRoleModuleId(id);
        int i = roleMapper.delete(queryWrapper);
        return new Result(i>0,i>0?"删除成功":"删除失败",null);
    }

    @Override
    public Result editRole(RoleEditDto roleEditDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleEditDto,role);
        int i = roleMapper.updateById(role);
        return new Result(i>0,i>0?"编辑成功":"编辑失败",null);
    }

    @Override
    public PageVo<RoleVo> queryRoleByPage(PageDto pageDto) {
        if(pageDto.getCurrentPage() == 0)pageDto.setCurrentPage(1);
        if(pageDto.getPageSize() == 0)pageDto.setPageSize(10);
        IPage<Role> page = new Page(pageDto.getCurrentPage(),
                pageDto.getPageSize());
        QueryWrapper<Role> queryWrapper= new QueryWrapper<>();
        if(pageDto.getQueryString()!=null){
            queryWrapper.like("name",pageDto.getQueryString());
        }
        if(pageDto.getStatus()!=null){
            queryWrapper.like("status",pageDto.getStatus());
        }
        IPage<Role> roleIPage = roleMapper.selectPage(page, queryWrapper);
        List<RoleVo> collect = getUserVos(roleIPage.getRecords());
        return new PageVo<RoleVo>(collect, (int) roleIPage.getTotal());
    }

    @Override
    public boolean roleAuth(Map map) {
        String roleId = (String) map.get("roleId");
        List<String> moduleIds = (List<String>) map.get("moduleIds");
        int result = roleMapper.addRoleToModule(roleId,moduleIds);
        return result>0;
    }

    @Override
    public List<String> getRoleModuleId(String roleId) {
        return roleMapper.getRoleModuleId(roleId);
    }

    @Override
    public Result addRoleToModule(Map map) {
        Map map1 = (Map) map.get("map");
        String roleId = (String) map1.get("roleId");
        List<Map> modules = (List<Map>) map1.get("modules");
        List<String> moduleIds = new ArrayList<>();
        List<String> moduleNames = new ArrayList<>();
        for(int j = 0; j<modules.size(); j++){
            moduleIds.add((String) modules.get(j).get("id").toString());
            moduleNames.add((String) modules.get(j).get("label").toString());
        }
        roleMapper.delRoleModuleId(roleId);
        roleMapper.updateModule(roleId,moduleNames.toString());
        int i = roleMapper.addRoleToModule(roleId,moduleIds);
        return new Result(i>0,i>0?"授权成功":"授权失败",null);
    }

    private List<RoleVo> getUserVos(List<Role> roleIPage) {
        List<RoleVo> collect=null;
        if(roleIPage!=null){
            collect = roleIPage.stream().map(role -> {
                RoleVo roleVo = new RoleVo();
                if(role.getStatus().equals("1"))role.setStatus("启用");
                else
                if(role.getStatus().equals("0"))role.setStatus("禁用");
                BeanUtils.copyProperties(role, roleVo);
                return roleVo;
            }).collect(Collectors.toList());
        }
        return collect;
    }

}

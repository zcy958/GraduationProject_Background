package com.niit.gamecenter_admin.controller;

import com.niit.gamecenter_admin.service.RoleService;
import com.niit.gamecenter_pojo.Result;
import com.niit.gamecenter_pojo.page.dto.PageDto;
import com.niit.gamecenter_pojo.page.vo.PageVo;
import com.niit.gamecenter_pojo.admin.role.dto.RoleDto;
import com.niit.gamecenter_pojo.admin.role.dto.RoleEditDto;
import com.niit.gamecenter_pojo.admin.role.pojo.Role;
import com.niit.gamecenter_pojo.admin.role.vo.RoleVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @PostMapping("/list")
    @ApiOperation("分页查询角色")
    public PageVo<RoleVo> queryRoleByPage(@RequestBody PageDto pageDto){
        return roleService.queryRoleByPage(pageDto);
    }


    @GetMapping("/all")
    @ApiOperation("获取全部角色")
    public List<Role> queryAllRole(){
        return roleService.queryAllRole();
    }

    @PostMapping("/add")
    @ApiOperation("添加角色")
    public Result addRole(@RequestBody RoleDto roleDto){
        return roleService.addRole(roleDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除角色")
    public Result deleteRole(@PathVariable String id){
        return roleService.deleteRole(id);
    }

    @PutMapping("/edit")
    @ApiOperation("修改角色")
    public Result editRole(@RequestBody RoleEditDto roleEditDto){
        return roleService.editRole(roleEditDto);
    }

    @PostMapping("/auth")
    @ApiOperation("角色授权")
    public Result roleAuth(Map map){
        boolean result = roleService.roleAuth(map);
        return new Result(result,result?"角色授权成功":"角色授权失败",null);
    }

    @GetMapping("/moduleId/{roleId}")
    @ApiOperation("获取拥有权限ID")
    public List<String> getRoleModuleId(@PathVariable String roleId){
        return roleService.getRoleModuleId(roleId);
    }

    @PostMapping("/module")
    @ApiOperation("角色权限关联表添加")
    public Result addRoleToModule(@RequestBody Map map){
        return roleService.addRoleToModule(map);
    }
}

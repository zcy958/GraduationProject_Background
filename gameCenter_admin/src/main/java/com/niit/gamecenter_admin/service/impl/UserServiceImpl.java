package com.niit.gamecenter_admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niit.gamecenter_admin.mapper.UserBackStageMapper;
import com.niit.gamecenter_admin.mapper.UserMapper;
import com.niit.gamecenter_admin.service.UserService;
import com.niit.gamecenter_pojo.Result;
import com.niit.gamecenter_pojo.page.dto.PageDto;
import com.niit.gamecenter_pojo.page.vo.PageVo;
import com.niit.gamecenter_pojo.admin.role.vo.RoleVo;
import com.niit.gamecenter_pojo.admin.user.dto.UserBackStageDto;
import com.niit.gamecenter_pojo.admin.user.dto.UserDto;
import com.niit.gamecenter_pojo.admin.user.dto.UserEditDto;
import com.niit.gamecenter_pojo.admin.user.pojo.User;
import com.niit.gamecenter_pojo.admin.user.pojo.UserBackStage;
import com.niit.gamecenter_pojo.admin.user.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserBackStageMapper userBackStageMapper;
    @Override
    public PageVo<UserVo> queryUserByPage(PageDto pageDto) {
        if(pageDto.getCurrentPage() == 0)pageDto.setCurrentPage(1);
        if(pageDto.getPageSize() == 0)pageDto.setPageSize(10);
        IPage<User> page = new Page(pageDto.getCurrentPage(),
                pageDto.getPageSize());
        QueryWrapper<User> queryWrapper= new QueryWrapper<>();
        if(pageDto.getQueryString()!=null){
            queryWrapper.like("user_name",pageDto.getQueryString());
        }
        if(pageDto.getStatus()!=null){
            queryWrapper.like("status",pageDto.getStatus());
        }
        IPage<User> userIPage = userMapper.selectPage(page, queryWrapper);
        List<UserVo> collect = getUserVos(userIPage.getRecords());
        return new PageVo<UserVo>(collect, (int) userIPage.getTotal());
    }

    @Override
    public Result editUser(UserEditDto userEditDto) {
        User user = new User();
        BeanUtils.copyProperties(userEditDto,user);
        int i = userMapper.updateById(user);
        if(userEditDto.getRoleId() != null){
            int j =
                    userMapper.addUserToRole(userEditDto.getUserId(),
                            userEditDto.getRoleId());
            return new Result(i>0,i>0&&j>0?"修改成功":"修改失败",null);
        }
        return new Result(i>0,i>0?"修改成功":"修改失败",null);
    }

    @Override
    public Result deleteUser(String id) {
        int i = userMapper.deleteById(id);
        return new Result(i>0,i>0?"删除成功":"删除失败",null);
    }

    @Override
    public Result addUser(UserDto userDto) {

        QueryWrapper<User> queryWrapper= new QueryWrapper<>();
        queryWrapper.like("user_name",userDto.getUserName());
        if(userMapper.selectOne(queryWrapper) == null){
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            int i = userMapper.insert(user);
            int j = userMapper.addUserToRole(user.getUserId(),userDto.getRoleId());
            return new Result(i>0,i>0&&j>0?"添加成功":"添加失败",null);
        }
        return new Result(false,"添加失败,用户名重复",null);
    }

    @Override
    public UserBackStage loginBackStage(UserBackStageDto userBackStageDto) {
        QueryWrapper<UserBackStage> queryWrapper= new QueryWrapper<>();
        if(userBackStageDto.getUserName()!=null){
            queryWrapper.like("user_name",userBackStageDto.getUserName());
        }
        if(userBackStageDto.getPassword()!=null){
            queryWrapper.like("password",userBackStageDto.getPassword());
        }
        UserBackStage i = userBackStageMapper.selectOne(queryWrapper);
        return i;
    }

    @Override
    public List<User> queryUserAll() {
        return userMapper.selectList(null);
    }

    @Override
    public List<RoleVo> selectRoleByUserId(String id) {
        return userMapper.selectRoleByUserId(id);
    }

    private List<UserVo> getUserVos(List<User> userIPage) {
        List<UserVo> collect=null;
        if(userIPage!=null){
            collect = userIPage.stream().map(user -> {
                UserVo userVo = new UserVo();
//                if(user.getStatus().equals("1"))user.setStatus("启用");
//                else
//                if(user.getStatus().equals("0"))user.setStatus("禁用");
//                if(user.getSex().equals("1"))user.setSex("男");
//                else
//                if(user.getSex().equals("0"))user.setSex("女");
                BeanUtils.copyProperties(user, userVo);
                return userVo;
            }).collect(Collectors.toList());
        }
        return collect;
    }

}

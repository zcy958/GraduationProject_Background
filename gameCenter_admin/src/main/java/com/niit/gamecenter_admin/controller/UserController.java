package com.niit.gamecenter_admin.controller;


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
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/list")
    @ApiOperation("分页查询用户")
    public PageVo <UserVo> queryUserByPage(@RequestBody PageDto pageDto){
        return userService.queryUserByPage(pageDto);
    }

    @GetMapping("/all")
    @ApiOperation("获取所有用户")
    public List<User> queryUserAll(){
        return userService.queryUserAll();
    }

    @PostMapping("/login/backstage")
    @ApiOperation("后台登录")
    public UserBackStage loginBackStage(@RequestBody UserBackStageDto userBackStageDto){
        return userService.loginBackStage(userBackStageDto);
    }

    @PutMapping("/edit")
    @ApiOperation("修改用户")
    public Result editUser(@RequestBody UserEditDto userEditDto){
        return userService.editUser(userEditDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除用户")
    public Result deleteUser(@PathVariable("id") String id){
        return userService.deleteUser(id);
    }

    @PostMapping("/add")
    @ApiOperation("添加用户")
    public Result addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }

    @GetMapping ("/role/{id}")
    @ApiOperation("查询用户角色")
    public List<RoleVo> selectRoleByUserId(@PathVariable("id") String id){
        return userService.selectRoleByUserId(id);
    }

}

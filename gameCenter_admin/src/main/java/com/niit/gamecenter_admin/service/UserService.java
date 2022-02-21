package com.niit.gamecenter_admin.service;

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

import java.util.List;

public interface UserService {

    PageVo<UserVo> queryUserByPage(PageDto pageDto);

    Result editUser(UserEditDto userEditDto);

    Result deleteUser(String id);

    Result addUser(UserDto userDto);

    UserBackStage loginBackStage(UserBackStageDto userBackStageDto);

    List<User> queryUserAll();

    List<RoleVo> selectRoleByUserId(String id);
}

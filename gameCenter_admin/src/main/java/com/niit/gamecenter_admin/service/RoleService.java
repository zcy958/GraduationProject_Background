package com.niit.gamecenter_admin.service;

import com.niit.gamecenter_pojo.Result;
import com.niit.gamecenter_pojo.page.dto.PageDto;
import com.niit.gamecenter_pojo.page.vo.PageVo;
import com.niit.gamecenter_pojo.admin.role.dto.RoleDto;
import com.niit.gamecenter_pojo.admin.role.dto.RoleEditDto;
import com.niit.gamecenter_pojo.admin.role.pojo.Role;
import com.niit.gamecenter_pojo.admin.role.vo.RoleVo;

import java.util.List;
import java.util.Map;

public interface RoleService {

    List<Role> queryAllRole();

    Result addRole(RoleDto roleDto);

    Result deleteRole(String id);

    Result editRole(RoleEditDto roleEditDto);

    PageVo<RoleVo> queryRoleByPage(PageDto pageDto);

    boolean roleAuth(Map map);

    List<String> getRoleModuleId(String roleId);

    Result addRoleToModule(Map map);
}

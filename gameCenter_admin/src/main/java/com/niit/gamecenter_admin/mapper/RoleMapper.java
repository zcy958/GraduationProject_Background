package com.niit.gamecenter_admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.niit.gamecenter_pojo.admin.role.pojo.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
    int addRoleToModule(@Param("roleId") String roleId,
                        @Param("moduleIds") List<String> moduleIds);

    @Select("select module_id from ss_role_module where role_id = #{roleId}")
    List<String> getRoleModuleId(String roleId);

    @Delete("delete from ss_role_module where role_id = #{roleId}")
    int delRoleModuleId(String roleId);


    @Update("update ss_role set have_module = #{moduleName} where role_Id = " +
            "#{roleId}")
    int updateModule(String roleId, String moduleName);
}

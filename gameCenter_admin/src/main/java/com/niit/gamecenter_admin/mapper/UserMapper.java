package com.niit.gamecenter_admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.niit.gamecenter_pojo.admin.role.vo.RoleVo;
import com.niit.gamecenter_pojo.admin.user.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    int addUserToRole(@Param("userId") String userId,
                      @Param("roleIds") List<Object> roleIds);

    @Select("SELECT\n" +
            "role_id,name,remark,`status`,create_by,create_time,update_by,update_time\n" +
            "FROM\n" +
            "ss_role\n" +
            "where (role_id)\n" +
            "in (\n" +
            "SELECT\n" +
            "role_id \n" +
            "FROM\n" +
            "ss_user_role \n" +
            "WHERE\n" +
            "user_id = #{id})")
    List<RoleVo> selectRoleByUserId(String id);
}

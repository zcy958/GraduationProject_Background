package com.niit.gamecenter_pojo.admin.role.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.niit.gamecenter_pojo.admin.module.pojo.Module;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@TableName("ss_role")
public class Role {
    @TableId("role_id")
    private String roleId;
    private String name;
    private String remark;
    private String haveModule;
    private String status;
    private String createBy;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    private String updateBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateTime;
}

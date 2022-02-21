package com.niit.gamecenter_pojo.admin.role.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleVo {
    private String roleId;
    private String name;
    private String remark;
    private String status;
    private String haveModule;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private String updateTime;
}

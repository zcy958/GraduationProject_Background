package com.niit.gamecenter_pojo.admin.user.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("ss_user")
public class User {
    @TableId("user_id")
    private String userId;
    private String userName;
    private String nickName;
    private String password;
    private String sex;
    private String age;
    private String autograph;
    private String handImg;
    private String address;
    private String phone;
    private String status;
    private String point;
    private String createBy;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    private String updateBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}

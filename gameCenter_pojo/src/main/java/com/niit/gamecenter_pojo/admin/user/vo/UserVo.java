package com.niit.gamecenter_pojo.admin.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
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
    private Date createTime;
    private String updateBy;
    private Date updateTime;
}

package com.niit.gamecenter_pojo.admin.user.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
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
    private String createBy;
    private List<Object> roleId;
}

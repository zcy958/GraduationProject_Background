package com.niit.gamecenter_pojo.admin.user.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ss_user_backstage")
public class UserBackStage {
    @TableId("user_id")
    private String userId;
    private String userName;
    private String password;
}

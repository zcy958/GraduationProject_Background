package com.niit.gamecenter_pojo.admin.role.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {

    private String roleId;
    private String name;
    private String remark;
    private String status;
    private List<String> haveModule = new ArrayList<>();
    private String createBy;
}

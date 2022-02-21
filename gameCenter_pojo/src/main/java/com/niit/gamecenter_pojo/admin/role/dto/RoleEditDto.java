package com.niit.gamecenter_pojo.admin.role.dto;

import java.util.ArrayList;
import java.util.List;

public class RoleEditDto {
    private String roleId;
    private String name;
    private String remark;
    private String status;
    private List<String> haveModule = new ArrayList<>();
    private String updateBy;
}

package com.niit.gamecenter_pojo.admin.module.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuleListVo {
    private String moduleId;
    private String parentId;
    private String parentName;
    private String name;
    private List children = new ArrayList();
}

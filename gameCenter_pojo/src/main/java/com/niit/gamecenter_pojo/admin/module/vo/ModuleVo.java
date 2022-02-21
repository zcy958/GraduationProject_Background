package com.niit.gamecenter_pojo.admin.module.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuleVo {
    private String id;
    private String label;
    private List children = new ArrayList();
}

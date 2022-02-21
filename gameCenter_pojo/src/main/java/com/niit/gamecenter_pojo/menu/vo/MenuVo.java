package com.niit.gamecenter_pojo.menu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuVo {
    private List<MenuListVo> menuListVos;
    private String menuFather;
}

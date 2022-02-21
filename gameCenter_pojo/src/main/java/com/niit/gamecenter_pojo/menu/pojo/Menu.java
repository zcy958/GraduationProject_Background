package com.niit.gamecenter_pojo.menu.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ss_menu_backstage")
public class Menu {
    @TableId("menu_id")
    private String menuId;
    private String menuName;
    private String menuFather;
    private String menuKey;
}

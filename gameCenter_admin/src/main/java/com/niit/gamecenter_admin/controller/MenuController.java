package com.niit.gamecenter_admin.controller;

import com.niit.gamecenter_admin.service.MenuService;
import com.niit.gamecenter_pojo.menu.vo.MenuVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/menu")
public class MenuController {
    @Autowired
    MenuService menuService;


    @GetMapping("/all")
    @ApiOperation("获取菜单")
    public List<MenuVo> queryMenu(){
        return menuService.queryMenu();
    }
}

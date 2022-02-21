package com.niit.gamecenter_admin.service.impl;

import com.niit.gamecenter_admin.mapper.MenuMapper;
import com.niit.gamecenter_admin.service.MenuService;
import com.niit.gamecenter_pojo.menu.pojo.Menu;
import com.niit.gamecenter_pojo.menu.vo.MenuListVo;
import com.niit.gamecenter_pojo.menu.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<MenuVo> queryMenu() {
        List<Menu> menus = menuMapper.selectList(null);
        List<MenuListVo> userList = new ArrayList<>();
        List<MenuListVo> gameList = new ArrayList<>();
        List<MenuVo> menuVos = new ArrayList<>();
        for (Menu menu : menus){
            if(menu.getMenuFather().equals("用户管理")){
                userList.add(new MenuListVo(menu.getMenuName(),
                        menu.getMenuKey()));
            }
            if(menu.getMenuFather().equals("游戏管理")){
                gameList.add(new MenuListVo(menu.getMenuName(),
                        menu.getMenuKey()));
            }
        }
        menuVos.add(new MenuVo(userList,"用户管理"));
        menuVos.add(new MenuVo(gameList,"游戏管理"));
        return menuVos;
    }
}

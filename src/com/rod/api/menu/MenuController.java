package com.rod.api.menu;


import com.rod.api.enums.Messenger;
import com.rod.api.user.UserController;
import com.rod.api.user.UserServiceImpl;
import lombok.Getter;

import java.sql.SQLException;
import java.util.List;

public class MenuController {
    private static MenuController instance = new MenuController();
    private final MenuServiceImpl menuService;


    public static MenuController getInstance() {
        return instance;
    }
    private MenuController(){
        menuService = MenuServiceImpl.getInstance();
    }

    public Messenger makeMenuTable(){
        return menuService.makeMenuTable();
    }
    public Messenger removeMenuTable(){
        return menuService.removeTable();
    }

    public List<?> getMenusByCategory(String category){
        return menuService.getMenusByCategory(category);
    }


    public void makeMenu() {
        menuService.makeMenu();
    }

    public void insertMenu() {
        menuService.insertMenus();
    }
}
package com.rod.api.menu;

public class MenuServiceImpl implements MenuService {
    private static MenuServiceImpl instance = new MenuServiceImpl();

    private MenuServiceImpl(){

    }

    public static MenuServiceImpl getInstance() {
        return instance;
    }




}

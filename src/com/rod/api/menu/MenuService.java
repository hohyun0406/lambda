package com.rod.api.menu;



import com.rod.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public interface MenuService {
    Messenger makeMenuTable();

    Messenger removeTable();

    List<?> getMenusByCategory(String category);

    void makeMenu();

    void insertMenus();

}
package com.rod.api;


import com.rod.api.enums.NavigationOfFuncton;
import com.rod.api.enums.NavigationOfPredicate;
import com.rod.api.menu.MenuController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        MenuController.getInstance().createTable();
        Scanner sc = new Scanner(System.in);

//        NavigationOfConsumer.select(scan);
        //while ();
//        String stringFlag = NavigationOfSupplier.select(scan);
        //while(stringFlag.equals("x"));
        while(!NavigationOfFuncton.select(sc).equals("x"));


//        while(NavigationOfPredicate.navigate(sc));
    }
}
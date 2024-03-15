package com.rod.api.menu;


import lombok.*;

import java.util.Scanner;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu {
    private Long id;
    private String category;
    private String item;

    public static void main(Scanner scanner) {
        MenuController.getInstance().makeMenu();
        MenuController.getInstance().insertMenu();


    }
}

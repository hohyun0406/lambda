package com.rod.api.enums;

import com.rod.api.account.AccountView;
import com.rod.api.article.Article;
import com.rod.api.article.ArticleView;
import com.rod.api.board.BoardView;
import com.rod.api.crawler.CrawlerView;
import com.rod.api.menu.Menu;
import com.rod.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum NavigationOfFuncton {
    MENU("m", sc->{
        Menu.main(sc);return "";
    }),
    USER("u", sc-> {
        try {
            UserView.main(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";}),
    ARTICLE("a", sc-> {
        try {
            ArticleView.main(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";}),
    BOARD("b", sc-> {BoardView.main();return "";}),
    ACCOUNT("ac", sc-> {AccountView.main(sc);return "";}),
    CRAWLER("c", sc-> {
        try {
            CrawlerView.main(sc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";}),
    EXIT("x", sc->"x"),
    ;

    private final String name;
    private final Function<Scanner, String> function;

    NavigationOfFuncton(String name, Function<Scanner, String> function) {
        this.name = name;
        this.function = function;
    }

    public static String select(Scanner sc) {

        List<String> ls = null;

        System.out.println("=== x-Exit " +
                "u-User " +
                "a-Article " +
                "b-Board " +
                "ac-Account " +
                "c-Crawler " +
                "===");
        String selectedMenu = sc.next();
        System.out.println("선택한 메뉴 : " + selectedMenu);
       return Stream.of(values())
               .filter(i->i.name.equals(selectedMenu))
               .findAny().orElseGet(()->EXIT)
               .function.apply(sc);
    }
}

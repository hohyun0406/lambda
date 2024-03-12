package com.rod.api;

import com.rod.api.account.AccountView;
import com.rod.api.article.ArticleView;
import com.rod.api.board.BoardView;
import com.rod.api.crawler.CrawlerView;
import com.rod.api.enums.Navigation;
import com.rod.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {
    private static Navigation useNavigation(String menuInput) {
        return Navigation.activeNavi(menuInput);
    }

    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=== x-Exit " +
                    "u-User " +
                    "a-Article " +
                    "b-Board " +
                    "m-Account " +
                    "c-Crawler " +
                    "===");
            useNavigation(sc.next());

//            switch (sc.next()) {
//                case "x":
//                    return;
//                case "u":
//                    UserView.main(sc);
//                    break;
//                case "a":
//                    ArticleView.main(sc);
//                    break;
//                case "b":
//                    BoardView.main();
//                    break;
//                case "m":
//                    AccountView.main(sc);
//                    break;
//                case "c":
//                    CrawlerView.main(sc);
//                    break;
//            }
        }
    }
}
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
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(Navigation.navigate(scan));
    }
}
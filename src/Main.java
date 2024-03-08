import account.AccountView;
import article.ArticleView;
import board.BoardView;
import crawler.CrawlerView;
import user.UserView;
import article.ArticleView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("=== x-Exit " +
                    "u-User " +
                    "a-Article " +
                    "b-Board " +
                    "m-Account " +
                    "c-Crawler " +
                    "===");
            switch (sc.next()){
                case "x":  return;
                case "u": UserView.main(sc);break;
                case "a": ArticleView.main(sc);break;
                case "b": BoardView.main(); break;
                case "m": AccountView.main(sc); break;
                case "c": CrawlerView.main(sc);  break;


            }
        }
    }
}
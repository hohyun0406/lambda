package crawler;

import user.UserController;

import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CrawlerView {
    public static void main(Scanner scanner) throws IOException {
        CrawlerController controller = new CrawlerController();
        while(true){
            System.out.println("[사용자메뉴] 0-종료\n " +
                    "1-벅스뮤직\n " +
                    "2-멜론뮤직\n " +
                    "3-ID검색\n " +
                    "4-비번변경\n " +
                    "5-탈퇴\n " +
                    "6-회원목록\n " +
                    "7-이름검색\n " +
                    "8-직업검색\n " +
                    "9-회원수");
            switch (scanner.next()){
                case "0":
                    System.out.println("종료");return;
                case "1":
                    System.out.println("1-벅스뮤직");
                    Map<String, ?> bugsMusic = controller.findBugsMusic(scanner);
                    Iterator<Element> rank = (Iterator<Element>) bugsMusic.get("rank");
                    Iterator<Element> artist = (Iterator<Element>) bugsMusic.get("artist");
                    Iterator<Element> title = (Iterator<Element>) bugsMusic.get("title");

                    System.out.println("벅스뮤직 결과 : ");
                    while(rank.hasNext()){
                        System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
                    }
                    break;
                case "2":
                    System.out.println("2-멜론뮤직");
                    Map<String, ?> melonMusic = controller.findMelonMusic(scanner);
                    Iterator<Element> melonRank = (Iterator<Element>) melonMusic.get("rank");
                    Iterator<Element> melonArtist = (Iterator<Element>) melonMusic.get("artist");
                    Iterator<Element> melonTitle = (Iterator<Element>) melonMusic.get("title");

                    System.out.println("멜론뮤직 결과 : ");
                    while(melonRank.hasNext()){
                        System.out.println(melonRank.next().text()+"위"+melonArtist.next().text()+"-"+melonTitle.next().text());
                    }

                    break;
                case "3":
                    System.out.println("3-ID 검색");

                    break;
                case "4":
                    System.out.println("4-비번변경");

                    break;
                case "5":
                    System.out.println("5-탈퇴");

                    break;
                case "6":
                    System.out.println("6-회원목록");

                    break;
                case "7":
                    System.out.println("7-이름검색");

                    break;
                case "8":
                    System.out.println("8-직업검색");

                    break;
                case "9":
                    System.out.println("9-회원수");


                    break;


            }

        }

    }
}
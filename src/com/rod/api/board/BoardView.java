package com.rod.api.board;


import com.rod.api.common.UtilService;
import com.rod.api.common.UtilServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class BoardView {
    public static void main() {
        List<Board> articles = new ArrayList<>();
        UtilService util = UtilServiceImpl.getInstance();

//        for(int i =0;i<5;i++){
//            articles.add(Board.builder()
//                    .title(util.createRandomTitle())
//                    .content(util.createRandomContent())
//                    .writer(util.createRandomName())
//                    .build());
//        }

        for(Board i : articles){
            System.out.println(i.toString());
        }

        articles.forEach(i -> {
            System.out.println(i.toString());
        });
    }

}
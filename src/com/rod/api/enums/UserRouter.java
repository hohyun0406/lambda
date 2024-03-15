package com.rod.api.enums;

import com.rod.api.user.UserController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum UserRouter {
    EXIT("x", i -> "0"),
    JOIN("joi", i->{
        System.out.println("회원가입"); UserController.getInstance().save(i); return "";}),
    LOGIN("log", i->{
        System.out.println("로그인"); UserController.getInstance().login(i); return "";}),
    FINDBYID("cat", i->{
        System.out.println("ID검색"); UserController.getInstance().findById(i); return "";}),
    UPDATEPASSWORD("ch-pw", i->{
        System.out.println("비번변경"); UserController.getInstance().updatePassword(i); return "";}),
    DELETE("rm", i->{
        System.out.println("탈퇴"); UserController.getInstance().delete(i); return "";}),
    USERLIST("ls-a", i->{
        System.out.println("회원목록"); UserController.getInstance().findAll(); return "";}),
    FINDUSERBYNAME("ls-n", i->{
        System.out.println("이름검색"); UserController.getInstance().findUsersByName(i).forEach((j)->{
            System.out.println(j);
        }); return "";}),
    FINDUSERBYJOB("ls-job", i->{
        System.out.println("직업검색"); UserController.getInstance().findUsersByJob(i).forEach((j)->{
            System.out.println(j);
        }); return "";}),
    COUNT("cnt", i->{
        System.out.println("회원수"); UserController.getInstance().count(); return "";}),
//    CREATETABLE("touch", i->{
//        System.out.println("테이블생성");
//        try {
//            UserController.getInstance().createTable();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return "";}),
//    DELETETABLE("rm", i->{
//        System.out.println("테이블삭제");
//        try {
//            UserController.getInstance().deleteTable();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } return "";}),
    ERORR("아무거나", i->"")
    ;

    private final String menu;
    private final Function<Scanner, String> function;

    UserRouter(String menu, Function<Scanner, String> function) {
        this.menu = menu;
        this.function = function;
    }

    public static String select(Scanner scanner) {
        System.out.println("[사용자메뉴] x-종료\n " +
                "joi-회원가입\n " +
                "log-로그인\n " +
                "cat-ID검색\n " +
                "ch-pw-비번변경\n " +
                "rm-탈퇴\n " +
                "ls-a-회원목록\n " +
                "ls-n-이름검색\n " +
                "ls-job-직업검색\n " +
                "cnt-회원수\n " +
                "touch - 테이블생성\n " +
                "rm- 테이블삭제\n " +
                "");
        String selectedM = scanner.next();
        System.out.println("선택한 메뉴 : " +selectedM);
        return Stream.of(values())
                .filter(i->i.menu.equals(selectedM))
                .findAny().orElseGet(()->ERORR)
                .function.apply(scanner);
    }
}

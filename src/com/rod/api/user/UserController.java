package com.rod.api.user;

import com.rod.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class UserController {
    private static UserController instance = new UserController();
    private final UserServiceImpl service;


    public static UserController getInstance() {
        return instance;
    }



    private UserController() {this.service = UserServiceImpl.getInstance();}

    public String addUsers() {return service.addUsers();}



    public String save(Scanner scanner) {
        service.save(User.builder()
                .username(scanner.next())
                .address(scanner.next())
                .phone(scanner.next())
                .password(scanner.next())
                .build());
        return "회원가입 성공";
    }

    public List<User> findAll() {
        return service.findAll();
    }

    public String login(Scanner scanner) {
        return service.login(User.builder()
                .username(scanner.next())
                .password(scanner.next())
                .build());
    }

    public Optional<User> findById(Scanner scanner) {
        return service.findById(Long.parseLong(scanner.next()));
    }

    public String updatePassword(Scanner scanner) {
        return service.updatePassword(User.builder()
                .username(scanner.next())
                .address(scanner.next())
                .phone(scanner.next())
                .password(scanner.next())
                .build());
    }

    public String delete(Scanner scanner) {
        service.delete(User.builder()
                .username(scanner.next())
                .build());
        return "회원삭제";
    }

    public Boolean existsById(Scanner scanner) {
        return service.existsById(Long.parseLong(scanner.next()));
    }

    public List<?> findUsersByName(Scanner scanner) {
        return service.findUsersByName(scanner.next());
    }

    public Map<String, ?> findUsersByNameFromMap(Scanner scanner) {
        return service.findUsersByNameFromMap(scanner.next());
    }

    public List<?> findUsersByJob(Scanner scanner) {
        return service.findUsersByJob(scanner.next());
    }

    public Map<String, ?> findUsersByJobFromMap(Scanner scanner) {
        return service.findUsersByJobFromMap(scanner.next());
    }

    public String count() {
        return service.count();
    }
    public Optional<User> getOne(Scanner scanner) {
        return service.getOne(scanner.next());
    }
    public Map<String, ?> getUserMap(){
        return service.getUserMap();
    }


    public String test() {
        return service.test();
    }

    public List<?> findUsers() throws SQLException {
        return service.findUsers();
    }

    public Messenger createTable() throws SQLException {
        return service.createTable();
    }

    public Messenger deleteTable() throws SQLException {
        return service.deleteTable();
    }

//    public Messenger createBaseballTable() {
//        return service.createBaseballTable();
//    }
}
package com.rod.api.account;

import java.util.Scanner;

public class AccountView {
    public static void main(Scanner sc) {
        AccountController accountController = new AccountController();
        while(true){
            System.out.println("[Account] 0-Exit 1-Create 2-Deposit " +
                    "3-Withdraw 4-Balance 5-Remove 6-Account List");
            switch (sc.next()){
                case "x": return;
                case "touch":
                    System.out.println("Create Account");
                    System.out.println(accountController.createAccount(sc));
                    break;
                case "depo":
                    System.out.println("Deposit");
                    System.out.println(accountController.deposit(sc));
                    break;
                case "with":
                    System.out.println("Withdraw");
                    System.out.println(accountController.withdraw(sc));
                    break;
                case "bal":
                    System.out.println("Balance");
                    System.out.println(accountController.getBalance(sc));
                    break;
                case "rm":
                    System.out.println("Cancel Account");
                    System.out.println(accountController.delete(sc));
                    break;
                case "ls-a":
                    System.out.println("Account List");
                    accountController.getAccounts().forEach((i)-> {
                        System.out.println(i);
                    });
                    break;
            }
        }


    }
}
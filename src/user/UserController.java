package user;


import java.util.Map;
import java.util.Scanner;

public class UserController {
    UserService userService;

    public UserController() {
        this.userService = new UserServiceImpl();
    }



    public String addUsers() {
        return userService.addUsers();
    }


    public String countUser() {
        return userService.countUser();
    }

    public Map<String, User> getUserMap() {
        return userService.getUserMap();
    }

    public String join(Scanner sc) {
        return userService.join(User.builder()
                .username(sc.next())
                .password(sc.next())
                .build());
    }

    public String login(Scanner sc) {
        return userService.login(User.builder()
                .username(sc.next())
                .password(sc.next())
                .build());
    }


}

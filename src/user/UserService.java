package user;

import java.util.Map;

public interface UserService {

    String addUsers();

    String countUser();

    Map<String, User> getUserMap();

    String join(User build);

    String login(User build);
}

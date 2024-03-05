package user;


import common.UtilService;
import common.UtilServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    Map<String, User> users;

    public UserServiceImpl() {
        this.userRepository = new UserRepository();
        users = new HashMap<>();
    }


    @Override
    public String addUsers() {
        Map<String, User> map = new HashMap<>();
        UtilService util = UtilServiceImpl.getInstance();


        for(int i = 0 ; i<5 ; i++){
            String newUsername = util.createRandomUsername();
            map.put(newUsername,
                    User.builder()
                            .username(newUsername)
                            .password("1")
                            .confirmPassword("1")
                            .name(util.createRandomName())
                            .build());
        }
        users = map;
        return users.size()+"개 더미값 추가";
    }

    @Override
    public String countUser() {
        return users.size()+"";
    }

    @Override
    public Map<String, User> getUserMap() {
        return users;
    }

    @Override
    public String join(User build) {
        users.put(build.getUsername(), build);
        return "회원가입 성공";
    }

    @Override
    public String login(User build) {


        String inputUsername = build.getUsername();
        String inputPassword = build.getPassword();

        User specificUser = users.get(inputUsername);

        if (specificUser ==null){
            System.out.println("아이디가 틀렸습니다.");
        }else if(!Objects.equals(specificUser.getPassword(), inputPassword)){
            System.out.println("비밀번호가 틀렸습니다.");
        }else{
            System.out.println("로그인 성공");
        }
        return null;
    }


}

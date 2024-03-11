package com.rod.api.user;

import com.rod.api.enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.rod.api.enums.Messenger.FAIL;
import static com.rod.api.enums.Messenger.SUCCESS;

public class UserRepository {
    private static UserRepository instance;
    private PreparedStatement pstmt;
    private ResultSet rs;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection connection;

    private UserRepository() throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/roddb",
                "roddb",
                "roddb");
    }

    public static UserRepository getInstance() {
        return instance;
    }

    public String test(){
        return "UserRepository 연결";
    }

    public List<?> findUsers() throws SQLException {
        String sql = "select * from com.rod.api.board";
        System.out.println("sql : "+ sql);
        connection.prepareStatement(sql);
        pstmt.executeQuery();
        List<User> ls = new ArrayList<>();
        if(rs.next()){
            do{
                ls.add(User.builder()
                        .id(rs.getLong("id"))
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .name(rs.getString("name"))
                        .phone(rs.getString("phone"))
                        .job(rs.getString("job"))
                        .build());
                System.out.printf("ID: %d\t Title: %s\t Content: %s\t Writer: %s\n",
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("writer"));
                System.out.println();
            }while(rs.next());
        }else{
            System.out.println("데이터가 없습니다.");
        }
        return null;
    }

    public Messenger createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS users (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    username VARCHAR(20) NOT NULL,\n" +
                "    password VARCHAR(20) NOT NULL,\n" +
                "    name VARCHAR(20),\n" +
                "    phone VARCHAR(20),\n" +
                "    job VARCHAR(20),\n" +
                "    height VARCHAR(20),\n" +
                "    weight VARCHAR(20)\n" +
                ")";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        int ce = pstmt.executeUpdate();
        System.out.println("쿼리의 반환값은" + ce);
        pstmt.close();
        connection.close();
        return (ce==0) ? SUCCESS: FAIL;
    }


    public String deleteTable() throws SQLException {
        String sql = "DROP TABLE IF EXISTS users";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        int ce = pstmt.executeUpdate();

        System.out.println("쿼리의 반환값은 "+ce);
        String msg = "";
        if(ce==0){
            msg = "테이블 삭제 성공";
        }else{
            msg = "테이블 삭제 실패";
        }
        return msg;
    }
}

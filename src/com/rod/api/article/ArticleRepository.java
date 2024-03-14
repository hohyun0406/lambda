package com.rod.api.article;

import com.rod.api.common.AbstractRepository;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleRepository extends AbstractRepository {
    private final static ArticleRepository instance;

    static {
        try {
            instance = new ArticleRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private Connection conn;

    private ArticleRepository() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/roddb",
                "roddb",
                "roddb");
    }

    public static ArticleRepository getInstance() {
        return instance;
    }


    public List findAll() throws SQLException {
        List<Article> ls = new ArrayList<>();
        String sql = "select * from articles";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            do{ls.add(
                    Article.builder()
                            .id(rs.getLong("id"))
                            .title(rs.getString("title"))
                            .content(rs.getString("content"))
                            .writer(rs.getString("writer"))
                            .build());
            }while (rs.next());
        }else{
            System.out.println("No Data");
        }
        rs.close();
        pstmt.close();
        conn.close();
        return null;
    }

    @Override
    public Map<String, ?> save(Map<String, ?> paramMap) throws IOException {
        return null;
    }
}

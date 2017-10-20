package dao;

import com.mysql.cj.jdbc.Driver;
import models.Ad;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    Connection connection = null;



    public MySQLAdsDao() {
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(
                    Config.getUrl(),
                    Config.getUsername(),
                    Config.getPassword()

            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ad> all(){
        return all(0L);
    }

    public List<Ad> all(Long id) {
        String selectQuery = "SELECT * FROM ads";

        if(id > 0){
            selectQuery += "WHERE id = " + id;
        }

        List<Ad> ads = new ArrayList<>();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);

            while(rs.next()) {
                ads.add(
                    new Ad(
                            rs.getLong("user_id"),
                            rs.getString("title"),
                            rs.getString("description"))
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        Long id = 0L;
        String username = "Alex";
        String email = "alxpotter@gmail.com";
        String password = "adsadsads";

        String query = String.format( "INSERT INTO ads(user_id, title, description) VALUES ('%s', '%s', '%s')",
        username,
        email,
        password
        );

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                id = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}

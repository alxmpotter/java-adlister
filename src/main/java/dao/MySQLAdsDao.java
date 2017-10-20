package dao;

import com.mysql.cj.jdbc.Driver;
import models.Ad;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private Connection connection = null;



    public MySQLAdsDao() {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    Config.getUrl(),
                    Config.getUsername(),
                    Config.getPassword()

            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Ad> all() {
        String selectQuery = "SELECT * FROM ads";

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
        String query = String.format( "INSERT INTO ads(user_id, title, description) VALUES ('%d', '%s', '%s')",
            ad.getUserId(),
            ad.getTitle(),
            ad.getDescription()
        );

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                 return rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

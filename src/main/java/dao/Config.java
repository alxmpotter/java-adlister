package dao;

public class Config {
    private static String url = "jdbc:mysql://localhost/database/ads_migration.sql";
    private static String username = "adlisterAdmin";
    private static String password = "adlisterproject";

    public static String getUrl() {
        return url;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}

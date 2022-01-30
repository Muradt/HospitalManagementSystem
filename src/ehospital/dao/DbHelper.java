package ehospital.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbHelper {
    public static Connection getConnection() throws Exception {
        Properties p = new Properties();
        p.load(new FileReader("Config.properties"));
        return DriverManager.getConnection(p.getProperty("db.url"), p.getProperty("db.username"), p.getProperty("db.password"));
    }
}

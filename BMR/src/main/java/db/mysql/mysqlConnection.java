package db.mysql;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class mysqlConnection {
    private static String DATABASE_NAME;
    private static String PROPERTIES;
    private static String URL;
    private static String USER;
    private static String PASS;
    private static Connection cn = null;
    public static void initConnection() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("/Users/imseoghyeon/Desktop/Project1/BMR/src/properties/mysql.properties"));
            DATABASE_NAME = prop.getProperty("databaseName");
            PROPERTIES = prop.getProperty("properties");
            URL = prop.getProperty("url");
            USER = prop.getProperty("user");
            PASS = prop.getProperty("pass");
        }catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        try {
            initConnection();
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(URL + DATABASE_NAME + PROPERTIES,USER,PASS);
            System.out.println(URL);
            System.out.println(DATABASE_NAME);
            System.out.println(PROPERTIES);
            System.out.println(USER);
            System.out.println(PASS);

        }catch (SQLException  | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cn;
    }
    public static void close() {
        try {
            if(cn != null) {
                cn.close();;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}

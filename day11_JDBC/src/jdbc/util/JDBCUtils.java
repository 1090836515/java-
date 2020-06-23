package jdbc.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    static {
        Properties prop=new Properties();
        try {
            /*String path = JDBCUtils.class.getClassLoader().getResource("jdbc.properties").getPath();
            prop.load(new FileReader(path));*/
            InputStream is =JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            prop.load(is);
            url = prop.getProperty("url");
            user=prop.getProperty("user");
            password=prop.getProperty("password");
            driver=prop.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {//静态变量才能用于静态方法中

            return DriverManager.getConnection(url,user,password);
    }

    public static void close(Connection conn, Statement stmt){
        if(stmt!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, Statement stmt, ResultSet res){
        if(res!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

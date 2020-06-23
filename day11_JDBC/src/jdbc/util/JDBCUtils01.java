package jdbc.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * druid数据库连接池工具类
 */
public class JDBCUtils01 {

    private static DataSource ds;
    static {
        Properties prop=new Properties();
        InputStream is = JDBCUtils01.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            prop.load(is);
            ds=DruidDataSourceFactory.createDataSource(prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static DataSource getDataSource(){
        return ds;
    }

    public static void close(Connection conn, Statement stmt){
        close(conn,stmt,null);
    }

    public static void close(Connection conn, Statement stmt, ResultSet res) {
        if (res != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}

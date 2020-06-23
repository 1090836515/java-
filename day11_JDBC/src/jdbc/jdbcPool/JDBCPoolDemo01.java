package jdbc.jdbcPool;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import jdbc.util.JDBCUtils01;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 *  1.C3P0：数据库连接池技术
 * 		* 步骤：
 * 			1. 导入jar包 (两个) c3p0-0.9.5.2.jar mchange-commons-java-0.2.12.jar ，
 * 				* 不要忘记导入数据库驱动jar包
 * 			2. 定义配置文件：
 * 				* 名称： c3p0.properties 或者 c3p0-config.xml,会自动加载
 * 				* 路径：直接将文件放在src目录下即可。
 *
 * 			3. 创建核心对象 数据库连接池对象 ComboPooledDataSource
 * 			4. 获取连接： getConnection
 * 	2.Druid：数据库连接池实现技术，由阿里巴巴提供的
 * 		1. 步骤：
 * 			1. 导入jar包 druid-1.0.9.jar
 * 			2. 定义配置文件：
 * 				* 是properties形式的
 * 				* 可以叫任意名称，可以放在任意目录下，需要手动加载
 * 			3. 加载配置文件。Properties
 * 			4. 获取数据库连接池对象：通过工厂来来获取  DruidDataSourceFactory
 * 			5. 获取连接：getConnection
 */
public class JDBCPoolDemo01 {
    public static void main(String[] args) throws Exception {
        //c3p0Test01();
        //druid01();
        druid02();
    }

    public static void c3p0Test01() throws Exception {
        //什么都不传,使用默认配置
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        for (int i=0;i<8;i++){
            Connection conn = ds.getConnection();
            System.out.println(conn);
        }
    }

    public static void druid01() throws Exception {
        Properties prop=new Properties();
        InputStream is = JDBCPoolDemo01.class.getClassLoader().getResourceAsStream("druid.properties");
        prop.load(is);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
    }

    public static void druid02() {
        Connection conn=null;
        PreparedStatement pstm=null;
        try {
            conn=JDBCUtils01.getConnection();
            String sql="insert into dept values(null,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,"教育部");
            pstm.setString(2,"石家庄");
            int count = pstm.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils01.close(conn,pstm);
        }


    }
}

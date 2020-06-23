package jdbc;

import jdbc.util.JDBCUtils;

import java.sql.*;

/**
 * 1.mysql5之后的驱动版本可以省略Class.forName("com.mysql.jdbc.Driver"),因为service中的java.sql.Driver已经把写了类名，会被扫描到
 * 2.获取数据库连接：方法：static Connection getConnection(String url, String user, String password):url：jdbc:mysql://ip地址(域名):端口号/数据库名称
 * 3."insert into dept values(null,'学信部','广州')";//主键自增可以用null作为占位符; 执行DDL语句的返回值为0;
 * 4.Statement：执行sql的对象(Statement用于静态sql,PrepareStatement用于动态sql)
 * 				1. boolean execute(String sql) ：可以执行任意的sql 了解
 * 				2. int executeUpdate(String sql) ：执行DML（insert、update、delete）语句、DDL(create，alter、drop)语句
 * 					* 返回值：影响的行数，可以通过这个影响的行数判断DML语句是否执行成功 返回值>0的则执行成功，反之，则失败。
 * 				3. ResultSet executeQuery(String sql)  ：执行DQL（select)语句
 * 5. ResultSet：结果集对象,封装查询结果
 * 			* boolean next(): 游标向下移动一行，判断当前行是否是最后一行末尾(是否有数据)，如果是，则返回false，如果不是则返回true
 * 			* getXxx(参数):获取数据
 * 				* Xxx：代表数据类型   如： int getInt() ,	String getString()
 * 			    *  参数：
 * 					1. int：代表列的编号,从1开始   如： getString(1)
 * 					2. String：代表列名称。 如： getDouble("balance")
 * 6. PreparedStatement：执行sql的对象
 * 			1. SQL注入问题：在拼接sql时，有一些sql的特殊关键字参与字符串的拼接。会造成安全性问题
 * 				1. 输入用户随便，输入密码：a' or 'a' = 'a
 * 				2. sql：select * from user where username = 'fhdsjkf' and password = 'a' or 'a' = 'a'
 * 			2. 解决sql注入问题：使用PreparedStatement对象来解决
 * 			3. 预编译的SQL：参数使用?作为占位符
 * 	7.开启事务：setAutoCommit(boolean autoCommit) ：调用该方法设置参数为false，即开启事务
 * 			* 在执行sql之前开启事务
 * 		* 提交事务：commit()
 * 			* 当所有sql都执行完提交事务
 * 		* 回滚事务：rollback()
 * 			* 在catch中回滚事务
 */
public class jdbcDemo01 {
    public static void main(String[] args) throws Exception {
       //statement01();
        resultSet01();
    }

    public static void statement01(){
        Connection conn=null;
        Statement stmt=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "8252560");
            //String sql="insert into dept values(null,'学信部','广州')";//主键自增可以用null作为占位符
            //String sql="update dept set loc='南昌' where id=10";
            //String sql="delete from dept where id=41";
            String sql="create table student (age int,name varchar(10))";
            stmt=conn.createStatement();
            int count = stmt.executeUpdate(sql);//执行DDL返回值为0
            System.out.println(count);
            if(count>0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(stmt!=null){
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(conn!=null){
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void resultSet01(){
        Connection conn=null;
        Statement stmt=null;
        ResultSet res=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "8252560");
            
            String sql="select * from dept";
            stmt=conn.createStatement();
            res = stmt.executeQuery(sql);
            while(res.next()){
                int id = res.getInt(1);
                String dname = res.getString("dname");
                String loc = res.getString(3);//方法有重载，从1开始
                System.out.println(id+"---"+dname+"----"+loc);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(res!=null){
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(stmt!=null){
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(conn!=null){
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void affair01(){
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //开启事务
            conn.setAutoCommit(true);

            //2.定义sql
            //2.1 张三 - 500
            String sql1 = "update account set balance=balance-? where id=?";
            //2.2 李四 + 500
            String sql2 = "update account set balance = balance + ? where id = ?";
            //3.获取执行sql对象
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            //4. 设置参数
            pstmt1.setDouble(1,500);
            pstmt1.setInt(2,1);

            pstmt2.setDouble(1,500);
            pstmt2.setInt(2,2);
            //5.执行sql
            pstmt1.executeUpdate();
            // 手动制造异常
            int i = 3/0;

            pstmt2.executeUpdate();
            //提交事务
            conn.commit();
        } catch (Exception e) {
            //事务回滚
            try {
                if(conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,pstmt1);
            JDBCUtils.close(null,pstmt2);
        }
    }

}

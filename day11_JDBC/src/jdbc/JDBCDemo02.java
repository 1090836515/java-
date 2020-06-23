package jdbc;

import jdbc.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * 登录案例：
 * 1."select * from user where username='"+username+"' and password='"+password+"'"//拼接字符串
 */
public class JDBCDemo02 {


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.next();
        System.out.println("请输入密码：");
        String password=sc.next();
        if(login2(username,password)){
            System.out.println("登陆成功");
        }else {
            System.out.println("登录失败");
        }
    }
    public static boolean login(String username,String password){
        if(username==null||password==null){
            return false;
        }
        Connection conn=null;
        Statement stmt=null;
        ResultSet res=null;
        try {
            conn= JDBCUtils.getConnection();
            String sql="select * from user where username='"+username+"' and password='"+password+"'";
            stmt=conn.createStatement();
            res=stmt.executeQuery(sql);
            return res.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,stmt,res);
        }
        return false;
    }

    public static boolean login2(String username,String password){
        if(username==null||password==null){
            return false;
        }
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet res=null;
        try {
            conn= JDBCUtils.getConnection();
            String sql="select * from user where username=? and password=?";
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,username);
            pstm.setString(2,password);
            res=pstm.executeQuery();
            return res.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,pstm,res);
        }
        return false;
    }

}

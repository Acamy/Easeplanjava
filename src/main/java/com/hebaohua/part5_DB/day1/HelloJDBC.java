package com.hebaohua.part5_DB.day1;

import java.sql.*;

/**
 * @author Hebh
 * @date 2018/2/1
 * @description:
 */
public class HelloJDBC {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/mysql?serverTimezone=UTC";
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void helloworld() throws ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        // 1. 装载驱动程序
        Class.forName(JDBC_DRIVER);
        // 2. 建立数据库连接
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            // 3.执行SQL语句
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select Host from user");
            // 4. 获取执行结果
            while(rs.next()){
                System.out.println("Hello " + rs.getString("Host"));
            }


        } catch (SQLException e) {
            // 异常处理
            e.printStackTrace();
        } finally {
            //5. 清理资源
            try {
                if(conn != null){
                    conn.close();
                }
                if(stmt != null){
                    stmt.close();
                }
                if(rs != null){
                    rs.close();
                }
            } catch (Exception e){
                // ignore
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException{
       helloworld();
    }
}

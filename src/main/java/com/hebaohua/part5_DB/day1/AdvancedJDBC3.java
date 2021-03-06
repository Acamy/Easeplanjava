package com.hebaohua.part5_DB.day1;

import java.io.*;
import java.sql.*;

/**
 * @author Hebh
 * @date 2018/2/1
 * @description: 大量数据插入数据库，批处理：一次提交多条SQL语句
 *        stmt.addBatch();
 *        stmt.executeBatch();
 *        stmt.clearBatch();
 */
public class AdvancedJDBC3 {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/mysql?useCursorFetch=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASSWORD = "root";
    static final String FILE_URL = "1.txt";

    public static void helloworld() throws ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;

        PreparedStatement ptmt = null;
        ResultSet rs = null;

        // 1. 装载驱动程序
        Class.forName(JDBC_DRIVER);
        // 2. 建立数据库连接
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            String[] users = {"user1", "user2", "user3", "user4"};
            stmt = conn.createStatement();
            for(String user: users){
                stmt.addBatch("insert into user(userName) values(" + user + "?");
            }
            stmt.executeBatch();
            stmt.clearBatch();

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

package com.hebaohua.part5_DB.day1;

import java.sql.*;

/**
 * @author Hebh
 * @date 2018/2/1
 * @description: 游标的使用， 当记录过多时
 */
public class AdvancedJDBC {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/mysql?useCursorFetch=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASSWORD = "root";

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
            // 3.执行SQL语句
            ptmt = conn.prepareStatement("select Host from user");
            ptmt.setFetchSize(1);
            rs = ptmt.executeQuery();
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

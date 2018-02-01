package com.hebaohua.part5_DB.day1;

import java.io.*;
import java.sql.*;

/**
 * @author Hebh
 * @date 2018/2/1
 * @description: 当字段过大时，使用流对象
 */
public class AdvancedJDBC2 {

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
            // 3.执行SQL语句
            ptmt = conn.prepareStatement("select Host from user");
            //ptmt.setFetchSize(1);
            rs = ptmt.executeQuery();
            // 4. 获取执行结果
            while(rs.next()){
                InputStream in = rs.getBinaryStream("Host");

                File f = new File(FILE_URL);
                OutputStream out = null;
                out = new FileOutputStream(f);
                int temp = 0;
                while( (temp = in.read()) != -1){
                    out.write(temp);
                }
                in.close();
                out.close();
            }


        } catch (SQLException e) {
            // 异常处理
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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

package com.hebaohua.part5_DB.day2;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Hebh
 * @date 2018/2/1
 * @description:
 */
public class DBPool extends Thread {
    public static BasicDataSource ds = null;
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/mysql?useCursorFetch=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASSWORD = "root";

    static {
        ds = new BasicDataSource();
        ds.setUrl(DB_URL);
        ds.setDriverClassName(JDBC_DRIVER);
        ds.setUsername(USER);
        ds.setPassword(PASSWORD);
        ds.setMaxActive(2);
    }

    public void doPoolTest(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from user");
            while(rs.next()){
                System.out.println(rs.getString("Host"));
            }
            System.out.println("=====================================");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                if(conn != null){
                    conn.close();
                }
                if(stmt != null){
                    stmt.close();
                }
                if(rs != null){
                    rs.close();
                }
            }catch (Exception e){
                // ignore
            }
        }
    }

    public static void main(String[] args){
        for(int i = 0; i < 10; i ++){
            new DBPool().start();
        }
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis() - start < 10000){
            doPoolTest();
        }
    }
}

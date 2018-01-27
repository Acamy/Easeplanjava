package com.hebaohua.part1_advancedJava.day8;

import java.io.*;

/**
 * @author Hebh
 * @date 2018/1/27
 * @description:
 */
public class TxtExample {
    public static void main(String[] args){
        try {
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream("a.txt")
                            )

                    )
            );
            int i = 123456;
            out.println(i);
            out.close();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            //new FileInputStream("src\\main\\java\\com\\hebaohua\\part1_advancedJava\\day8\\TxtExample.java")
                            new FileInputStream("Hanzi.txt"), "GBK"
                    )
            );
            String line;
            while((line = in.readLine()) != null){
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

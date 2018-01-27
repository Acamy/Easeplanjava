package com.hebaohua.part1_advancedJava.day8;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Hebh
 * @date 2018/1/27
 * @description:
 */
public class SocketExam {
    public static void main(String[] args){
        try {
            Socket socket = new Socket(InetAddress.getByName("localhost"),12345);
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    socket.getOutputStream()
                            )
                    )
            );
            out.println("Hello");
            out.close();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()
                    )
            );
            String line = in.readLine();
            System.out.println(line);
            in.close();

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

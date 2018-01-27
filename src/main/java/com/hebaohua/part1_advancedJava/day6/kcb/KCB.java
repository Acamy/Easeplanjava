package com.hebaohua.part1_advancedJava.day6.kcb;

import javax.swing.*;

/**
 * @author Hebh
 * @date 2018/1/27
 * @description:
 */
public class KCB {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        JTable table = new JTable(new KCBData());
        JScrollPane pane = new JScrollPane(table);
        frame.add(pane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

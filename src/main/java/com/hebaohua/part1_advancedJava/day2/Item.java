package com.hebaohua.part1_advancedJava.day2;

/**
 * @author Hebh
 * @date 2018/1/24
 * @description:
 */
public class Item {
    protected String title;
    private int playingTime;
    private boolean gotIt = false;
    private String comment;

    public Item(String title, int playingTime, String comment) {
        this.title = title;
        this.playingTime = playingTime;
        this.comment = comment;
    }

    public void print() {
        System.out.println("Item");
    }
}

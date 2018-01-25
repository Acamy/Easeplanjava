package com.hebaohua.part1_advancedJava.day3;

import com.hebaohua.part1_advancedJava.day2.Item;

/**
 * @author Hebh
 * @date 2018/1/25
 * @description:
 */
public class VideoGame extends Item {
    private int numberOfPlayers;


    public VideoGame(String title, int playingTime, String comment, int number) {
        super(title, playingTime, comment);
        this.numberOfPlayers = number;

    }

    public static void main(String[] args){

    }

    @Override
    public void print() {
        System.out.println("VideoGame");
        super.print();
    }
}

package com.hebaohua.part1_advancedJava.day4;

/**
 * @author Hebh
 * @date 2018/1/25
 * @description:
 */
public class Handler {
    protected Game game;

    public Handler(Game game) {
        this.game = game;
    }

    public void doCmd(String word){

    }
    public boolean isBye(){
        return false;
    }
}

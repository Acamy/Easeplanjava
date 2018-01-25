package com.hebaohua.part1_advancedJava.day4;

/**
 * @author Hebh
 * @date 2018/1/25
 * @description:
 */
public class HandlerGo extends Handler {

    public HandlerGo(Game game) {
        super(game);
    }

    @Override
    public void doCmd(String word) {
        game.goRoom(word);
    }
}

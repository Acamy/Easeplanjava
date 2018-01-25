package com.hebaohua.part1_advancedJava.day4;

/**
 * @author Hebh
 * @date 2018/1/25
 * @description:
 */
public class HandlerBye extends Handler {
    public HandlerBye(Game game) {
        super(game);
    }

    @Override
    public boolean isBye(){
        return true;
    }
}

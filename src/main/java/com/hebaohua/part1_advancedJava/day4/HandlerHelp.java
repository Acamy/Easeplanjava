package com.hebaohua.part1_advancedJava.day4;

/**
 * @author Hebh
 * @date 2018/1/25
 * @description:
 */
public class HandlerHelp extends Handler{

    public HandlerHelp(Game game) {
        super(game);
    }

    @Override
    public void doCmd(String word) {
        System.out.println("迷路了吗？你可以做的命令有： go bye help");
        System.out.println("如：\tgo east");
    }
}

package com.hebaohua.part1_advancedJava.day3;

import com.hebaohua.part1_advancedJava.day2.CD;
import com.hebaohua.part1_advancedJava.day2.DVD;
import com.hebaohua.part1_advancedJava.day2.Database;

/**
 * @author Hebh
 * @date 2018/1/25
 * @description:
 */
public class Test {
    public static void main(String[] args){
        Object o = new Object();
        System.out.println(o);

        Database db = new Database();

        db.add(new CD("abc", "abc",4,60, "..."));
        db.add(new CD("def", "def",4,60, "..."));
        db.add(new DVD("GGG", "ggg",4,"...."));
        db.add(new VideoGame("GGG", 12,"....",34));
        db.list();

    }
}

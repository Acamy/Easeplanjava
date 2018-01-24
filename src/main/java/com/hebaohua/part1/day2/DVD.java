package com.hebaohua.part1.day2;

/**
 * @author Hebh
 * @date 2018/1/24
 * @description:
 */
public class DVD extends Item{
    private String director;

    public DVD(String title, String director, int playingTime, String comment) {
        super(title, playingTime, comment);
        this.director = director;
    }

    @Override
    public void print(){
        System.out.println("title:" + title + ";director:" + director);
    }
}

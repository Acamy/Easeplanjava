package com.hebaohua.part1.day2;

import java.util.ArrayList;

/**
 * @author Hebh
 * @date 2018/1/24
 * @description:
 */
public class Database {
//    private ArrayList<CD> listCD = new ArrayList<CD>();
//    private ArrayList<DVD> listDVD = new ArrayList<DVD>();
//
//    public void add(CD cd){
//        listCD.add(cd);
//    }
//
//    public void add(DVD dvd){
//        listDVD.add(dvd);
//    }
//
//    public void list(){
//        for(CD cd : listCD){
//            cd.print();
//        }
//        for(DVD dvd : listDVD){
//            dvd.print();
//        }
//    }

    private ArrayList<Item> list = new ArrayList<Item>();

    public void add(Item item){
        list.add(item);
    }

    public void list(){
        for(Item item : list){
            item.print();
        }
    }

    public static void main(String[] args){
        Database db = new Database();
        db.add(new CD("abc", "abc",4,60, "..."));
        db.add(new CD("def", "def",4,60, "..."));
        db.add(new DVD("GGG", "gggf",4,"...."));
        db.list();
    }
}

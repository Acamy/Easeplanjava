package com.hebaohua.part1_advancedJava.day1;

import java.util.ArrayList;

/**
 * @author Hebh
 * @date 2018/1/17
 * @description:
 */
public class NoteBook {
    private ArrayList<String> notes = new ArrayList<String>();

    private void add(String s){
        notes.add(s);
    }

    public int getSize(){
        return notes.size();
    }

    public String getNote(int index){
        return notes.get(index);
    }

    public void removeNote(int index){
        notes.remove(index);
    }

    public static void main(String[] args){
        NoteBook nb = new NoteBook();
        nb.add("first");
        nb.add("second");
        System.out.println(nb.getSize());
        System.out.println(nb.getNote(1));
    }
}

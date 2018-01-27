package com.hebaohua.part1_advancedJava.day7;

import java.util.Scanner;

/**
 * @author Hebh
 * @date 2018/1/27
 * @description:
 */
public class ArrayIndex {
    public static void a(){
        int[] a = new int[10];
        a[10]= 10;
        System.out.println("a");
    }

    public static void main(String[] args){
        int[] a = new int[10];
        int idx;
        Scanner in = new Scanner(System.in);
        idx = in.nextInt();
        try {
            a();
            a[idx] = 10;
            System.out.println("hello");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Caught");
            e.printStackTrace();
        }

    }
}

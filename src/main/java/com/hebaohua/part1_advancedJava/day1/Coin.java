package com.hebaohua.part1_advancedJava.day1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Hebh
 * @date 2018/1/24
 * @description:
 */
public class Coin {
    private HashMap<Integer, String> coinmaps = new HashMap<Integer, String>();

    public Coin(){
        coinmaps.put(1, "penny");
        coinmaps.put(10, "dime");
        coinmaps.put(25, "quarter");
        coinmaps.put(50, "half-dollar");
        System.out.println(coinmaps);
        for(Integer k: coinmaps.keySet()){
            System.out.println(coinmaps.get(k));
        }
    }
    public String getName(int amount){
//        switch(amount){
//            case 10: return "dime";
//        }
//        return "";
        if(coinmaps.containsKey(amount)){
            return coinmaps.get(amount);
        }else{
            return "NOT FOUND";
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Coin coin = new Coin();
        int amount = sc.nextInt();

        String name = coin.getName(amount);
        System.out.println(name);

    }
}

package com.hebaohua.part1_advancedJava.day4;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Hebh
 * @date 2018/1/25
 * @description:
 */
public class Game {
    private Room currentRoom;
    private HashMap<String, Handler> handlers = new HashMap<String, Handler>();

    public Game(){
        handlers.put("bye", new HandlerBye(this));
        handlers.put("help", new HandlerHelp(this));
        handlers.put("go",new HandlerGo(this));

        creatRooms();
    }

    public void creatRooms(){
        Room outside, lobby, pub, study, bedroom;

        outside = new Room("外面");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");


        outside.setExit("east", lobby);
        outside.setExit("south", study);
        outside.setExit("west", pub);


        lobby.setExit("west", outside);

        pub.setExit("east", outside);

        study.setExit("north", outside);
        study.setExit("east", bedroom);

        bedroom.setExit("west", study);

        lobby.setExit("up", pub);
        pub.setExit("down", lobby);

//        outside.setExits(null, lobby, study, pub);
//        lobby.setExits(null, null, null , outside);
//        pub.setExits(null, outside, null, null);
//        study.setExits(outside, bedroom, null, null);
//        bedroom.setExits(null, null, null, study);

        currentRoom = outside;
    }
    public void showPrompt(){
        System.out.println("你在：" + currentRoom);
        System.out.println("出口有：" + currentRoom.getExitDesc());
    }

    public void goRoom(String direction){
        Room nextRoom = currentRoom.getExit(direction);

        if(nextRoom == null){
            System.out.println("那里没有门！");
        }else {
            currentRoom = nextRoom;
            showPrompt();
        }
    }

    public void printWelcome(){
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏！");
        System.out.println("如果需要帮助，请输入'help'。");
        System.out.println();
        showPrompt();
    }

    public void play(){
        Scanner in = new Scanner(System.in);

        while(true){
            String line = in.nextLine();
            String[] words = line.split(" ");
            Handler handler = handlers.get(words[0]);
            String value = "";
            if(words.length > 1){
                value = words[1];
            }
            if(handler != null){
                handler.doCmd(value);
                if( handler.isBye()){
                    break;
                }
            }
//            if(words[0].equals("help")){
//                printHelp();
//            }else if (words[0].equals("go")){
//                goRoom(words[1]);
//            }else if(words[0].equals("bye")){
//                break;
//            }
        }

        //in.close();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Game game = new Game();
        game.printWelcome();

        game.play();
//        while(true){
//            String line = in.nextLine();
//            String[] words = line.split(" ");
//            if(words[0].equals("help")){
//                game.printHelp();
//            }else if (words[0].equals("go")){
//                game.goRoom(words[1]);
//            }else if(words[0].equals("bye")){
//                break;
//            }
//        }

        System.out.println("感谢您的光临，再见！");

    }

}

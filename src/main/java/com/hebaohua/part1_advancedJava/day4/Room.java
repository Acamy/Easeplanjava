package com.hebaohua.part1_advancedJava.day4;

import java.util.HashMap;

/**
 * @author Hebh
 * @date 2018/1/25
 * @description:
 */
public class Room {
    private String description;
    private HashMap<String, Room> exits = new HashMap<String, Room>();
//    private Room northExit;
//    private Room southExit;
//    private Room eastExit;
//    private Room westExit;

    public Room(String description) {
        this.description = description;
    }

    public void setExit(String dir, Room room){
        exits.put(dir, room);
    }

//    public void setExits(Room north, Room east, Room south, Room west){
//        if(north != null){
//            northExit = north;
//        }
//        if(east != null){
//            eastExit = east;
//        }
//        if(south != null){
//            southExit = south;
//        }
//        if(west != null){
//            westExit = west;
//        }
//    }

    @Override
    public String toString(){
        return description;
    }

    public String getExitDesc(){
        StringBuffer sb = new StringBuffer();
        for(String dir : exits.keySet()){
            sb.append(dir);
            sb.append(' ');
        }
//        if(northExit != null){
//            sb.append("north ");
//        }
//        if(eastExit != null){
//            sb.append("east ");
//        }
//        if(southExit != null){
//            sb.append("south");
//        }
//        if(westExit != null){
//            sb.append("west");
//        }
        return sb.toString();
    }

    public Room getExit(String direction){
//        Room ret = null;
         return exits.get(direction);
//        if(direction.equals("north")){
//            ret = northExit;
//        }
//        else if(direction.equals("east")){
//            ret = eastExit;
//        }
//        else if(direction.equals("south")){
//            ret = southExit;
//        }
//        else if(direction.equals("west")){
//            ret = westExit;
//        }
//        return ret;
    }

}

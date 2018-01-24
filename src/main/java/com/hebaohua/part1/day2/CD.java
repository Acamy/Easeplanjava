package com.hebaohua.part1.day2;

/**
 * @author Hebh
 * @date 2018/1/24
 * @description:
 */
public class CD extends Item{
    private String artist;
    private int numOfTracks;

    public CD(String title, String artist, int numOfTracks, int playingTime, String comment) {
        super(title, playingTime, comment);
        this.artist = artist;
        this.numOfTracks = numOfTracks;
    }

//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getArtist() {
//        return artist;
//    }
//
//    public void setArtist(String artist) {
//        this.artist = artist;
//    }
//
//    public int getNumOfTracks() {
//        return numOfTracks;
//    }
//
//    public void setNumOfTracks(int numOfTracks) {
//        this.numOfTracks = numOfTracks;
//    }
//
//    public int getPlayingTime() {
//        return playingTime;
//    }
//
//    public void setPlayingTime(int playingTime) {
//        this.playingTime = playingTime;
//    }
//
//    public boolean isGotIt() {
//        return gotIt;
//    }
//
//    public void setGotIt(boolean gotIt) {
//        this.gotIt = gotIt;
//    }
//
//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }

    @Override
    public void print() {
        System.out.println("title:" + title + ";artist:" + artist);
    }
}

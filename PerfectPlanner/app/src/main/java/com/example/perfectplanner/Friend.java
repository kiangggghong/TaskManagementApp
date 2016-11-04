package com.example.perfectplanner;

/**
 * Created by fangy on 27/10/2016.
 */

public class Friend {
    private  String fname;
    private int iconID;

    public Friend(String fname, int iconID) {
        super();
        this.fname = fname;
        this.iconID = iconID;
    }

    public String getFname(){
        return fname;
    }

    public int geticonID(){
        return iconID;
    }
}
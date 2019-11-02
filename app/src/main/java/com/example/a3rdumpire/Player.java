package com.example.a3rdumpire;

public class Player {
    private int id;
    private String playername;

    public Player(int id, String playername) {
        this.id = id;
        this.playername = playername;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }



}

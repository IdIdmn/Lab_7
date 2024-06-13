package com.example.matchtracker.Entity;

import java.io.Serializable;

public class Player implements Serializable {

    private int imageResId;

    private String playerName;

    private String rating;

    private String dateOfCreate;

    private String winsNumber;

    private String defeatsNumber;

    private String favoriteMap;

    private String favoriteUnit;

    public Player(int imageResId, String playerName, String rating, String dateOfCreate, String winsNumber, String defeatsNumber, String favoriteMap, String favoriteUnit) {
        this.imageResId = imageResId;
        this.playerName = playerName;
        this.rating = rating;
        this.dateOfCreate = dateOfCreate;
        this.winsNumber = winsNumber;
        this.defeatsNumber = defeatsNumber;
        this.favoriteMap = favoriteMap;
        this.favoriteUnit = favoriteUnit;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(String dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public String getWinsNumber() {
        return winsNumber;
    }

    public void setWinsNumber(String winsNumber) {
        this.winsNumber = winsNumber;
    }

    public String getDefeatsNumber() {
        return defeatsNumber;
    }

    public void setDefeatsNumber(String defeatsNumber) {
        this.defeatsNumber = defeatsNumber;
    }

    public String getFavoriteMap() {
        return favoriteMap;
    }

    public void setFavoriteMap(String favoriteMap) {
        this.favoriteMap = favoriteMap;
    }

    public String getFavoriteUnit() {
        return favoriteUnit;
    }

    public void setFavoriteUnit(String favoriteUnit) {
        this.favoriteUnit = favoriteUnit;
    }

    public int getPlayedGames(){
        return Integer.parseInt(winsNumber) + Integer.parseInt(defeatsNumber);
    }

    public double getWinRate(){
        return Double.parseDouble(winsNumber) / getPlayedGames();
    }

}

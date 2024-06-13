package com.example.matchtracker.Entity;

import java.io.Serializable;

public class Match implements Serializable {

    private String firstPlayerName;

    private String secondPlayerName;

    private String startDatetime;

    private String endDateTime;

    private String winnerName;

    private String mapName;

    private String amountOfRounds;

    public Match(String firstPlayerName, String secondPlayerName, String startDatetime, String endDateTime, String winnerName, String mapName, String amountOfRounds) {
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
        this.startDatetime = startDatetime;
        this.endDateTime = endDateTime;
        this.winnerName = winnerName;
        this.mapName = mapName;
        this.amountOfRounds = amountOfRounds;
    }

    public Match() {
    }

    public String getFirstPlayerName() {
        return firstPlayerName;
    }

    public String getSecondPlayerName() {
        return secondPlayerName;
    }

    public String getStartDatetime() {
        return startDatetime;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public String getMapName() {
        return mapName;
    }

    public String getAmountOfRounds() {
        return amountOfRounds;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public void setFirstPlayerName(String firstPlayerName) {
        this.firstPlayerName = firstPlayerName;
    }

    public void setSecondPlayerName(String secondPlayerName) {
        this.secondPlayerName = secondPlayerName;
    }

    public void setStartDatetime(String startDatetime) {
        this.startDatetime = startDatetime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public void setAmountOfRounds(String amountOfRounds) {
        this.amountOfRounds = amountOfRounds;
    }
}

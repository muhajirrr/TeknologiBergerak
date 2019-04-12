package com.muhajirlatif.tekber.Model;

public class StandingsRow {
    private int rank;
    private String flagLink;
    private String country;
    private int gold;
    private int silver;
    private int bronze;

    public StandingsRow() {

    }

    public StandingsRow(int rank, String flagLink, String country, int gold, int silver, int bronze) {
        this.rank = rank;
        this.flagLink = flagLink;
        this.country = country;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getFlagLink() {
        return flagLink;
    }

    public void setFlagLink(String flagLink) {
        this.flagLink = flagLink;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getBronze() {
        return bronze;
    }

    public void setBronze(int bronze) {
        this.bronze = bronze;
    }

    public int getTotal() {
        return gold + silver + bronze;
    }
}

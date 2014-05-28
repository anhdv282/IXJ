/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/**
 *
 * @author DANG
 */
public class Match {
    int id;
    String kickoff;
    int stage;
    int team1;
    int team2;
    int venue;

    public Match(int id, String kickoff, int stage, int team1, int team2, int venue) {
        this.id = id;
        this.kickoff = kickoff;
        this.stage = stage;
        this.team1 = team1;
        this.team2 = team2;
        this.venue = venue;
    }

    public Match() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKickoff() {
        return kickoff;
    }

    public void setKickoff(String kickoff) {
        this.kickoff = kickoff;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getTeam1() {
        return team1;
    }

    public void setTeam1(int team1) {
        this.team1 = team1;
    }

    public int getTeam2() {
        return team2;
    }

    public void setTeam2(int team2) {
        this.team2 = team2;
    }

    public int getVenue() {
        return venue;
    }

    public void setVenue(int venue) {
        this.venue = venue;
    }
}

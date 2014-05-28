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
public class TeamBracket {
    int id;
    String label;
    int team;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public TeamBracket() {
    }

    public TeamBracket(int id, String label, int team) {
        this.id = id;
        this.label = label;
        this.team = team;
    }
    
}

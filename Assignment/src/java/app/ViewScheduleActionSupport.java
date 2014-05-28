/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

import com.opensymphony.xwork2.ActionSupport;
import dal.MatchDAL;
import entities.Match;
import java.util.List;

/**
 *
 * @author DucNM
 */
public class ViewScheduleActionSupport extends ActionSupport {
    
    private List<Match> matchs;
    private int team = 0;
    private String date = "";

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Match> getMatchs() {
        return matchs;
    }

    public void setMatchs(List<Match> matchs) {
        this.matchs = matchs;
    }
    
    public ViewScheduleActionSupport() {
    }
    
    public String execute() throws Exception {
        MatchDAL matchDAL = new MatchDAL();
        if (team > 0) {
            matchs = matchDAL.getMatchByTeam(team);
            return "team";
        } else if (!date.isEmpty()) {
            matchs = matchDAL.getMatchByDate(date);
            return "date";
        }
        matchs = matchDAL.getAllMatch();
        return SUCCESS;
    }
    
}

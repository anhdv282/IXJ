/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

import com.opensymphony.xwork2.ActionSupport;
import entities.Group;
import entities.Match;
import entities.Team;
import java.util.List;

/**
 *
 * @author DucNM
 */
public class ViewScheduleActionSupport extends ActionSupport {
    
    private List<Match> matchs;
    private Team team;
    private Group group;

    public List<Match> getMatchs() {
        return matchs;
    }

    public void setMatchs(List<Match> matchs) {
        this.matchs = matchs;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
    
    public ViewScheduleActionSupport() {
    }
    
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

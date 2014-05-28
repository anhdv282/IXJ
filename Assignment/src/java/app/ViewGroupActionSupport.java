/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

import com.opensymphony.xwork2.ActionSupport;
import dal.TeamDAL;
import entities.Team;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DANG
 */
public class ViewGroupActionSupport extends ActionSupport {
    List<Team> lst = new ArrayList<>();
    Team team;

    public List<Team> getLst() {
        return lst;
    }

    public void setLst(ArrayList<Team> lst) {
        this.lst = lst;
    }

    public Team getTeam() {
        return team;
    }
    TeamDAL dal = new TeamDAL();
    public ViewGroupActionSupport() {
    }
    
    public String execute() throws Exception {
        lst = dal.teamData();
        return "success";
    }
    
}

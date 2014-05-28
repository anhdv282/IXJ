/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

import com.opensymphony.xwork2.ActionSupport;
import dal.GroupDAL;
import dal.TeamDAL;
import entities.Group;
import entities.Team;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DANG
 */
public class ViewGroupActionSupport extends ActionSupport {
    List<Team> lst = new ArrayList<>();
    List<Group> groups = new ArrayList<>();
    Team team;
    
    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Team> getLst() {
        return lst;
    }

    public void setLst(ArrayList<Team> lst) {
        this.lst = lst;
    }

    public Team getTeam() {
        return team;
    }
    
    public ViewGroupActionSupport() {
    }
    
    public String execute() throws Exception {
        TeamDAL dal = new TeamDAL();
        GroupDAL groupDAL = new GroupDAL();
        lst = dal.teamData();
        groups = groupDAL.getAllGroup();
        return "success";
    }
    
}

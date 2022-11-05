package com.luo.team.service;

import com.luo.team.domain.Employee;
import com.luo.team.domain.Equipment;

public class TeamService {
    private static int tile=1;
    private int TID;
    private Employee employee;
    private int teamId;

    public TeamService() {
        TID = tile;
        tile+=1;
    }

    public static int getTile() {
        return tile;
    }

    public static void setTile(int tile) {
        TeamService.tile = tile;
    }

    public int getTID() {
        return TID;
    }

    public void setTID(int TID) {
        this.TID = TID;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public TeamService(Employee employee) {
        this.employee = employee;

    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public void setTeamId2(){
        this.teamId = this.teamId-1;
    }

    @Override
    public String toString() {
        return TID+"/"+employee.getToTeamService();
    }
}

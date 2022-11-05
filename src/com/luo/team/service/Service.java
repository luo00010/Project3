package com.luo.team.service;

import com.luo.team.domain.Architect;
import com.luo.team.domain.Designer;
import com.luo.team.domain.Employee;
import com.luo.team.domain.Programmer;

public class Service {
    private int intProrammer = 0;
    private int intDesigner = 0;
    private int intArchitect = 0;

    public void addTeam(Employee[] employees, TeamService[] teamServices, int num, int idex) throws MyException {
        if (employees[num] instanceof Architect) {
            if (intArchitect < 1) {
                Programmer pr0 = (Programmer) employees[num];
                if (pr0.getIsFalg() == "FREE") {
                    teamServices[idex] = new TeamService();
                    teamServices[idex].setEmployee(employees[num]);
                    teamServices[idex].setTeamId(idex);
                    intArchitect++;
                } else throw new MyException("该成员已加入过，加入失败！");
            } else throw new MyException("架构师已满");
        } else if (employees[num] instanceof Designer) {
            if (intDesigner < 2) {
                Programmer pr0 = (Programmer) employees[num];
                if (pr0.getIsFalg() == "FREE") {
                    teamServices[idex] = new TeamService();
                    teamServices[idex].setEmployee(employees[num]);
                    teamServices[idex].setTeamId(idex);

                    intDesigner++;
                } else throw new MyException("该成员已加入过，加入失败！");
            } else throw new MyException("设计师已满");
        } else if (employees[num] instanceof Programmer) {
            if (intProrammer < 3) {
                Programmer pr0 = (Programmer) employees[num];
                if (pr0.getIsFalg() == "FREE") {
                    teamServices[idex] = new TeamService();
                    teamServices[idex].setEmployee(employees[num]);
                    teamServices[idex].setTeamId(idex);

                    intProrammer++;
                } else throw new MyException("该成员已加入过，加入失败！");
            } else throw new MyException("程序员已满");
        } else if (employees[num] instanceof Employee) {
            throw new MyException("该成员不是开发人员");
        }

    }

    /**
     *
     * @param teamServices  删除团队员工操作
     * @param num           团队数组中的索引
     * @param idex          此时最后一个团队成员的索引
     * @throws MyException
     */
    public void deleTeam(TeamService[] teamServices, int num, int idex) throws MyException {
        if (idex < num) throw new MyException("输入超出Team");
        if (num==-1) throw new MyException("团队中没有此人，不能删除！");
        Programmer p = (Programmer) (teamServices[num].getEmployee());
        if (p.getJob() == "架构师") intArchitect--;
        if (p.getJob() == "程序员") intProrammer--;
        if (p.getJob() == "设计师") intDesigner--;
        for (; num < idex; num++) {
            teamServices[num + 1].setTeamId2();
            teamServices[num] = teamServices[num + 1];
        }
        teamServices[idex] = null;
    }

    public int getUidIdex(TeamService[] teamServices, int uid, int idex) throws MyException {
        for (int i = 0; i <= idex; i++) {
            if (teamServices[i].getTID() == uid) {
                return i;
            }
        }
        throw new MyException("团队里没有此UID的用户");
    }
}

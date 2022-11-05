package com.luo.team.service;

import com.luo.team.domain.Employee;

public class PrintView {
    public void printView(Employee[] employees){
        System.out.println("ID\t\t\t姓名\t\t年龄\t\t工资\t\t\t职位\t\t\t状态\t\t\t奖金\t\t\t股票\t\t领用设备");
        for (int i=0;i<employees.length;i++){
            System.out.println(employees[i].toString());
        }
    }
    public void printTeamView(TeamService[] teamService,int y) {
        System.out.println("-------------------团队成员列表------------------------");
        System.out.println("UID/ID\t姓名\t\t年龄\t工资\t\t职位\t\t奖金\t股票");
        if (teamService[0]!=null) {
            System.out.println("");
            for (int i = 0; i < y; i++) {
                System.out.println(teamService[i].toString());
            }
        }else System.out.println("开发团队目前没有成员！");
    }
}

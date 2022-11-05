package com.luo.team.view;

import com.luo.team.domain.Employee;
import com.luo.team.domain.Programmer;
import com.luo.team.service.*;

public class View {
    boolean is = true;
    int y = 0;
    NameListService nameListService = new NameListService();
    Employee[] employee = nameListService.getEmployees();
    PrintView printView = new PrintView();
    Service service = new Service();
    TeamService[] teamService = new TeamService[12];

    public void viewWhile() {
        printView.printView(employee);
        while (is) {
            System.out.println("1-团队列表\t2-添加团队成员\t3-删除团队成员\t4-退出  请选择（1-4）：");
            char x = TSUtility.readMenuSelection();
            switch (x) {
                case '1':
                    printView.printTeamView(teamService, y);
                    break;
                case '2':
                    add();
                    break;
                case '3':
                   dele();
                    break;
                case '4':
                    System.out.println("是否退出y/n");
                    if (TSUtility.readConfirmSelection() == 'Y') {
                        is = false;
                    }
                    break;

            }
        }
    }

    public void add(){
        System.out.println("请输入要添加的员工ID：");
        int num = TSUtility.readInt();
        try {
            service.addTeam(employee, teamService, num - 1, y);
            Programmer p = (Programmer) (employee[num - 1]);
            p.setIsFalg("BUSY");
            y++;
            System.out.println("添加成功");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } finally {
            TSUtility.readReturn();
            printView.printView(employee);
        }
    }

    public void dele(){
        System.out.println("请输入要删除员工的UID");
        int uid = TSUtility.readInt();
        System.out.println("是否删除y/n");
        if (TSUtility.readConfirmSelection() == 'Y' && teamService[0] != null) {
            try {
                int teamUidIndex = service.getUidIdex(teamService, uid, y - 1);
                Programmer p = null;
                int index = teamService[teamUidIndex].getEmployee().getId() - 1;
                p = (Programmer) (employee[index]);
                service.deleTeam(teamService, teamUidIndex, y - 1);
                p.setIsFalg("FREE");
                y--;
                System.out.println("删除成功");
            } catch (MyException e) {
                System.out.println(e.getMessage());
            } finally {
                TSUtility.readReturn();
                printView.printView(employee);
            }
        } else {
            System.out.println("----现在团队没有成员！！----");
            TSUtility.readReturn();
            printView.printView(employee);
        }
    }



    public static void main(String[] args) {
        View v = new View();
        v.viewWhile();
    }
}

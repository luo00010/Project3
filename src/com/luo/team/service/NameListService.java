package com.luo.team.service;

import com.luo.team.domain.*;

public class NameListService {
    private Employee[] employees;
    public NameListService(){
        employees = new Employee[Data.EMPLOYEES.length];
        for (int i=0;i<Data.EMPLOYEES.length;i++)
        {
            String type = Data.EMPLOYEES[i][0];
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
            switch (type){
                case "10":
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case "11":
                    Equipment equipment = new Printer(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]);
                    employees[i] = new Programmer(id,name,age,salary,"程序员",equipment);
                    break;
                case "12":
                    double bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    Equipment equipment2 = new Printer(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]);
                    employees[i] = new Designer(id,name,age,salary,"设计师",bonus,equipment2);
                    break;
                case "13":
                    double bonus1 = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    int storck = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    Equipment equipment3 = new Printer(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]);
                    employees[i] = new Architect(id,name,age,salary,"架构师",bonus1,storck,equipment3);
                    break;

            }

        }

    }

    public Employee[] getEmployees() {
        return employees;
    }
}

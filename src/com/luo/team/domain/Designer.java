package com.luo.team.domain;

public class Designer extends  Programmer{
    private double bonus;

    public Designer(int id, String name, int age, double salary, String job, double bonus,Equipment equipment) {
        super(id, name, age, salary, job,equipment);
        this.bonus = bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return getId()+"\t\t"+getName()+"\t\t"+getAge()+"\t\t"+getSalary()+"\t\t"+getJob()+"\t\t"+getIsFalg()+"\t\t"+getBonus()+"\t\t\t\t"+getEquipment().getDescription();
    }
    public String getToTeamService(){
        return getId()+"\t\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t"+getJob()+"\t"+getBonus();
    }
}

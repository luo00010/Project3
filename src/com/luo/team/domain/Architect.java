package com.luo.team.domain;

public class Architect extends Designer{
    private int storck;

    public Architect(int id, String name, int age, double salary, String job, double bonus, int storck,Equipment equipment) {
        super(id, name, age, salary, job, bonus,equipment);
        this.storck = storck;
    }

    public void setStorck(int storck) {
        this.storck = storck;
    }

    public int getStorck() {
        return storck;
    }

    @Override
    public String toString() {
        return getId()+"\t\t"+getName()+"\t\t"+getAge()+"\t\t"+getSalary()+"\t\t"+getJob()+"\t\t"+getIsFalg()+"\t\t"+getBonus()+"\t\t"+getStorck()+"\t"+getEquipment().getDescription();
    }
    public String getToTeamService(){
        return getId()+"\t\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t"+getJob()+"\t"+getStorck();
    }
}

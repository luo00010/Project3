package com.luo.team.domain;

public class Programmer extends Employee{
    private String job;
    private String isFalg="FREE";
    private Equipment equipment;

    public Programmer(int id, String name, int age, double salary, String job,Equipment equipment) {
        super(id, name, age, salary);
        this.job = job;
        this.equipment = equipment;

    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setIsFalg(String isFalg) {
        this.isFalg = isFalg;
    }

    public String getIsFalg() {
        return isFalg;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return getId()+"\t\t"+getName()+"\t\t"+getAge()+"\t\t"+getSalary()+"\t\t"+getJob()+"\t\t"+getIsFalg()+"\t\t\t\t\t\t\t"+equipment.getDescription();
    }
    public String getToTeamService(){
        return getId()+"\t\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t"+getJob();
    }
}

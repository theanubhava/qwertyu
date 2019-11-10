package com.practice.splitwise.pojo;

public class UserBean {
    private String name;
    private String id;
    private double paidByMeAmt;
    private double paidForMeAmt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPaidForMeAmt() {
        return paidForMeAmt;
    }

    public void setPaidForMeAmt(double paidForMeAmt) {
        this.paidForMeAmt = paidForMeAmt;
    }

    public double getPaidByMeAmt() {
        return paidByMeAmt;
    }

    public void setPaidByMeAmt(double paidByMeAmt) {
        this.paidByMeAmt = paidByMeAmt;
    }
}

package com.practice.splitwise.pojo;

public class Transaction {
    private String paidByUserID;
    private String paidForUserID;
    private Double amount;

    public String getPaidByUserID() {
        return paidByUserID;
    }

    public void setPaidByUserID(String paidByUserID) {
        this.paidByUserID = paidByUserID;
    }

    public String getPaidForUserID() {
        return paidForUserID;
    }

    public void setPaidForUserID(String paidForUserID) {
        this.paidForUserID = paidForUserID;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}

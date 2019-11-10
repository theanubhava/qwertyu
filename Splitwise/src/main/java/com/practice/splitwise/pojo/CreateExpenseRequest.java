package com.practice.splitwise.pojo;

import java.util.List;
import java.util.Map;

public class CreateExpenseRequest {
    private String paidByUserId;
    private double totAmt;
    private ExpenseType expenseType;
    private List<String> involvedUsersID;
    private Map<String,Double> perUserShareMap;
    private boolean shareMapUpdated;

    public String getPaidByUserId() {
        return paidByUserId;
    }

    public void setPaidByUserId(String paidByUserId) {
        this.paidByUserId = paidByUserId;
    }

    public double getTotAmt() {
        return totAmt;
    }

    public void setTotAmt(double totAmt) {
        this.totAmt = totAmt;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public List<String> getInvolvedUsersID() {
        return involvedUsersID;
    }

    public void setInvolvedUsersID(List<String> involvedUsersID) {
        this.involvedUsersID = involvedUsersID;
    }

    public Map<String, Double> getPerUserShareMap() {
        if(!shareMapUpdated)
            populatePerUserShareMap();
        return perUserShareMap;
    }

    private void populatePerUserShareMap() {

        if(expenseType.equals(ExpenseType.EQUAL)) {
            double perPersonShare = totAmt / (involvedUsersID.size() + 1);
            for (String uid : involvedUsersID) {
                perUserShareMap.put(uid, perPersonShare);
            }
            perUserShareMap.put(paidByUserId,perPersonShare);
        }else if(expenseType.equals(ExpenseType.EQUAL)){
            double tot=0.0;
            for (String uid : involvedUsersID) {
                double personShare = (totAmt/100) * (perUserShareMap.get(uid));
                tot+=personShare;
                perUserShareMap.put(uid, personShare);
            }
            perUserShareMap.put(paidByUserId,totAmt-tot);
        }
        shareMapUpdated=true;
    }

    public void setPerUserShareMap(Map<String, Double> perUserShareMap) {
        this.perUserShareMap = perUserShareMap;
    }

}

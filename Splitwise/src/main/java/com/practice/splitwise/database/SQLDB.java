package com.practice.splitwise.database;

import com.practice.splitwise.pojo.Transaction;
import com.practice.splitwise.pojo.UserBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLDB {
    private static SQLDB sqldb=new SQLDB();
    private SQLDB(){ }
    public static SQLDB getInstance(){
        return sqldb;
    }
    private Map<String,UserBean> userMap=new HashMap<String,UserBean>();
    private List<Transaction> transactionList = new ArrayList<>();
    private Map<String, List<Transaction>> paidByUserMap = new HashMap<>();
    private Map<String, List<Transaction>> paidForUserMap = new HashMap<>();

    public String addUsers(List<UserBean> userList) {
        if(userMap==null)
            userMap=new HashMap<String,UserBean>();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(UserBean userBean:userList){
            if(userMap.get(userBean.getId())==null) {
                userMap.put(userBean.getId(), userBean);
                sb1.append(userBean.getId()+",");
            } else {
                sb2.append(userBean.getId() + ",");
            }
        }
        sb1.append("--CREATED||||");
        sb2.append("--EXISTING");
        return sb1.append(sb2).toString();
    }

    public String logExpense(List<Transaction> transactionList) {

        this.transactionList.addAll(transactionList);

        for(Transaction tr : transactionList){
            String paidby = tr.getPaidByUserID();
            String paidfor = tr.getPaidForUserID();
            if(paidByUserMap.get(paidby)==null)
                paidByUserMap.put(paidby,new ArrayList<Transaction>());
            List<Transaction> paidByTRList = paidByUserMap.get(paidby);
            paidByTRList.add(tr);
            paidByUserMap.put(paidby,paidByTRList);

            if(paidForUserMap.get(paidfor)==null)
                paidForUserMap.put(paidfor,new ArrayList<Transaction>());
            List<Transaction> paidForTRList = paidForUserMap.get(paidfor);
            paidForTRList.add(tr);
            paidForUserMap.put(paidfor,paidForTRList);
        }

        return "added-"+transactionList.size()+" transactions";
    }

    public String updateUsers(List<UserBean> userList) {
        for(UserBean user : userList){
            userMap.put(user.getId(),user);
        }
        return "updated users after transaction";
    }

    public List<UserBean> getUserList(List<String> userIDList) {
        List<UserBean> ret = new ArrayList<>();
        for(String id : userIDList){
            ret.add(userMap.get(id));
        }
        return ret;
    }

    public List<UserBean> getAllUsers() {
        List<UserBean> ret = new ArrayList<>();
        for(Map.Entry<String,UserBean> entry : userMap.entrySet()){
            ret.add(entry.getValue());
        }
        return ret;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public Map<String, List<Transaction>> getPaidByUserMap() {
        return paidByUserMap;
    }

    public void setPaidByUserMap(Map<String, List<Transaction>> paidByUserMap) {
        this.paidByUserMap = paidByUserMap;
    }

    public Map<String, List<Transaction>> getPaidForUserMap() {
        return paidForUserMap;
    }

    public void setPaidForUserMap(Map<String, List<Transaction>> paidForUserMap) {
        this.paidForUserMap = paidForUserMap;
    }


    public Map<String, UserBean> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, UserBean> userMap) {
        this.userMap = userMap;
    }
}

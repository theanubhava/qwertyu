package com.practice.splitwise.service.impl;

import com.practice.splitwise.dao.UserDAO;
import com.practice.splitwise.pojo.*;
import com.practice.splitwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Override
    public String createUsers(List<UserBean> userList) {

        return userDAO.createUsers(userList);
    }

    @Override
    public String updateUsers(CreateExpenseRequest expenseReq) {
        List<String> userIDList = new ArrayList<>();
        userIDList.addAll(expenseReq.getInvolvedUsersID());
        userIDList.add(expenseReq.getPaidByUserId());

        List<UserBean> userBeanList = userDAO.getUserList(userIDList);
        Map<String, UserBean> userIDMap = new HashMap<>();
        for (UserBean userBean : userBeanList) {
            userIDMap.put(userBean.getId(), userBean);
        }

        String paidByUserID = expenseReq.getPaidByUserId();

        List<UserBean> updatedUserBeanList = new ArrayList<>();
        for (Map.Entry<String, Double> e : expenseReq.getPerUserShareMap().entrySet()) {
            String paidForUserID = e.getKey();

            if(!paidForUserID.equalsIgnoreCase(paidByUserID)) {
                UserBean userBean = userIDMap.get(paidForUserID);
                userBean.setPaidForMeAmt(userBean.getPaidForMeAmt() + e.getValue());
                updatedUserBeanList.add(userBean);
            }
        }

        UserBean userBean = userIDMap.get(paidByUserID);
        userBean.setPaidByMeAmt(userBean.getPaidByMeAmt() + expenseReq.getTotAmt() );
        updatedUserBeanList.add(userBean);

        return userDAO.updateUsers(updatedUserBeanList);
    }

    @Override
    public List<UserBean> getUsers(List<String> userIDList) {
        if (userIDList.size() == 0)
            return userDAO.getAllUsers();
        return userDAO.getUserList(userIDList);
    }

    @Override
    public UserBalances settleUser(String userID) {
        List<Transaction> paidByUserTRList  = userDAO.getPaidByUserTRList(userID);
        List<Transaction> paidForUserTRList = userDAO.getPaidForUserTRList(userID);
        Map<String, Double> userBalanceMapCombined = new HashMap<>();

        for (Transaction tr : paidByUserTRList) {
            if (tr.getPaidByUserID().equalsIgnoreCase(userID)) {
                String paidForUser = tr.getPaidForUserID();
                double amount = tr.getAmount();
                if (userBalanceMapCombined.get(paidForUser) == null)
                    userBalanceMapCombined.put(paidForUser, amount);
                else
                    userBalanceMapCombined.put(paidForUser, userBalanceMapCombined.get(paidForUser) + amount);
            }
        }

        for (Transaction tr : paidForUserTRList) {
            if (tr.getPaidForUserID().equalsIgnoreCase(userID)) {
                String paidByUserID = tr.getPaidByUserID();
                double amount = tr.getAmount();
                if (userBalanceMapCombined.get(paidByUserID) == null)
                    userBalanceMapCombined.put(paidByUserID, -1 * amount);
                else
                    userBalanceMapCombined.put(paidByUserID, userBalanceMapCombined.get(paidByUserID) - amount);
            }
        }
        UserBalances userBalances = getUserBalanceFromCombiMap(userBalanceMapCombined);
        return userBalances;
    }

    private UserBalances getUserBalanceFromCombiMap(Map<String, Double> userBalanceMapCombined) {
        UserBalances userBalances = new UserBalances();

        for (Map.Entry<String, Double> en : userBalanceMapCombined.entrySet()) {
            if (en.getValue() > 0) {
                Map<String, Double> collectMap = new HashMap<>();
                collectMap.put(en.getKey(), en.getValue());
                userBalances.getCollectFrom().add(collectMap);
            }
            if (en.getValue() < 0) {
                Map<String, Double> payMap = new HashMap<>();
                payMap.put(en.getKey(), en.getValue());
                userBalances.getPayTo().add(payMap);
            }
        }
        return userBalances;
    }
}

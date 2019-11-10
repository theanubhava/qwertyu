package com.practice.splitwise.service.impl;

import com.practice.splitwise.dao.ExpenseDAO;
import com.practice.splitwise.dao.UserDAO;
import com.practice.splitwise.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    ExpenseDAO expenseDAO;
    @Autowired
    UserDAO userDAO;

    @Override
    public String createExpense(CreateExpenseRequest expenseReq) {
        List<Transaction> transactionList = new ArrayList<>();

        for(String userid : expenseReq.getInvolvedUsersID()){
            Transaction tr = new Transaction();
            tr.setAmount(expenseReq.getPerUserShareMap().get(userid));
            tr.setPaidByUserID(expenseReq.getPaidByUserId());
            tr.setPaidForUserID(userid);
            transactionList.add(tr);
        }
        return expenseDAO.createExpense(transactionList);
    }

    /*private double getAmount(String id, CreateExpenseRequest expenseReq) {
        double amt =0.0;
        if(expenseReq.getExpenseType().equals(ExpenseType.EQUAL))
            amt = expenseReq.getTotAmt()/(expenseReq.getInvolvedUsersID().size()+1);
        if(expenseReq.getExpenseType().equals(ExpenseType.SHARE)){
            amt = expenseReq.getPerUserShareMap().get(id);
        }
        if(expenseReq.getExpenseType().equals(ExpenseType.PERCENTAGE)){
            amt = (expenseReq.getTotAmt()/100)*expenseReq.getPerUserShareMap().get(id);
        }
        return amt;
    }*/
}

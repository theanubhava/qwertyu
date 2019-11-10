package com.practice.splitwise.dao.impl;

import com.practice.splitwise.dao.ExpenseDAO;
import com.practice.splitwise.database.SQLDB;
import com.practice.splitwise.pojo.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExpenseDAOImpl implements ExpenseDAO {
    private SQLDB sqldb = SQLDB.getInstance();

    @Override
    public String createExpense(List<Transaction> transactionList) {
        return sqldb.logExpense(transactionList);
    }
}

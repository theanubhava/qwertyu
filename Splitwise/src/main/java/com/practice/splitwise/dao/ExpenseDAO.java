package com.practice.splitwise.dao;

import com.practice.splitwise.pojo.Transaction;

import java.util.List;

public interface ExpenseDAO {
    String createExpense(List<Transaction> transactionList);
}

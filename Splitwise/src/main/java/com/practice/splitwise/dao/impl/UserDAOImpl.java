package com.practice.splitwise.dao.impl;

import com.practice.splitwise.dao.UserDAO;
import com.practice.splitwise.database.SQLDB;
import com.practice.splitwise.pojo.Transaction;
import com.practice.splitwise.pojo.UserBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {
    private SQLDB sqldb = SQLDB.getInstance();
    @Override
    public String createUsers(List<UserBean> userList) {
        return sqldb.addUsers(userList);
    }

    @Override
    public String updateUsers(List<UserBean> userList) {
        return sqldb.updateUsers(userList);
    }

    @Override
    public List<UserBean> getUserList(List<String> userIDList) {
        return sqldb.getUserList(userIDList);
    }

    @Override
    public List<UserBean> getAllUsers() {
        return sqldb.getAllUsers();
    }

    @Override
    public List<Transaction> getPaidByUserTRList(String userID) {
        return sqldb.getPaidByUserMap().get(userID)!=null?
                sqldb.getPaidByUserMap().get(userID):
                new ArrayList<>();
    }

    @Override
    public List<Transaction> getPaidForUserTRList(String userID) {
        return sqldb.getPaidForUserMap().get(userID)!=null?
                sqldb.getPaidForUserMap().get(userID):
                new ArrayList<>();
    }
}

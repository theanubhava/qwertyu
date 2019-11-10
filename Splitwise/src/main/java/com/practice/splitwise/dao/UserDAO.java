package com.practice.splitwise.dao;

import com.practice.splitwise.pojo.Transaction;
import com.practice.splitwise.pojo.UserBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDAO {
    public String createUsers(List<UserBean>  userList);

    public String updateUsers(List<UserBean> userList);

    public List<UserBean> getUserList(List<String> userIDList);

    public List<UserBean> getAllUsers();

    public List<Transaction> getPaidByUserTRList(String userID);

    public List<Transaction> getPaidForUserTRList(String userID);
}

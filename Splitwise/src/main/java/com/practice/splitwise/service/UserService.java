package com.practice.splitwise.service;

import com.practice.splitwise.pojo.CreateExpenseRequest;
import com.practice.splitwise.pojo.UserBalances;
import com.practice.splitwise.pojo.UserBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

    public String createUsers(List<UserBean> userList);

    public String updateUsers(CreateExpenseRequest expenseReq);

    public List<UserBean> getUsers(List<String> userIDList);

    public UserBalances settleUser(String userID);
}

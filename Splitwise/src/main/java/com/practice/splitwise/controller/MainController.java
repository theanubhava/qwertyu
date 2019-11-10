package com.practice.splitwise.controller;

import com.practice.splitwise.pojo.CreateExpenseRequest;
import com.practice.splitwise.pojo.ExpenseService;
import com.practice.splitwise.pojo.UserBalances;
import com.practice.splitwise.pojo.UserBean;
import com.practice.splitwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    UserService userService;
    @Autowired
    ExpenseService expenseService;

    @RequestMapping(value = "/create/users", method = RequestMethod.POST)
    public String createUsers(@RequestBody List<UserBean> userList) {
        String res = userService.createUsers(userList);
        System.out.println(res);
        return  res;
    }

    @RequestMapping(value = "/create/expense", method = RequestMethod.POST)
    public String createExpense(@RequestBody CreateExpenseRequest expenseReq) {

        String res  = expenseService.createExpense(expenseReq);
        String res2 = userService.updateUsers(expenseReq);
        System.out.println(res);
        return  res;
    }

    @RequestMapping(value = "/settle/user", method = RequestMethod.GET)
    public UserBalances getAllUsers(@RequestBody String userID) {
        return userService.settleUser(userID);
    }

    @RequestMapping(value = "/get/users", method = RequestMethod.GET)
    public List<UserBean> getAllUsers(@RequestBody List<String> userIDList) {
        return userService.getUsers(userIDList);
    }
}

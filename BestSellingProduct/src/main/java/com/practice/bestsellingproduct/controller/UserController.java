package com.practice.bestsellingproduct.controller;

import com.practice.bestsellingproduct.pojo.UserBean;
import com.practice.bestsellingproduct.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createUsers(@RequestBody List<UserBean> userList) {
        String res = userService.createUsers(userList);
        System.out.println(res);
        return  res;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteUser(@RequestBody List<UserBean> userList) {
        String res = userService.deleteUsers(userList);
        System.out.println(res);
        return  res;
    }

    @RequestMapping(value = "/blacklist", method = RequestMethod.POST)
    public String blackListUser(@RequestBody List<UserBean> userList) {
        String res = userService.blackListUsers(userList);
        System.out.println(res);
        return  res;
    }

}

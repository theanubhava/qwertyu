package com.practice.bestsellingproduct.service;

import com.practice.bestsellingproduct.pojo.UserBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

    public String createUsers(List<UserBean> userList);
    public String deleteUsers(List<UserBean> userList);
    public String blackListUsers(List<UserBean> userList);


}

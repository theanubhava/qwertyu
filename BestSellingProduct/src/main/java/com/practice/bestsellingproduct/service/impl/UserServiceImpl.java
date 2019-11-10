package com.practice.bestsellingproduct.service.impl;

import com.practice.bestsellingproduct.database.SQLDB;
import com.practice.bestsellingproduct.pojo.UserBean;
import com.practice.bestsellingproduct.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    SQLDB sqldb = SQLDB.getInstance();

    @Override
    public String createUsers(List<UserBean> userList) {
        StringBuilder sb = new StringBuilder();
        for (UserBean user : userList) {
            sqldb.getActiveUserDetailsMap().put(user.getId(), user);
            sb.append(user.getId()).append(",");
        }
        return "created " + userList.size() + " users---"+sb.toString();
    }

    @Override
    public String deleteUsers(List<UserBean> userList) {
        StringBuilder sb = new StringBuilder();
        for (UserBean user : userList) {
            sqldb.getActiveUserDetailsMap().remove(user.getId());
            sqldb.getBlackListedUserDetailsMap().remove(user.getId());
            sb.append(user.getId()).append(",");
        }
        return "deleted " + userList.size() + " users---"+sb.toString();
    }

    @Override
    public String blackListUsers(List<UserBean> userList) {
        StringBuilder sb = new StringBuilder();
        for (UserBean user : userList) {
            UserBean user1 = sqldb.getActiveUserDetailsMap().get(user.getId());
            user1.setBlackListed(true);
            sqldb.getBlackListedUserDetailsMap().put(user1.getId(), user1);
            sqldb.getActiveUserDetailsMap().remove(user1.getId());
            sb.append(user.getId()).append(",");
        }
        return "blackListed " + userList.size() + " users---"+sb.toString();
    }


}

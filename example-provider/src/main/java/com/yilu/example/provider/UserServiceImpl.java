package com.yilu.example.provider;

import com.yilu.example.common.model.User;
import com.yilu.example.common.service.UserService;

public class UserServiceImpl implements UserService {

    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}

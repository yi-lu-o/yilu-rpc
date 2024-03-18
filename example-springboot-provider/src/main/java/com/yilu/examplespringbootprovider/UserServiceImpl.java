package com.yilu.examplespringbootprovider;

import com.yilu.example.common.model.User;
import com.yilu.example.common.service.UserService;
import com.yilu.yilurpc.springboot.starter.annotation.RpcService;
import org.springframework.stereotype.Service;

@Service
@RpcService
public class UserServiceImpl implements UserService {

    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}

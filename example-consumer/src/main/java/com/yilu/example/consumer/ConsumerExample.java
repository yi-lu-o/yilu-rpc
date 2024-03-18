package com.yilu.example.consumer;

import com.yilu.example.common.model.User;
import com.yilu.example.common.service.UserService;
import com.yilu.yilurpc.bootstrap.ConsumerBootstrap;
import com.yilu.yilurpc.proxy.ServiceProxyFactory;

public class ConsumerExample {

    public static void main(String[] args) {
        // 服务提供者初始化
        ConsumerBootstrap.init();

        // 获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("yupi");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}

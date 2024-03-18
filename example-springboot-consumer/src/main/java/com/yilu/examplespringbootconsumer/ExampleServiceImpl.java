package com.yilu.examplespringbootconsumer;

import com.yilu.example.common.model.User;
import com.yilu.example.common.service.UserService;
import com.yilu.yilurpc.springboot.starter.annotation.RpcReference;

public class ExampleServiceImpl {

    /**
     * 使用 Rpc 框架注入
     */
    @RpcReference
    private UserService userService;

    /**
     * 测试方法
     */
    public void test() {
        User user = new User();
        user.setName("yupi");
        User resultUser = userService.getUser(user);
        System.out.println(resultUser.getName());
    }

}

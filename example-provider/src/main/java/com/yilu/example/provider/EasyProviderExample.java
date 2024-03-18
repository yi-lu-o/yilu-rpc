package com.yilu.example.provider;

import com.yilu.example.common.service.UserService;
import com.yilu.yilurpc.registry.LocalRegistry;
import com.yilu.yilurpc.server.HttpServer;
import com.yilu.yilurpc.server.VertxHttpServer;

public class EasyProviderExample {

    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}

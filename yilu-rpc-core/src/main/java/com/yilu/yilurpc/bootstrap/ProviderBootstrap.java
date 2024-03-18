package com.yilu.yilurpc.bootstrap;

import com.yilu.yilurpc.RpcApplication;
import com.yilu.yilurpc.config.RegistryConfig;
import com.yilu.yilurpc.config.RpcConfig;
import com.yilu.yilurpc.model.ServiceMetaInfo;
import com.yilu.yilurpc.model.ServiceRegisterInfo;
import com.yilu.yilurpc.registry.LocalRegistry;
import com.yilu.yilurpc.registry.Registry;
import com.yilu.yilurpc.registry.RegistryFactory;
import com.yilu.yilurpc.server.tcp.VertxTcpServer;

import java.util.List;


public class ProviderBootstrap {

    /**
     * 初始化
     */
    public static void init(List<ServiceRegisterInfo<?>> serviceRegisterInfoList) {
        // RPC 框架初始化（配置和注册中心）
        RpcApplication.init();
        // 全局配置
        final RpcConfig rpcConfig = RpcApplication.getRpcConfig();

        // 注册服务
        for (ServiceRegisterInfo<?> serviceRegisterInfo : serviceRegisterInfoList) {
            String serviceName = serviceRegisterInfo.getServiceName();
            // 本地注册
            LocalRegistry.register(serviceName, serviceRegisterInfo.getImplClass());

            // 注册服务到注册中心
            RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
            Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
            ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
            serviceMetaInfo.setServiceName(serviceName);
            serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
            serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
            try {
                registry.register(serviceMetaInfo);
            } catch (Exception e) {
                throw new RuntimeException(serviceName + " 服务注册失败", e);
            }
        }

        // 启动服务器
        VertxTcpServer vertxTcpServer = new VertxTcpServer();
        vertxTcpServer.doStart(rpcConfig.getServerPort());
    }
}

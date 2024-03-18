package com.yilu.yilurpc.fault.tolerant;

import com.yilu.yilurpc.model.RpcResponse;

import java.util.Map;


public interface TolerantStrategy {

    /**
     * 容错
     *
     * @param context 上下文，用于传递数据
     * @param e       异常
     * @return
     */
    RpcResponse doTolerant(Map<String, Object> context, Exception e);
}

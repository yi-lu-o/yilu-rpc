package com.yilu.yilurpc.fault.retry;

import com.yilu.yilurpc.model.RpcResponse;

import java.util.concurrent.Callable;


public interface RetryStrategy {

    /**
     * 重试
     *
     * @param callable
     * @return
     * @throws Exception
     */
    RpcResponse doRetry(Callable<RpcResponse> callable) throws Exception;
}

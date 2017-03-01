package com.lenzhao.service.impl;

import com.lenzhao.api.UserService;
import com.lenzhao.framework.client.RpcClientProxy;
import com.lenzhao.framework.common.RpcContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by lenzhao on 17-2-27.
 */
public class UserServiceImpl implements UserService {

    private static UserService userService = null;

    static {
        try {
            userService = RpcClientProxy.proxy(UserService.class, "server", "userService");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void login(String userName, String password) {
        userService.login(userName, password);
    }

    @Override
    public String getUserInfo(String userName) {
        userService.getUserInfo(userName);
        Future<String> future = RpcContext.getContext().getFuture();
        String msg = null;
        try {
            msg =  future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
}

package com.lenzhao.service.impl;

import com.lenzhao.framework.client.RpcClientProxy;
import com.lenzhao.framework.common.RpcContext;
import com.lenzhao.service.UserService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.login("lenzhao", "112233");
        System.out.println(userService.getUserInfo("lenzhao"));
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return msg;
    }
}

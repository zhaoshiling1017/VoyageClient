package com.lenzhao.service;

/**
 * Created by lenzhao on 17-2-27.
 */
public interface UserService {
    void login(String userName, String password);
    String getUserInfo(String userName);
}

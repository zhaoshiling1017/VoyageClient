package com.lenzhao.bootstrap;

import com.lenzhao.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lenzhao on 17-3-1.
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.login("lenzhao", "112233");
        //logger.info(userService.getUserInfo("lenzhao"));
    }

}

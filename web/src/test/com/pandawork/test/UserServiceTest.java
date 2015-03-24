package com.pandawork.test;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserServiceTest
 *
 * @author: zhangteng
 * @time: 2015/3/24 20:02
 */
public class UserServiceTest extends AbstractTestCase {

    @Autowired
    private UserService userService;

    @Test
    public void newUser() throws SSException {
        User user = new User();
        user.setUserName("admin");
        user.setPassword("123456");

        userService.newUser(user);
    }
}

package com.pandawork.service;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserService
 *
 * @author: zhangteng
 * @time: 2015/3/24 19:25
 */
public interface UserService {

    public void newUser(@Param("user") User user) throws SSException;

    public void update(@Param("user") User user) throws SSException;

    public void deleteById(@Param("id") int id) throws SSException;

    public List<User> listAll() throws SSException;

    public User queryById(@Param("id") int id) throws SSException;

    public boolean checkLogin(User user) throws SSException;
}

package com.pandawork.service;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;

import java.util.List;

/**
 * UserService
 *
 * @author: zhangteng
 * @time: 2015/3/24 19:25
 */
public interface UserService {

    public void newUser(User user) throws SSException;

    public void update(User user) throws SSException;

    public void deleteById(int id) throws SSException;

    public List<User> listAll() throws SSException;

    public User queryById(int id) throws SSException;

    public boolean checkLogin(User user) throws SSException;
}

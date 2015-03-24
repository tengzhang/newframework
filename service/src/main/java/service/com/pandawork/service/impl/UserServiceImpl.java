package com.pandawork.service.impl;

import com.pandawork.common.entity.User;
import com.pandawork.common.exception.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.core.common.util.CommonUtil;
import com.pandawork.mapper.UserMapper;
import com.pandawork.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImpl
 *
 * @author: zhangteng
 * @time: 2015/3/24 19:26
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void newUser(@Param("user") User user) throws SSException {
        if (Assert.isNull(user)) {
            return ;
        }

        // 判断用户名和密码是否为空
        Assert.isNotNull(user.getUserName(), NFException.UserNameNotNull);
        Assert.isNotNull(user.getPassword(), NFException.PasswordNotNull);

        try {
            user.setPassword(CommonUtil.md5(user.getPassword()));
            userMapper.newUser(user);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public void update(@Param("user") User user) throws SSException {
        if (Assert.isNull(user)) {
            return ;
        }

        // 判断用户名和密码是否为空
        Assert.isNotNull(user.getUserName(), NFException.UserNameNotNull);
        Assert.isNotNull(user.getPassword(), NFException.PasswordNotNull);

        try {
            userMapper.update(user);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public void deleteById(@Param("id") int id) throws SSException {
        if (Assert.lessOrEqualZero(id)) {
            return ;
        }

        try {
            userMapper.deleteById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public List<User> listAll() throws SSException {
        try {
            return userMapper.listAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public User queryById(@Param("id") int id) throws SSException {
        if (Assert.lessOrEqualZero(id)) {
            return null;
        }
        try {
            return userMapper.queryById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public boolean checkLogin(User user) throws SSException {
        if (Assert.isNull(user)) {
            return false;
        }

        try {
            user.setPassword(CommonUtil.md5(user.getPassword()));
            return userMapper.countByUserNameAndPassword(user.getUserName(), user.getPassword()) > 0 ? true : false;
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }
}

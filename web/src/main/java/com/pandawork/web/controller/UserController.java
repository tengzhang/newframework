package com.pandawork.web.controller;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * UserController
 *
 * @author: zhangteng
 * @time: 2015/3/24 19:35
 */
@Controller()
@RequestMapping("user")
public class UserController extends AbstractController {

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toList(Model model) {
        try {
            List<User> userList = userService.listAll();
            model.addAttribute("userList", userList);
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }

        return "user/list";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String toNew() {
        return "user/new";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String newUser(User user) {
        try {
            userService.newUser(user);
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return "user/new";
        }

        return "redirect:/user/list";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id,
                           Model model) {
        try {
            User user = userService.queryById(id);
            model.addAttribute("user", user);
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }

        return "user/update";
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String update(User user) {
        try {
            userService.update(user);
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return "user/update";
        }
        return "redirect:/user/list";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteById(@PathVariable("id") Integer id) {
        try {
            userService.deleteById(id);
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }

        return "redirect:/user/list";
    }
}

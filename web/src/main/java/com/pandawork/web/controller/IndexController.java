package com.pandawork.web.controller;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * IndexController
 *
 * @author: zhangteng
 * @time: 2015/3/24 16:57
 */
@Controller
@RequestMapping(value = "")
public class IndexController extends AbstractController {

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String toIndex(Model model) {
        model.addAttribute("msg", "Hello world!");
        return "index";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User user,
                        Model model) {
        try {
            if (userService.checkLogin(user)) {
                model.addAttribute("user", user);
                return "index";
            } else {
                return "login";
            }
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }
}

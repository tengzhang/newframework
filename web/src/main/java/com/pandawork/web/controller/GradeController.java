package com.pandawork.web.controller;

import com.pandawork.common.entity.Grade;
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
 * GradeController
 *
 * @author: zhangteng
 * @time: 2015/3/25 10:43
 */
@Controller
@RequestMapping(value = "grade")
public class GradeController extends AbstractController {

    /**
     * 列表
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toList(Model model) {
        try {
            List<Grade> gradeList = gradeService.listAll();
            model.addAttribute("gradeList", gradeList);
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
        return "grade/list";
    }

    /**
     * 去添加年级
     *
     * @return
     */
    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String toNew() {
        return "grade/new";
    }

    /**
     * 添加年级提交
     *
     * @param grade
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String newGrade(Grade grade) {
        try {
            gradeService.newGrade(grade);
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return "grade/new";
        }

        return "redirect:/grade/list";
    }

    /**
     * 去更新
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id,
                           Model model) {
        try {
            Grade grade = gradeService.queryById(id);
            model.addAttribute("grade", grade);
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }

        return "grade/update";
    }

    /**
     * 更新提交
     *
     * @param grade
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String update(Grade grade) {
        try {
            gradeService.update(grade);
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return "grade/update";
        }

        return "redirect:/grade/list";
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id) {
        try {
            gradeService.deleteById(id);
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }

        return "redirect:/grade/list";
    }
}

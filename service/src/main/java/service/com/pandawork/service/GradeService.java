package com.pandawork.service;

import com.pandawork.common.entity.Grade;
import com.pandawork.core.common.exception.SSException;

import java.util.List;

/**
 * GradeService
 *
 * @author: zhangteng
 * @time: 2015/3/25 10:31
 */
public interface GradeService {

    public void newGrade(Grade grade) throws SSException;

    public void update(Grade grade) throws SSException;

    public void deleteById(int id) throws SSException;

    public List<Grade> listAll() throws SSException;

    public Grade queryById(int id) throws SSException;

}

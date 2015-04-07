package com.pandawork.service.impl;

import com.pandawork.common.entity.Grade;
import com.pandawork.common.entity.Grade;
import com.pandawork.common.exception.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.mapper.GradeMapper;
import com.pandawork.service.GradeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * GradeServiceImpl
 *
 * @author: zhangteng
 * @time: 2015/3/25 10:31
 */
@Service("gradeService")
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public void newGrade(Grade grade) throws SSException {
        if (Assert.isNull(grade)) {
            return;
        }

        // 判断用户名和密码是否为空
        Assert.isNotNull(grade.getName(), NFException.GradeNameNotNull);

        try {
            gradeMapper.newGrade(grade);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public void update(Grade grade) throws SSException {
        if (Assert.isNull(grade)) {
            return;
        }

        // 判断用户名和密码是否为空
        Assert.isNotNull(grade.getName(), NFException.GradeNameNotNull);

        try {
            gradeMapper.update(grade);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public void deleteById(@Param("id") int id) throws SSException {
        if (Assert.lessOrEqualZero(id)) {
            return;
        }

        try {
            gradeMapper.deleteById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public List<Grade> listAll() throws SSException {
        try {
            return gradeMapper.listAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public Grade queryById(@Param("id") int id) throws SSException {
        if (Assert.lessOrEqualZero(id)) {
            return null;
        }
        try {
            return gradeMapper.queryById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }
}

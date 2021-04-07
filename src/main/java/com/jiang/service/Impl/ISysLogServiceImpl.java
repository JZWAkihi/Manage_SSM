package com.jiang.service.Impl;

import com.github.pagehelper.PageHelper;
import com.jiang.dao.ISysLogDao;
import com.jiang.domain.SysLog;
import com.jiang.service.ISysLogService;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ISysLogServiceImpl implements ISysLogService {


    @Autowired
    private ISysLogDao sysLogDao;


    @Override
    public List<SysLog> findAll(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        return sysLogDao.findAll(pageNum, pageSize);
    }

    @Override
    public void save(SysLog sysLog) throws Exception {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        sysLog.setId(uuid);
        sysLogDao.save(sysLog);
    }
}

package com.jiang.service;

import com.jiang.domain.SysLog;

import java.util.List;

public interface ISysLogService {


    List<SysLog> findAll(Integer pageNum, Integer pageSize) throws Exception;

    void save(SysLog sysLog) throws Exception;
}

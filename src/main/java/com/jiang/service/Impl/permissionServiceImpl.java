package com.jiang.service.Impl;

import com.jiang.dao.IPermissionDao;
import com.jiang.domain.Permission;
import com.jiang.service.permissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class permissionServiceImpl implements permissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }

    @Override
    public void delete(String id) {
        permissionDao.delete(id);
    }

    @Override
    public Permission findById(String id) {
        return permissionDao.findById(id);
    }
}

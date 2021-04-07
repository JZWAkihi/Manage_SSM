package com.jiang.service;

import com.jiang.domain.Permission;

import java.util.List;

public interface permissionService {

    List<Permission> findAll();

    void save(Permission permission);

    void delete(String id);

    Permission findById(String id);
}

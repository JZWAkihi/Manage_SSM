package com.jiang.service;

import com.jiang.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();


    void save(Role role);

    Role findById(String id);

    void delete(String roleId);

}

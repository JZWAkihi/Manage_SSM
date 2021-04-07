package com.jiang.service;

import com.jiang.domain.Permission;
import com.jiang.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {

    List<Role> findAll();


    void save(Role role);

    Role findById(String id);

    void delete(String roleId);

    List<Permission> findOtherPermissions(String roleId);

    void addPermissionToRole(String roleId,String permissionId);
}

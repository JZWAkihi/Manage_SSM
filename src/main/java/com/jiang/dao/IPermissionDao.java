package com.jiang.dao;

import com.jiang.domain.Permission;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPermissionDao {
    @Select("select * from permission where id in(select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findPermissionByRoleId(String roleId);


}

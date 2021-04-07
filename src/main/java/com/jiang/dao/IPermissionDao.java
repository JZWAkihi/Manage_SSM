package com.jiang.dao;

import com.jiang.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface IPermissionDao {
    @Select("select * from permission where id in(select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findPermissionByRoleId(String roleId);


    @Select("select * from permission")
    List<Permission> findAll();


    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission);


    @Delete("delete from permission where id = #{id}")
    void delete(String id);



    @Select("select * from permission where id = #{id}")
    Permission findById(String id);

}

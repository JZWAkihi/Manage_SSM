package com.jiang.dao;

import com.jiang.domain.Permission;
import com.jiang.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    //查询用户没有的角色
    @Select("select * from role where id not in(select roleId from users_role where userId=#{id})")
    List<Role> findNotRoleByUserId(String id);


    @Select("select * from role")
    List<Role> findAll();


    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);


    @Select("select * from role where id =#{roleId}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.jiang.dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findById(String roleId);


    @Delete("delete from role where id = #{roleId}")
    void delete(String roleId);


    //查询所有的Permission
    @Select("select * from permission where id not in(select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissions(String roleId);


    //添加权限
    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId,@Param("permissionId") String permissionId);
}

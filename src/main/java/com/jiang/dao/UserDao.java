package com.jiang.dao;


import com.jiang.domain.Role;
import com.jiang.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id",property = "roles",javaType = List.class,many = @Many(select = ("com.jiang.dao.RoleDao.findNotRoleByUserId")))
    })
    public UserInfo findByUsername(String username);


    /**
     * 查询全部用户
     * @return
     */
    @Select("select * from users")
    public List<UserInfo> findAll();



    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    public void save(UserInfo userInfo);


    /*
查询用户相关信息:
    1.查询用户信息然后用用户id去中间表拿roleId,然后用roleId去权限表拿相应的路径信息

 */
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id",javaType = java.util.List.class,many =@Many(select="findRoles"))
    })
    public UserInfo findById(String id);


    @Select("select * from role where id not in(select roleId from users_role where userId=#{userId})")
    List<Role> findOtherRole(String userId);

    //插入用户角色到中间表
    @Insert("insert into users_role(userId,roleId) values (#{userId},#{roleId})")
    void addRoleToUser(@Param("userId")String userId,@Param("roleId") String roleId);

    //根据ID来查询角色
    //通过userid查询所有的Role
    @Select("select * from role where id in(select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id=true,column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.jiang.dao.IPermissionDao.findPermissionByRoleId")),
    })
    List<Role> findRoles(String id);


}

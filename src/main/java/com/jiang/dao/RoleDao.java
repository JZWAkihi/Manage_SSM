package com.jiang.dao;

import com.jiang.domain.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    //查询用户没有的角色
    @Select("select * from role where id not in(select roleId from users_role where userId=#{id})")
    List<Role> findNotRoleByUserId(String id);


}

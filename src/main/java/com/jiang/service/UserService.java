package com.jiang.service;

import com.jiang.domain.Role;
import com.jiang.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserInfo> findAll();


    void save(UserInfo userInfo);

    void addRolesToUser(String userId,String[] roleIds);


    UserInfo findById(String id);

    List<Role> findRoles(String id);

}

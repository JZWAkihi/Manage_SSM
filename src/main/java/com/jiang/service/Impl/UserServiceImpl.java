package com.jiang.service.Impl;

import com.jiang.dao.UserDao;
import com.jiang.domain.Role;
import com.jiang.domain.UserInfo;
import com.jiang.service.UserService;
import com.jiang.utils.BCryptPasswordEncoderUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;

        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(userInfo.getRoles());
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_USER"));
        //User user = new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(), getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() != 0, true, true, true,getAuthority(userInfo.getId()));
        return user;
    }

    //作用就是返回一个list集合
    private List<SimpleGrantedAuthority> getAuthority(String id) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        List<Role> roles = userDao.findRoles(id);

        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        System.out.println(list);
        return list;
    }


    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }


    @Override
    public void save(UserInfo userInfo) {
        //对密码加密
        userInfo.setPassword(BCryptPasswordEncoderUtils.encodePassword(userInfo.getPassword()));

        userDao.save(userInfo);
    }

    @Override
    public void addRolesToUser(String userId, String[] roleIds) {
        for(String roleId:roleIds){
            userDao.addRoleToUser(userId,roleId);
        }
    }


    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public List<Role> findRoles(String id) {
        return userDao.findRoles(id);
    }
}

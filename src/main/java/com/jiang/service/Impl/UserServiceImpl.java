package com.jiang.service.Impl;

import com.jiang.dao.UserDao;
import com.jiang.domain.Role;
import com.jiang.domain.UserInfo;
import com.jiang.service.UserService;
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
        }catch (UsernameNotFoundException e){
            e.printStackTrace();
        }
        System.out.println(userInfo);
        User user = new User(userInfo.getUsername(),"{noop}" + userInfo.getPassword(),
                userInfo.getStatus() == 0? false:true,
                true,true,true,getAuthority(userInfo.getRoles()));

        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<>();

        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority(("ROLE_" + role.getRoleName()).toUpperCase()));
        }
        return list;
    }


}

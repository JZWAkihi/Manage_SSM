package com.jiang.controller;

import com.jiang.domain.Role;
import com.jiang.domain.UserInfo;
import com.jiang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findAll();
        mv.addObject("userList",userList);
        mv.setViewName("user-list");
        return mv;
    }


    @RequestMapping("/save.do")
    public String save(UserInfo userInfo){
        userService.save(userInfo);

        return "redirect:findAll.do";
    }



    @RequestMapping("/findById.do")
    public ModelAndView findByID(String id){
        ModelAndView view = new ModelAndView();

        UserInfo userInfo = userService.findById(id);

        view.addObject("user",userInfo);
        view.setViewName("user-show");

        return view;
    }



    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String userId){
        //根据ID查询用户
        ModelAndView view = new ModelAndView();
        UserInfo userInfo = userService.findById(userId);

        //根据用户id查询可以添加的角色
        List<Role> otherRoles = userService.findOtherRoles(userId);

        view.addObject("user",userInfo);
        view.addObject("roleList",otherRoles);

        view.setViewName("user-role-add");
        return view;

    }


    //给用户添加角色
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true)String userId,
                                @RequestParam(name = "ids",required = true) String[] roleIds){
        userService.addRolesToUser(userId,roleIds);


        return "redirect:findAll.do";
    }



}

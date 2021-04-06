package com.jiang.controller;

import com.jiang.domain.UserInfo;
import com.jiang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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



}

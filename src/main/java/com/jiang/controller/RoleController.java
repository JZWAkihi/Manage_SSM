package com.jiang.controller;


import com.jiang.domain.Role;
import com.jiang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView view = new ModelAndView();
        List<Role> roleList = roleService.findAll();

        view.addObject("roleList",roleList);
        view.setViewName("role-list");

        return view;
    }


    @RequestMapping("/save.do")
    public String save(Role role){
        roleService.save(role);

        return "redirect:findAll.do";
    }


    @RequestMapping("/findById.do")
    public ModelAndView findById(String roleId){
        System.out.println("==========================================================================" + roleId);
        ModelAndView view = new ModelAndView();
        Role role = roleService.findById(roleId);
        System.out.println("===========================" + role);
        view.addObject("role",role);
        view.setViewName("role-show");
        return view;
    }

    @RequestMapping("/deleteRole.do")
    public String deleteRole(String id){
        roleService.delete(id);
        return "redirect:findAll.do";
    }
}

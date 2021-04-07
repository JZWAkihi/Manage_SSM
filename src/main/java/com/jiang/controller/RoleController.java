package com.jiang.controller;


import com.jiang.domain.Permission;
import com.jiang.domain.Role;
import com.jiang.service.RoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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



    //根据roleId查询role，并查询出可以添加的权限
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) String roleId){
        ModelAndView view = new ModelAndView();
        Role role = roleService.findById(roleId);
        List<Permission> permissionList = roleService.findOtherPermissions(roleId);
        view.addObject("role",role);
        view.addObject("permissionList",permissionList);
        view.setViewName("role-permission-add");
        return view;
    }



    //添加权限
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true)String roleId,@RequestParam(name = "ids" ,required = true)String[] permissionIds){
        for (String id : permissionIds) {
            roleService.addPermissionToRole(roleId,id);
        }
        return "redirect:findRoleByIdAndAllPermission.do?id="+roleId;
    }







}

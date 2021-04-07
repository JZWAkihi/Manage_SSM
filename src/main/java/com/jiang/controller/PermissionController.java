package com.jiang.controller;

import com.jiang.domain.Permission;
import com.jiang.service.permissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private permissionService service;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView view = new ModelAndView();

        List<Permission> permissionList = service.findAll();

        view.addObject("permissionList",permissionList);

        view.setViewName("permission-list");

        return view;
    }



    @RequestMapping("/save.do")
    public String save(Permission permission){
        service.save(permission);
        return "redirect:findAll.do";
    }


    @RequestMapping("/deletePermission.do")
    public String deletePermission(String id){
        service.delete(id);

        return "redirect:findAll.do";
    }


    @RequestMapping("/findById.do")
    public ModelAndView findById(String id){
        ModelAndView view = new ModelAndView();
        view.setViewName("permission-show");
        Permission pList = service.findById(id);
        view.addObject("permission",pList);

        return view;
    }

}

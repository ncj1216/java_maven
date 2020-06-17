package com.offcn.test;

import com.offcn.bean.Dept;
import com.offcn.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/test")
public class Testcontroller {


   @Autowired
   DeptService de;


    @RequestMapping("/test")
    public String test(Model model){

        List<Dept> depts=de.queryDeptList();
        model.addAttribute("depts",depts);

        return "test";
    }

}

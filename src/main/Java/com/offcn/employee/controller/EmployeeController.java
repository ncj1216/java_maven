package com.offcn.employee.controller;

import com.offcn.bean.Employee;
import com.offcn.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService s;





    @RequestMapping("/project-add-employee-show")
    @ResponseBody
    public ResponseEntity<List<Employee>> projectionAddEmployeeShow(){

        List<Employee> ee=s.queryEmployeeListLimit(20);
        return ResponseEntity.ok(ee);
    }


    @RequestMapping("/login")
    public String login(Model model, String name, String pass){
        Employee employee=s.queryEmployeeByNameAndPass(name,pass);
        if (employee!=null){

            //登陆成功
            //把登录用户信息保存到redis中
            return "/index1.jsp";
        }else {
            model.addAttribute("msg","请检查账号或者密码是否正确");
            return "/login.jsp";
        }

    }




}

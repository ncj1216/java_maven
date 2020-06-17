package com.offcn.customer.controller;

import com.github.pagehelper.PageInfo;
import com.offcn.bean.Customer;
import com.offcn.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService c;

    /*列表展示*/
    @RequestMapping("cumtomer-show")
    public String customerShow(@RequestParam(defaultValue = "1") int currentPage,Model model){
       PageInfo<Customer> pi =c.queryCustomerList(currentPage);

        model.addAttribute("pageinfo",pi);
        return "/customer.jsp";
    }


    /*添加页面的显示*/
    @RequestMapping("/customer-add-show")
    public String customerAddShow(){

        return "/customer-add.jsp";
    }



    @RequestMapping("/customer-saveInfo")
    public String customerSaveInfo(Customer customer){

        customer.setAddtime(new Date());
        c.save(customer);

        return "redirect:/customer/cumtomer-show";
    }



    /*查看详情和修改页面的展示*/
    @RequestMapping("/customer-edit-look")
    public String customerEditLook(int id,String flag,int currentPage,Model model){

        Customer customer=c.queryCustomerById(id);

        model.addAttribute("customer",customer);
        model.addAttribute("currentPage",currentPage);
        if ("edit".equals(flag)){

            return "/customer-edit.jsp";
        }else{
            return "/customer-look.jsp";
        }
    }
    @RequestMapping("/customer-edit")
    public String customerEdit(Customer customer,int currentPage){

        customer.setAddtime(new Date());
        c.edit(customer);

        return "redirect:/customer/cumtomer-show?currentPage="+currentPage;
    }



    @RequestMapping("/customer-delete")
    public String customerDelete(String ids){

        String[] split = ids.split(",");//切割放入String类型的数组里
        int[] idArray =new int[split.length];//新建一个int数组大小就是切割后大小的长度
        for (int i=0;i<split.length;i++){
            idArray[i] =Integer.parseInt(split[i]);//把字符串类型的数组转换类型放进int数组中
        }

        c.batchDelete(idArray);
        return "redirect:/customer/cumtomer-show";
    }



    @RequestMapping("/project-add-customer-show")
    @ResponseBody
    //ResponseEntity属于一个工具类，可以封装集合或者单一数据
    public ResponseEntity<List<Customer>> projectionAddCustomerShow(){
        List<Customer> customers=c.queryCustomerList();
        return ResponseEntity.ok(customers);//封装了200的响应状态码,还有数据
    }



    @RequestMapping("/project-add-customer-person-show")
    @ResponseBody
    public ResponseEntity<Customer> projectAddCustomerPersonShow(int id){

        Customer customer = c.queryCustomerById(id);
        return ResponseEntity.ok(customer);
    }


}

package com.offcn.customer.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offcn.bean.Customer;
import com.offcn.customer.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao da;

    @Override
    public List<Customer> queryCustomerList() {

        return da.selectCustomerList();
    }

    @Override
    public PageInfo<Customer> queryCustomerList(int currentPage) {
            /*第一个参数是当前页码*/
        PageHelper.startPage(currentPage,3);
        List<Customer> customers = da.selectCustomerList();
        /*页面显示几个页码*/
        PageInfo<Customer> pi=new PageInfo<>(customers,5);
        return pi;
    }

    /*增加功能*/
    @Transactional
    @Override
    public void save(Customer customer) {

        da.insert(customer);
    }

    /*主键查询*/
    @Override
    public Customer queryCustomerById(int id) {
        return da.selectCustomerById(id);
    }

    @Transactional
    @Override
    public void edit(Customer customer) {


        da.update(customer);
    }


    /*批量删除*/
    @Override
    public void batchDelete(int[] idArray) {

        da.deleteCustomerByIds(idArray);
    }
}

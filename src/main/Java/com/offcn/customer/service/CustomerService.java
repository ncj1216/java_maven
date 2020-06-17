package com.offcn.customer.service;

import com.github.pagehelper.PageInfo;
import com.offcn.bean.Customer;

import java.util.List;

public interface CustomerService {


    List<Customer> queryCustomerList();

    PageInfo<Customer> queryCustomerList(int currentPage);

    void save(Customer customer);

    Customer queryCustomerById(int id);

    void edit(Customer customer);

    void batchDelete(int[] idArray);
}

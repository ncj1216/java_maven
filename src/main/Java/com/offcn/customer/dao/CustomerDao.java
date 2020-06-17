package com.offcn.customer.dao;

import com.offcn.bean.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerDao {


    List<Customer> selectCustomerList();

    void insert(Customer customer);

    Customer selectCustomerById(int id);

    void update(Customer customer);

    void deleteCustomerByIds(@Param("ids") int[] idArray);
}

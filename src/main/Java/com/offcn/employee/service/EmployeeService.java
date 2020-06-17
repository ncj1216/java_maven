package com.offcn.employee.service;

import com.offcn.bean.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> queryEmployeeListLimit(int num);


    Employee queryEmployeeByNameAndPass(String name, String pass);
}

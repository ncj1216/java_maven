package com.offcn.employee.dao;

import com.offcn.bean.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> selectEmployeeListLimit(int num);

    Employee selectEmployeeByName(String name);
}

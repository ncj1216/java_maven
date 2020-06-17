package com.offcn.employee.service;

import com.offcn.bean.Employee;
import com.offcn.employee.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao dao;


    @Override
    public List<Employee> queryEmployeeListLimit(int num) {

        return dao.selectEmployeeListLimit(num);
    }



    @Override
    public Employee queryEmployeeByNameAndPass(String name, String pass) {



        Employee ee=dao.selectEmployeeByName(name);

        if (ee != null){
            String password=ee.getPassword();
            //pass在此处应该有加密处理
            if (!password.equals(pass)){
                return null;
            }
        }

        return ee;
    }


}

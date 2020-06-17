package com.offcn.dept.service;
import com.offcn.bean.Dept;
import com.offcn.dept.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class DeptServiceImpl implements DeptService{
        @Autowired
        private DeptDao deptDao;

        @Override
        public List<Dept> queryDeptList() {
            return deptDao.selectDeptList();
        }
}

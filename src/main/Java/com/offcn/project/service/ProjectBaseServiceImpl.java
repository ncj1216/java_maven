package com.offcn.project.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offcn.bean.Project;
import com.offcn.bean.ProjectExtends;
import com.offcn.project.dao.ProjectBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectBaseServiceImpl implements ProjectBaseService {

    @Autowired
    private ProjectBaseDao dao;


    @Override
    public PageInfo<ProjectExtends> queryProjectList(int currentPage) {

        PageHelper.startPage(currentPage,3);
        List<ProjectExtends> pes=dao.selectProjectList();
        PageInfo<ProjectExtends> pi=new PageInfo<>(pes,5);

        return pi;
    }


    //保存功能
    @Transactional
    @Override
    public void save(Project project) {
        dao.insert(project);
    }

    @Override
    public List<Project> queryProjectByMark(int mark) {


        return dao.selectProjectByMark(mark);
    }
}

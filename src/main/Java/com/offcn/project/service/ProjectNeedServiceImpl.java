package com.offcn.project.service;

import com.offcn.bean.Analysis;
import com.offcn.bean.AnalysisExtends;
import com.offcn.project.dao.ProjectNeedDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectNeedServiceImpl implements ProjectNeedService {


    @Autowired
    private ProjectNeedDao needDao;


    @Transactional
    @Override
    public void save(Analysis analysis) {


        needDao.insert(analysis);

    }



    //需求分析页面展示
    @Override
    public List<AnalysisExtends> queryProjectNeedList() {



        return needDao.selectPojectNeedList();
    }
}

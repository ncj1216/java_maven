package com.offcn.project.dao;

import com.offcn.bean.Analysis;
import com.offcn.bean.AnalysisExtends;

import java.util.List;

public interface ProjectNeedDao {


    void insert(Analysis analysis);

    List<AnalysisExtends> selectPojectNeedList();
}

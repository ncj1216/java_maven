package com.offcn.project.service;

import com.offcn.bean.Analysis;
import com.offcn.bean.AnalysisExtends;

import java.util.List;

public interface ProjectNeedService {
    void save(Analysis analysis);

    List<AnalysisExtends> queryProjectNeedList();
}

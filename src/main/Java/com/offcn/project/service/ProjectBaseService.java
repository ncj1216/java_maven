package com.offcn.project.service;

import com.github.pagehelper.PageInfo;
import com.offcn.bean.Project;
import com.offcn.bean.ProjectExtends;

import java.util.List;

public interface ProjectBaseService {

    PageInfo<ProjectExtends> queryProjectList(int currentPage);

    void save(Project project);

    List<Project> queryProjectByMark(int mark);
}

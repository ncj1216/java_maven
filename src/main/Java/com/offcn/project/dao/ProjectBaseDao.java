package com.offcn.project.dao;

import com.offcn.bean.Project;
import com.offcn.bean.ProjectExtends;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectBaseDao {
    List<ProjectExtends> selectProjectList();


    void insert(Project project);

    List<Project> selectProjectByMark(@Param("mark") int mark);
}

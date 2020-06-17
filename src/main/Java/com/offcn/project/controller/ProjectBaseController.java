package com.offcn.project.controller;


import com.github.pagehelper.PageInfo;
import com.offcn.bean.Project;
import com.offcn.bean.ProjectExtends;
import com.offcn.project.service.ProjectBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/project")
public class ProjectBaseController {


    @Autowired
    private ProjectBaseService service;


    @RequestMapping("/project-show")
    @ResponseBody
    public PageInfo<ProjectExtends>  projectShow(@RequestParam(defaultValue = "1") int currentPage){
        PageInfo<ProjectExtends> pageInfo= service.queryProjectList(currentPage);
        return pageInfo;

    }


    //项目的添加功能
    @RequestMapping("/project-saveInfo")
    public ResponseEntity<Void>projectSaveInfo(Project project){
        service.save(project);
        return ResponseEntity.ok(null);
    }


}

package com.offcn.project.controller;


import com.offcn.bean.Analysis;
import com.offcn.bean.AnalysisExtends;
import com.offcn.bean.Project;
import com.offcn.project.service.ProjectBaseService;
import com.offcn.project.service.ProjectNeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/project")
public class ProjectNeedController {


    @Autowired
    private ProjectNeedService needService;

    @Autowired
    private ProjectBaseService service;



    @RequestMapping("/project-need-project-show")
    @ResponseBody
    public List<Project> projectNeedProjectShow(int mark){
        return service.queryProjectByMark(mark);
    }


    //上传和保存数据
    //files是上传文件的那个name名字
    @RequestMapping("/project-need-saveInfo")
    public String projectNeedSaveInfo(Analysis analysis, MultipartFile files) throws IOException {

        analysis.setAddtime(new Date());
        //上传文件处理
        if(files!=null){
            //获取上传文件原始名称
            String filename = files.getOriginalFilename();
            //可以实现重命名
            //随机字符串
            int indexOf = filename.lastIndexOf(".");
            String extName="";
            if (indexOf!=-1){
                extName=filename.substring(indexOf);
            }
            String newName= UUID.randomUUID().toString().replaceAll("-","")+extName;
            //指定文件保存位置
            File file=new File("C:\\Users\\ASUS\\Desktop\\upload",newName);

            //向指定保存文件位置上传文件
            files.transferTo(file);

            analysis.setProname(file.getPath());

        }


        needService.save(analysis);

        return "redirect:/project/project-need-show";
    }





    @RequestMapping("/project-need-show")
    public String projectNeedShow(Model model){

        List<AnalysisExtends> aes= needService.queryProjectNeedList();
        model.addAttribute("analysises",aes);
        return "/project-need.jsp";
    }



}

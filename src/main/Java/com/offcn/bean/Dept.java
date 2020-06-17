package com.offcn.bean;

import java.io.Serializable;

public class Dept implements Serializable {

    private static final long serialVersionUID = -6689856698294592355L;
    private  Integer deptno;
    private String dname;
    private String dlocation;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDlocation() {
        return dlocation;
    }

    public void setDlocation(String dlocation) {
        this.dlocation = dlocation;
    }
}

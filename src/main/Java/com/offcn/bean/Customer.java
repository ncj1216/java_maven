package com.offcn.bean;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
    private static final long serialVersionUID = -4160462553354343971L;
    private Integer id;
    private String comname;
    private String companyperson;
    private String comaddress;
    private String comphone;
    private String camera;
    private String present;
    private String remark;
    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public String getCompanyperson() {
        return companyperson;
    }

    public void setCompanyperson(String companyperson) {
        this.companyperson = companyperson;
    }

    public String getComaddress() {
        return comaddress;
    }

    public void setComaddress(String comaddress) {
        this.comaddress = comaddress;
    }

    public String getComphone() {
        return comphone;
    }

    public void setComphone(String comphone) {
        this.comphone = comphone;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author ZP Chen
 */

//学生实体类
public class Teacher {
    private String teaID;
    private String teaName;
    private String teaSex;
    private String teaCollege;
    private String teaDepartment;
    private String teaType;
    private String teaPhone;
    private String remark;
    private String isBlackList;

    public void setIsBlackList(String isBlackList) {
        this.isBlackList = isBlackList;
    }

    public String getIsBlackList() {
        return isBlackList;
    }

    public String getTeaID() {
        return teaID;
    }

    public String getTeaName() {
        return teaName;
    }

    public String getTeaSex() {
        return teaSex;
    }

    public String getTeaCollege() {
        return teaCollege;
    }

    public String getTeaDepartment() {
        return teaDepartment;
    }

    public String getTeaType() {
        return teaType;
    }

    public String getTeaPhone() {
        return teaPhone;
    }

    public String getRemark() {
        return remark;
    }

    public void setTeaID(String teaID) {
        this.teaID = teaID;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public void setTeaSex(String teaSex) {
        this.teaSex = teaSex;
    }

    public void setTeaCollege(String teaCollege) {
        this.teaCollege = teaCollege;
    }

    public void setTeaDepartment(String teaDepartment) {
        this.teaDepartment = teaDepartment;
    }

    public void setTeaType(String teaType) {
        this.teaType = teaType;
    }

    public void setTeaPhone(String teaPhone) {
        this.teaPhone = teaPhone;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Teacher() {
        super();
    }

    public Teacher(String teaID, String teaName, String teaSex, String teaCollege, String teaDepartment, String teaType, String teaPhone, String remark) {
        this.teaID = teaID;
        this.teaName = teaName;
        this.teaSex = teaSex;
        this.teaCollege = teaCollege;
        this.teaDepartment = teaDepartment;
        this.teaType = teaType;
        this.teaPhone = teaPhone;
        this.remark = remark;
    }

    public Teacher(String teaID, String teaCollege, String teaDepartment, String teaType, String teaPhone, String remark) {
        this.teaID = teaID;
        this.teaCollege = teaCollege;
        this.teaDepartment = teaDepartment;
        this.teaType = teaType;
        this.teaPhone = teaPhone;
        this.remark = remark;
    }
 
    
}

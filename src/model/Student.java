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
public class Student {
    private String stuID;
    private String stuName;
    private String stuSex;
    private String stuCollege;
    private String stuDepartment;
    private String stuType;
    private String stuPhone;
    private String remark;
    private String isBlackList;

    public void setIsBlackList(String isBlackList) {
        this.isBlackList = isBlackList;
    }

    public String getIsBlackList() {
        return isBlackList;
    }

    public String getStuID() {
        return stuID;
    }

    public String getStuName() {
        return stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public String getStuCollege() {
        return stuCollege;
    }

    public String getStuDepartment() {
        return stuDepartment;
    }

    public String getStuType() {
        return stuType;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public String getRemark() {
        return remark;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public void setStuCollege(String stuCollege) {
        this.stuCollege = stuCollege;
    }

    public void setStuDepartment(String stuDepartment) {
        this.stuDepartment = stuDepartment;
    }

    public void setStuType(String stuType) {
        this.stuType = stuType;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Student() {
        super();
    }
 
    public Student(String stuID, String stuName, String stuSex, String stuCollege, String stuDepartment, String stuType, String stuPhone, String remark) {
        super();
        this.stuID = stuID;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuCollege = stuCollege;
        this.stuDepartment = stuDepartment;
        this.stuType = stuType;
        this.stuPhone = stuPhone;
        this.remark = remark;
    }

    public Student(String stuID, String stuCollege, String stuDepartment, String stuPhone, String remark) {
        this.stuID = stuID;
        this.stuCollege = stuCollege;
        this.stuDepartment = stuDepartment;
        this.stuPhone = stuPhone;
        this.remark = remark;
    }
    
}

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

//管理员实体类
public class Admin {
    private String adminName;
    private String adminSex;
    private String adminPhone;
    private String logInName;
    private String logInPassword;
    private String logInPasswordConfirm;
    private String adminRemark;

    public void setLogInPasswordConfirm(String logInPasswordConfirm) {
        this.logInPasswordConfirm = logInPasswordConfirm;
    }

    public String getLogInPasswordConfirm() {
        return logInPasswordConfirm;
    }

    public String getLogInName(){
        return logInName;
    }
    public void setLogInName(String logInName){
        this.logInName = logInName;
    }
    public String getLogInPassword(){
        return logInPassword;
    }
    public void setLogInPassword(String logInPassword){
        this.logInPassword = logInPassword;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminSex() {
        return adminSex;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public String getAdminRemark() {
        return adminRemark;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setAdminSex(String adminSex) {
        this.adminSex = adminSex;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public void setAdminRemark(String adminRemark) {
        this.adminRemark = adminRemark;
    }
    
    public Admin(){
        super();
    }
    public Admin(String logInName,String logInPassword){
        super();
        this.logInName = logInName;
        this.logInPassword = logInPassword;
    }

    public Admin(String adminName, String adminSex, String adminPhone, String logInName, String logInPassword, String adminRemark) {
        this.adminName = adminName;
        this.adminSex = adminSex;
        this.adminPhone = adminPhone;
        this.logInName = logInName;
        this.logInPassword = logInPassword;
        this.adminRemark = adminRemark;
    }

    public Admin(String adminPhone, String logInName, String logInPassword, String adminRemark) {
        this.adminPhone = adminPhone;
        this.logInName = logInName;
        this.logInPassword = logInPassword;
        this.adminRemark = adminRemark;
    }
    
}


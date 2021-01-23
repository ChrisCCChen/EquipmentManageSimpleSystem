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

//维修实体类
public class Maintain {
    private String equipID;
    private String maintainDateUnuse;
    private String maintainExpense;
    private String maintainReason;

    public Maintain(String equipID, String maintainExpense, String maintainReason) {
        this.equipID = equipID;
        this.maintainExpense = maintainExpense;
        this.maintainReason = maintainReason;
    }

    public Maintain() {
    }

    public void setEquipID(String equipID) {
        this.equipID = equipID;
    }

    public void setMaintainDateUnuse(String maintainDateUnuse) {
        this.maintainDateUnuse = maintainDateUnuse;
    }

    public void setMaintainExpense(String maintainExpense) {
        this.maintainExpense = maintainExpense;
    }

    public void setMaintainReason(String maintainReason) {
        this.maintainReason = maintainReason;
    }

    public String getEquipID() {
        return equipID;
    }

    public String getMaintainDateUnuse() {
        return maintainDateUnuse;
    }

    public String getMaintainExpense() {
        return maintainExpense;
    }

    public String getMaintainReason() {
        return maintainReason;
    }

    
    
}


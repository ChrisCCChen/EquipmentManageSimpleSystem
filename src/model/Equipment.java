/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Date;

/**
 *
 * @author ZP Chen
 */
public class Equipment {
    private String equipName;
    private String equipDesc;
    private String equipIsBorrowed;
    private String equipIsAvailable;
    private String equipPrice;
    private String equipRegisterDateUnuse;

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public void setEquipDesc(String equipDesc) {
        this.equipDesc = equipDesc;
    }

    public void setEquipIsBorrowed(String equipIsBorrowed) {
        this.equipIsBorrowed = equipIsBorrowed;
    }

    public void setEquipIsAvailable(String equipIsAvailable) {
        this.equipIsAvailable = equipIsAvailable;
    }

    public void setEquipPrice(String equipPrice) {
        this.equipPrice = equipPrice;
    }

    public void setEquipRegisterDateUnuse(String equipRegisterDateUnuse) {
        this.equipRegisterDateUnuse = equipRegisterDateUnuse;
    }

    public String getEquipName() {
        return equipName;
    }

    public String getEquipDesc() {
        return equipDesc;
    }

    public String getEquipIsBorrowed() {
        return equipIsBorrowed;
    }

    public String getEquipIsAvailable() {
        return equipIsAvailable;
    }

    public String getEquipPrice() {
        return equipPrice;
    }

    public String getEquipRegisterDateUnuse() {
        return equipRegisterDateUnuse;
    }

    public Equipment() {
    }

    public Equipment(String equipName, String equipDesc, String equipPrice) {
        this.equipName = equipName;
        this.equipDesc = equipDesc;
        this.equipPrice = equipPrice;
    }
    
}

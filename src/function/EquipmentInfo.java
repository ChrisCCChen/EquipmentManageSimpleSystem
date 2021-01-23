/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Equipment;
import util.StringUtil;

/**
 *
 * @author ZP Chen
 */
//器材信息操作类，实现器材添加、查询、修改等操作
public class EquipmentInfo {
    //器材添加
    public int equipmentInfoAdd(Connection con,Equipment equip,int registerNumber) throws SQLException{
        String sql = "insert into Equipment(equipName,equipDescription,isBorrowed,isAvailable,unitPrice,registerDate) values(?,?,?,?,?,Date())";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,equip.getEquipName());
        pstm.setString(2,equip.getEquipDesc());
        pstm.setString(3,"No");
        pstm.setString(4,"Yes");
        pstm.setFloat(5,Float.valueOf(equip.getEquipPrice()));
        try{
            for(int i = 0;i < registerNumber;i++){
                pstm.executeUpdate();
            }
            return 1;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            con.close();
        }
    }
    //查询目前最大器材编号
    public int searchMaxID(Connection con) throws SQLException{
        String sql = "select MAX(equipID) as MAXID from Equipment";
        PreparedStatement pstm = con.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        int maxID = 0;
        if(rs.next()){
            maxID = rs.getInt("MAXID");
        }
        con.close();
        return maxID;
    }
    //查询输入的器材编号是否存在
    public boolean isEquipIDExist(Connection con,String equipID) throws SQLException{
        String sql = "select * from Equipment where equipID = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setInt(1,Integer.valueOf(equipID));
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            con.close();
            return true;
        }
        else{
            con.close();
            return false;
        }
    }
    //报废、撤销报废操作
    public int scrap(Connection con,String equipID,boolean isScrap) throws SQLException{
        String sql = "update Equipment set isAvailable = ? where equipID = ?";
        String sql2 = "update Equipment set scrapDate = Date() where equipID = ?";
        String sql3 = "update Equipment set scrapDate = null where equipID = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        PreparedStatement pstm2 = con.prepareStatement(sql2);
        PreparedStatement pstm3 = con.prepareStatement(sql3);
        pstm.setString(2,equipID);
        pstm2.setString(1,equipID);
        pstm3.setString(1,equipID);
        if(isScrap){//报废操作
            pstm.setString(1,"No");
            try{
                pstm.executeUpdate();
                pstm2.executeUpdate();
                return 1;
            }catch(Exception e){
                e.printStackTrace();
                return 0;
            }finally{
                con.close();
            }
        }
        else{//撤销报废操作
            pstm.setString(1,"Yes");
            try{
                pstm.executeUpdate();
                pstm3.executeUpdate();
                return 1;
            }catch(Exception e){
                e.printStackTrace();
                return 0;
            }finally{
                con.close();
            }
        }
    }
    //返回当前器材报废状态
    public String returnIsAvailable(Connection con,String equipID) throws SQLException{
        String sql = "select * from Equipment where equipID = ?";
        String result;
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setInt(1,Integer.valueOf(equipID));
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            result = rs.getString("isAvailable");
            con.close();
            return result;
        }
        else{
            con.close();
            return "search failure";
        }
    }
    //实现按名称查询操作
    public ResultSet listByName(Connection con,Equipment equipment) throws SQLException{
        StringBuilder sb = new StringBuilder("select * from Equipment");
        if(StringUtil.isNotEmpty(equipment.getEquipName())){
            sb.append(" where equipName like '%").append(equipment.getEquipName()).append("%'");
        }
        PreparedStatement pstmt = con.prepareStatement(sb.toString());
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
    //实现按编号查询操作
    public ResultSet listByID(Connection con,String equipID) throws SQLException{
        StringBuilder sb = new StringBuilder("select * from Equipment where equipID = ?");
        PreparedStatement pstmt = con.prepareStatement(sb.toString());
        pstmt.setInt(1, Integer.valueOf(equipID));
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
    //查询输入的器材号是否可用（尚未报废）
    public boolean isAvailable(Connection con,String equipID) throws SQLException{
        String sql = "select isAvailable from Equipment where equipID = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,equipID);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            if(rs.getString("isAvailable").equals("Yes"))
            {
                con.close();
                return true;
            }
            else{
                con.close();
                return false;
            }
        }
        else{
            con.close();
            return false;
        }
    }
    //查询输入的器材号是否已被借走
    public boolean isBorrowed(Connection con,String equipID) throws SQLException{
        String sql = "select isBorrowed from Equipment where equipID = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,equipID);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            if(rs.getString("isBorrowed").equals("Yes"))
            {
                con.close();
                return true;
            }
            else{
                con.close();
                return false;
            }
        }
        else{
            con.close();
            return false;
        }
    }
    //置器材被归还操作
    public int setReturn(Connection con,String equipID) throws SQLException{
        String sql = "update Equipment set isBorrowed = ? where equipID = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,"No");
        pstm.setInt(2,Integer.valueOf(equipID));
        try{
            return pstm.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            con.close();
        }
    }
    //置器材被借走操作
    public int setBorrowed(Connection con,String equipID) throws SQLException{
        String sql = "update Equipment set isBorrowed = ? where equipID = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,"Yes");
        pstm.setInt(2,Integer.valueOf(equipID));
        try{
            return pstm.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            con.close();
        }
    }
}

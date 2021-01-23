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
import model.Maintain;
import model.Student;
import util.StringUtil;

/**
 *
 * @author ZP Chen
 */
//维护信息操作类，实现学生添加、查询、修改等操作
public class MaintainInfo {
    public int maintainInfoAdd(Connection con,Maintain maintain) throws SQLException{
        String sql = "insert into EquipMaintain(equipID,maintainDate,maintainExpense,maintainReason) values(?,Date(),?,?)";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setInt(1,Integer.valueOf(maintain.getEquipID()));
        pstm.setFloat(2,Float.valueOf(maintain.getMaintainExpense()));
        pstm.setString(3,maintain.getMaintainReason());
        try{
            return pstm.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            con.close();
        }
    }
    //实现按名称查询操作
    public ResultSet listByName(Connection con,Equipment equipment) throws SQLException{
        StringBuilder sb = new StringBuilder("select * from EquipMaintain,Equipment where EquipMaintain.equipID=Equipment.equipID");
        if(StringUtil.isNotEmpty(equipment.getEquipName())){
            sb.append(" and Equipment.equipName like '%").append(equipment.getEquipName()).append("%'");
        }
        PreparedStatement pstmt = con.prepareStatement(sb.toString());
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
    //实现按编号查询操作
    public ResultSet listByID(Connection con,String equipID) throws SQLException{
        StringBuilder sb = new StringBuilder("select * from EquipMaintain,Equipment where Equipment.equipID = ? and EquipMaintain.equipID=Equipment.equipID");
        PreparedStatement pstmt = con.prepareStatement(sb.toString());
        pstmt.setInt(1, Integer.valueOf(equipID));
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
}

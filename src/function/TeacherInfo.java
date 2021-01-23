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
import model.Teacher;
import util.StringUtil;


/**
 *
 * @author ZP Chen
 */
//老师信息操作类，实现老师添加、查询、修改等操作
public class TeacherInfo {
    public int teacherInfoAdd(Connection con,Teacher tea) throws SQLException{
        String sql = "insert into Teacher(teaID,teaName,teaSex,teaCollege,teaDepartment,teaType,teaPhone,teaRemark,teaIsBlackList) values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,tea.getTeaID());
        pstm.setString(2,tea.getTeaName());
        pstm.setString(3,tea.getTeaSex());
        pstm.setString(4,tea.getTeaCollege());
        pstm.setString(5,tea.getTeaDepartment());
        pstm.setString(6,tea.getTeaType());
        pstm.setString(7,tea.getTeaPhone());
        pstm.setString(8,tea.getRemark());
        pstm.setString(9,new String("No"));
        try{
            return pstm.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            con.close();
        }
    }
    //返回当前老师是否已存在
    public boolean checkExist(Connection con,String teaID) throws SQLException{
        String sql = "select * from Teacher where teaID=?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,teaID);
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
    //实现按姓名查询操作
    public ResultSet listByName(Connection con,Teacher teacher) throws SQLException{
        StringBuilder sb = new StringBuilder("select * from Teacher");
        if(StringUtil.isNotEmpty(teacher.getTeaName())){
            sb.append(" where teaName like '%").append(teacher.getTeaName()).append("%'");
        }
        PreparedStatement pstmt = con.prepareStatement(sb.toString());
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
    //实现按教工号查询操作
    public ResultSet listByID(Connection con,String teaID) throws SQLException{
        StringBuilder sb = new StringBuilder("select * from Teacher where teaID = ?");
        PreparedStatement pstmt = con.prepareStatement(sb.toString());
        pstmt.setString(1, teaID);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
    //查询输入的教工号是否存在
    public boolean isTeaIDExist(Connection con,String teaID) throws SQLException{
        String sql = "select * from Teacher where teaID = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,teaID);
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
    //查询输入的教工号是否为黑名单
    public boolean isTeaIDBlack(Connection con,String teaID) throws SQLException{
        String sql = "select teaIsBlackList from Teacher where teaID = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,teaID);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            if(rs.getString("teaIsBlackList").equals("Yes"))
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
    //老师信息修改
    public int updateInfo(Connection con,Teacher tea) throws SQLException{
        String sql = "update Teacher set teaCollege=?,teaDepartment=?,teaType=?,teaPhone=?,teaRemark=? where teaID=?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,tea.getTeaCollege());
        pstm.setString(2,tea.getTeaDepartment());
        pstm.setString(3,tea.getTeaType());
        pstm.setString(4,tea.getTeaPhone());
        pstm.setString(5,tea.getRemark());
        pstm.setString(6,tea.getTeaID());
        try{
            return pstm.executeUpdate();
        }catch(SQLException e){
            return 0;
        }finally{
            con.close();
        }
    }
    //老师信息删除
    public int deleteInfo(Connection con,String teaID) throws SQLException{
        String sql = "delete from Teacher where teaID=?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,teaID);
        try{
            return pstm.executeUpdate();
        }catch(SQLException e){
            return 0;
        }finally{
            con.close();
        }
    }
    //返回当前教工号已经借用的器材数
    public int countEquipBorrow(Connection con,String teaID) throws SQLException{
        String sql = "select count(*) as countEquipBorrow from TeacherBorrow where teaID=? and returnDate is null";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,teaID);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            int countEquipBorrow = rs.getInt("countEquipBorrow");
            con.close();
            return countEquipBorrow;
        }
        return 0;
    }
    //实现按是否为黑名单查询操作
    public ResultSet listByBlackList(Connection con) throws SQLException{
        String sql = "select * from Teacher where teaIsBlackList='Yes'";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
    //实现按教工号和黑名单双重条件查询操作
    public ResultSet listByIDAndBlack(Connection con,String teaID) throws SQLException{
        String sql = "select * from Teacher where teaID = ? and teaIsBlackList='Yes'";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, teaID);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
}

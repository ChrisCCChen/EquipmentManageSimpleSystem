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
import model.Admin;
import util.StringUtil;

/**
 *
 * @author ZP Chen
 */
//管理员信息操作类，实现管理员添加、查询、修改等操作
public class AdminInfo {
    public int adminInfoAdd(Connection con,Admin admin) throws SQLException{
        String sql = "insert into Admin(adminName,adminSex,adminPhone,adminRemark,logInName,logInPassword) values(?,?,?,?,?,?)";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,admin.getAdminName());
        pstm.setString(2,admin.getAdminSex());
        pstm.setString(3,admin.getAdminPhone());
        pstm.setString(4,admin.getAdminRemark());
        pstm.setString(5,admin.getLogInName());
        pstm.setString(6,admin.getLogInPassword());
        try{
            return pstm.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            con.close();
        }
    }
    //实现按姓名查询操作
    public ResultSet listByName(Connection con,Admin admin) throws SQLException{
        StringBuilder sb = new StringBuilder("select * from Admin");
        if(StringUtil.isNotEmpty(admin.getAdminName())){
            sb.append(" where adminName like '%").append(admin.getAdminName()).append("%'");
        }
        PreparedStatement pstmt = con.prepareStatement(sb.toString());
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
    //实现按编号查询操作
    public ResultSet listByID(Connection con,String adminID) throws SQLException{
        StringBuilder sb = new StringBuilder("select * from Admin where adminID = ?");
        PreparedStatement pstmt = con.prepareStatement(sb.toString());
        pstmt.setInt(1, Integer.valueOf(adminID));
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
    //管理员信息修改
    public int updateInfo(Connection con,Admin admin,String adminID) throws SQLException{
        String sql = "update Admin set adminPhone=?,adminRemark=?,logInName=?,logInPassword=? where adminID=?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,admin.getAdminPhone());
        pstm.setString(2,admin.getAdminRemark());
        pstm.setString(3,admin.getLogInName());
        pstm.setString(4,admin.getLogInPassword());
        pstm.setInt(5,Integer.valueOf(adminID));
        try{
            return pstm.executeUpdate();
        }catch(SQLException e){
            return 0;
        }finally{
            con.close();
        }
    }
    //老师信息删除
    public int deleteInfo(Connection con,String adminID) throws SQLException{
        String sql = "delete from Admin where adminID=?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,adminID);
        try{
            return pstm.executeUpdate();
        }catch(SQLException e){
            return 0;
        }finally{
            con.close();
        }
    }
     //返回当前管理员用户名是否已存在
    public boolean checkExist(Connection con,String adminLogInName) throws SQLException{
        String sql = "select * from Admin where logInName=?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,adminLogInName);
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
    //返回当前新添加管理员的编号
    public int returnAdminID(Connection con) throws SQLException{
        String sql = "select max(adminID) as maxID from Admin";
        PreparedStatement pstm = con.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            int adminID = rs.getInt("maxID");
            con.close();
            return adminID;
        }
        else{
            con.close();
            return 0;
        }
    }
}

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

/**
 *
 * @author ZP Chen
 */
public class BorrowInfo {
    //学生借用器材操作
    public int studentBorrow(Connection con,String stuID,String equipID) throws SQLException{
        String sql = "insert into StudentBorrow(stuID,equipID,borrowDate,expireDate) values(?,?,Date(),Date()+7)";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,stuID);
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
    //老师借用器材操作
    public int teacherBorrow(Connection con,String teaID,String equipID) throws SQLException{
        String sql = "insert into TeacherBorrow(teaID,equipID,borrowDate,expireDate) values(?,?,Date(),Date()+15)";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,teaID);
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
    //返回所有学生借用历史信息
    public ResultSet listAllStudentBorrowHistory(Connection con) throws SQLException{
        String sql = "select * from Student,StudentBorrow,Equipment where Student.stuID=StudentBorrow.stuID and StudentBorrow.equipID=Equipment.equipID";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
    //返回所有老师借用历史信息
    public ResultSet listAllTeacherBorrowHistory(Connection con) throws SQLException{
        String sql = "select * from Teacher,TeacherBorrow,Equipment where Teacher.teaID=TeacherBorrow.teaID and TeacherBorrow.equipID=Equipment.equipID";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
    //返回所有指定学号学生的借用历史信息
    public ResultSet listAllStudentBorrowHistoryByID(Connection con,String stuID) throws SQLException{
        String sql = "select * from Student,StudentBorrow,Equipment where Student.stuID=StudentBorrow.stuID and StudentBorrow.equipID=Equipment.equipID and Student.stuID=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,stuID);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
    //返回所有指定教工号老师的借用历史信息
    public ResultSet listAllTeacherBorrowHistoryByID(Connection con,String teaID) throws SQLException{
        String sql = "select * from Teacher,TeacherBorrow,Equipment where Teacher.teaID=TeacherBorrow.teaID and TeacherBorrow.equipID=Equipment.equipID and Teacher.teaID=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,teaID);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
}

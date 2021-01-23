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
import model.Student;
import util.StringUtil;

/**
 *
 * @author ZP Chen
 */
//学生信息操作类，实现学生添加、查询、修改等操作
public class StudentInfo {
    //学生信息添加操作
    public int studentInfoAdd(Connection con,Student stu) throws SQLException{
        String sql = "insert into Student(stuID,stuName,stuSex,stuCollege,stuDepartment,stuType,stuPhone,stuRemark,stuIsBlackList) values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,stu.getStuID());
        pstm.setString(2,stu.getStuName());
        pstm.setString(3,stu.getStuSex());
        pstm.setString(4,stu.getStuCollege());
        pstm.setString(5,stu.getStuDepartment());
        pstm.setString(6,stu.getStuType());
        pstm.setString(7,stu.getStuPhone());
        pstm.setString(8,stu.getRemark());
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
    //返回当前学生是否已存在
    public boolean checkExist(Connection con,String stuID) throws SQLException{
        String sql = "select * from Student where stuID=?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,stuID);
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
    public ResultSet listByName(Connection con,Student student) throws SQLException{
        StringBuilder sb = new StringBuilder("select * from Student");
        if(StringUtil.isNotEmpty(student.getStuName())){
            sb.append(" where stuName like '%").append(student.getStuName()).append("%'");
        }
        PreparedStatement pstmt = con.prepareStatement(sb.toString());
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
    //实现按学号查询操作
    public ResultSet listByID(Connection con,String stuID) throws SQLException{
        StringBuilder sb = new StringBuilder("select * from Student where stuID = ?");
        PreparedStatement pstmt = con.prepareStatement(sb.toString());
        pstmt.setString(1, stuID);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
    //查询输入的学号是否存在
    public boolean isStuIDExist(Connection con,String stuID) throws SQLException{
        String sql = "select * from Student where stuID = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,stuID);
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
    //查询输入的学号是否为黑名单
    public boolean isStuIDBlack(Connection con,String stuID) throws SQLException{
        String sql = "select stuIsBlackList from Student where stuID = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,stuID);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            if(rs.getString("stuIsBlackList").equals("Yes"))
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
    //学生信息修改
    public int updateInfo(Connection con,Student stu) throws SQLException{
        String sql = "update Student set stuCollege=?,stuDepartment=?,stuPhone=?,stuRemark=? where stuID=?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,stu.getStuCollege());
        pstm.setString(2,stu.getStuDepartment());
        pstm.setString(3,stu.getStuPhone());
        pstm.setString(4,stu.getRemark());
        pstm.setString(5,stu.getStuID());
        try{
            return pstm.executeUpdate();
        }catch(SQLException e){
            return 0;
        }finally{
            con.close();
        }
    }
    //学生信息删除
    public int deleteInfo(Connection con,String stuID) throws SQLException{
        String sql = "delete from Student where stuID=?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,stuID);
        try{
            return pstm.executeUpdate();
        }catch(SQLException e){
            return 0;
        }finally{
            con.close();
        }
    }
    //返回当前学号已经借用的器材数
    public int countEquipBorrow(Connection con,String stuID) throws SQLException{
        String sql = "select count(*) as countEquipBorrow from StudentBorrow where stuID=? and returnDate is null";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,stuID);
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
        String sql = "select * from Student where stuIsBlackList='Yes'";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
    //实现按学号和黑名单双重条件查询操作
    public ResultSet listByIDAndBlack(Connection con,String stuID) throws SQLException{
        String sql = "select * from Student where stuID = ? and stuIsBlackList='Yes'";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, stuID);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
}

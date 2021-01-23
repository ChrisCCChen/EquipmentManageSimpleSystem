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
public class ReturnInfo {
    //老师归还器材时检查该记录是否已存在数据库
    public boolean teacherReturnCheck(Connection con,String teaID,String equipID) throws SQLException{
        String sql = "select * from TeacherBorrow where teaID=? and equipID=?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,teaID);
        pstm.setInt(2,Integer.valueOf(equipID));
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
    //学生归还器材时检查该记录是否已存在数据库
    public boolean studentReturnCheck(Connection con,String stuID,String equipID) throws SQLException{
        String sql = "select * from StudentBorrow where stuID=? and equipID=?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,stuID);
        pstm.setInt(2,Integer.valueOf(equipID));
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
    //学生归还器材时检查该条记录是否已被归还
    public boolean equipStateStudentCheck(Connection con,String stuID,String equipID) throws SQLException{
        String sql = "select * from StudentBorrow where stuID=? and equipID=? and returnDate is null";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,stuID);
        pstm.setInt(2,Integer.valueOf(equipID));
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
    //老师归还器材时检查该条记录是否已被归还
    public boolean equipStateTeacherCheck(Connection con,String teaID,String equipID) throws SQLException{
        String sql = "select * from TeacherBorrow where teaID=? and equipID=? and returnDate is null";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,teaID);
        pstm.setInt(2,Integer.valueOf(equipID));
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
    //老师归还操作
    public int teacherReturnOperation(Connection con,String teaID,String equipID) throws SQLException{
        String sql = "update TeacherBorrow set returnDate=Date() where teaID=? and equipID=? and returnDate is null";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,teaID);
        pstm.setInt(2,Integer.valueOf(equipID));
        try{
            return pstm.executeUpdate();
        }catch(SQLException e){
            return 0;
        }finally{
            con.close();
        }
    }
    //学生归还操作
    public int studentReturnOperation(Connection con,String stuID,String equipID) throws SQLException{
        String sql = "update StudentBorrow set returnDate=Date() where stuID=? and equipID=? and returnDate is null";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,stuID);
        pstm.setInt(2,Integer.valueOf(equipID));
        try{
            return pstm.executeUpdate();
        }catch(SQLException e){
            return 0;
        }finally{
            con.close();
        }
    }
    //返回学生本次归还距离截止归还日期的相差天数
    public int studentReturnCheckInTime(Connection con,String stuID,String equipID) throws SQLException{
        String sql = "select datediff('d',returnDate,expireDate) as diffDay from StudentBorrow where stuID=? and equipID=?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,stuID);
        pstm.setInt(2,Integer.valueOf(equipID));
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            int diffDay = rs.getInt("diffDay");
            con.close();
            return diffDay;
        }
        else{
            con.close();
            return 1;
        }
    }
    //返回老师本次归还距离截止归还日期的相差天数
    public int teacherReturnCheckInTime(Connection con,String teaID,String equipID) throws SQLException{
        String sql = "select datediff('d',returnDate,expireDate) as diffDay from TeacherBorrow where teaID=? and equipID=?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,teaID);
        pstm.setInt(2,Integer.valueOf(equipID));
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            int diffDay = rs.getInt("diffDay");
            con.close();
            return diffDay;
        }
        else{
            con.close();
            return 1;
        }
    }
}

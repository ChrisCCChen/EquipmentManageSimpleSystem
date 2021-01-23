/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Admin;
import util.DbUtil;

/**
 *
 * @author ZP Chen
 */

//管理员登录验证
public class LogInVerify {
    public Admin Login(Connection con,Admin admin) throws Exception{
        Admin resultAdmin = null;
        String sql = "select * from Admin where LogInName = ? and LogInPassword = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,admin.getLogInName());
        pstmt.setString(2,admin.getLogInPassword());
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            resultAdmin = new Admin();
            resultAdmin.setLogInName(rs.getString("LogInName"));
            resultAdmin.setLogInPassword(rs.getString("LogInPassword"));
        }
        return resultAdmin;
    }
}

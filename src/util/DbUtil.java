/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Admin;
/**
 *
 * @author ZP Chen
 */

//数据库自制工具
public class DbUtil {
    private String dbUrl = "jdbc:odbc:MyDb";
    private String dbUserName = "";
    private String dbUserPassword = "";
    private String jdbcName = "sun.jdbc.odbc.JdbcOdbcDriver";
    
    //数据库连接
    public Connection getConnection() throws Exception{
        Class.forName(jdbcName);
        Connection con = DriverManager.getConnection(dbUrl,dbUserName,dbUserPassword);
        return con;
    }
    
    //数据库关闭
    public void closeConnection(Connection con) throws Exception{
        if(con != null && !con.isClosed()){
            con.close();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package function;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ZP Chen
 */
public class BlackInfo {
    public void updateBlackList(Connection con,String ID,String type) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String sql;
        if(type.equals("学生")){
            sql = "update Student set stuIsBlackList = ? where stuID = ?";
        }
        else{
            sql = "update Teacher set teaIsBlackList = ? where teaID = ?";
        }
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(2, ID);
        pstmt.setString(1, "Yes");
        try{
            pstmt.executeUpdate();
        }catch(SQLException | HeadlessException e){

        }
        finally{
            con.close();
        }

    }
}


package users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import DB.connection;
import java.sql.Connection;


public class student extends user
{
    Connection c =connection.conDB();
    public void show_courses(DefaultTableModel dtm)
    {   
        try {
            Statement st = c.createStatement();
            String sql = "select * from courses";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("name"), rs.getString("lec_time"),rs.getString("lec_day"),rs.getString("credit_hours")});
            }
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
    }
    public void reg_courses()
    {
        
    }
    
   
   
   
   
    
    
}

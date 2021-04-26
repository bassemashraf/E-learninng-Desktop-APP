
package users;

import DB.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public   class  Admin {
    
    Connection c =connection.conDB();
    public  void add_users(String username,String password,String usertype) {                                         
        try{
            Statement add=c.createStatement();
            String sql="insert into  user(username,password,usertype) VALUES('"+username+"','"+password+"','"+usertype+"')";      
            add.executeUpdate(sql);
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null,"user name already used ","Error",JOptionPane.ERROR_MESSAGE);
        }  
}
    //----------------------------------------------------------
     
    
    public void show_users(DefaultTableModel dtm)
    {   
        try {
            Statement st = c.createStatement();
            String sql = "select * from user";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("username"), rs.getString("password"),rs.getString("usertype"),rs.getString("id")});
            }
         } catch (SQLException ex) {
             System.out.println(ex.getStackTrace());
         }
    }
    
    //----------------------------------------------------------
    public void delete_user(int id)
    {
        try {
            Statement delete=c.createStatement();
            String sql="delete from user where id="+id;
            delete.executeUpdate(sql);
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
    }
    //-------------------------------------------------
    public void update_user(String username,String password,String usertype,int id )
    {
      try {
            Statement delete=c.createStatement();
            String sql="update user set username='"+username+"',password='"+password+"',usertype='"+usertype+"' where id ="+id;
            delete.executeUpdate(sql);
        } catch (Exception e) 
        {
            e.printStackTrace();
        }  
    
    }
    //-------------------------------------------------------------------------------------
    //mange courses -------- 
    
    public  void add_course(String coursename,int credithours ,String lecday, String lectime) {                                         
        try{
            Statement add=c.createStatement();
            String sql="insert into  courses(name,lec_day,lec_time,credit_hours) VALUES('"+coursename+"','"+lecday+"','"+lectime+"','"+credithours+"')";      
            add.executeUpdate(sql);
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null,"course name already found ","Error",JOptionPane.ERROR_MESSAGE);
          e.printStackTrace();
        }  
}
    //----------------------------------------------------------
     
    
    public void show_courses(DefaultTableModel dtm)
    {   
        try {
            Statement st = c.createStatement();
            String sql = "select * from courses";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("name"), rs.getString("lec_day"),rs.getString("lec_time"),rs.getString("credit_hours"),rs.getString("course_id")});
            }
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
    }
    
    //----------------------------------------------------------
    public void delete_course(int id)
    {
        try {
            Statement delete=c.createStatement();
            String sql="delete from courses where id="+id;
            delete.executeUpdate(sql);
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
    }
    //-------------------------------------------------
    public void update_course(String coursename,String lecday,String lecime,int credithours,int id )
    {
      try {
            Statement delete=c.createStatement();
            String sql="update courses set name='"+coursename+"',lec_day='"+lecday+"',lec_time='"+lecime+"',credit_hours='"+credithours+"' where course_id ="+id;
            delete.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"update complete","Done",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) 
        {
            e.printStackTrace();
        }  
    
    }
    //-------------------------------------------------------------------------------------
}

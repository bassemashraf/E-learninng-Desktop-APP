package DB ;

import java.sql.*;

public class connection {
     

   public static Connection conn = null;
    ResultSet ress = null;
    PreparedStatement perr = null;
    Statement stat = null;
    private  connection ()
    {
        
    }
    public static synchronized Connection conDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root","");
            return conn ;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("no connection");
            return null;
        } 
    }
}

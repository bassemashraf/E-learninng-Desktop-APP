
package users;

import  DB.connection;
import gui.*;
import java.sql.Statement;
import DB.connection;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import gui.Admin_dashboard;
import gui.studentpage;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    
    public static void main(String[] args) throws MalformedURLException, SQLException {
         /*Admin_users admin =new Admin_users();
         admin.setVisible(true);*/
         
       Admin_users l =new Admin_users();
       l.setVisible(true);
        /* Admin_dashboard admin =new Admin_dashboard();
         admin.setVisible(true); }*/
    
}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import  DB.connection;

/**
 *
 * @author lap
 */
public abstract class user implements login{
    private  int id ;
    private  String username;
    private  String password;
    private  int usertype ;
    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }    
    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public int getUsertype() {
        return usertype;
    }   

    @Override
    public int login(String username, String password) 
    {
        try {
            Connection c =connection.conDB();
            
            String sql = "SELECT * FROM user Where username = '" + username + "' and  password = '" + password + "'";

            Statement s = c.createStatement();
            PreparedStatement pre = null;
            ResultSet res = null;
            ResultSet rs = s.executeQuery("SELECT * FROM user ");
            

            while (rs.next()) {

                if (rs.getString("username").equals(username) && rs.getString("password").equals(password)) {
                    setId(rs.getInt("id"));
                    setUsertype(rs.getInt("usertype"));
                }
            }
            pre = c.prepareStatement(sql);
            res = pre.executeQuery();

            if (!res.next()) {
                setId(-1);
                return getId();
            } else
            {
                return  getId();
            }
        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());

        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

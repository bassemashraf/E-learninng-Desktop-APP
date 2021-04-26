/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import users.Admin;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sun.security.x509.URIName;

/**
 *
 * @author lap
 */
public class Admin_users extends JFrame   {
    public Admin_users(){
        Admin a =new Admin();
      setSize(650, 550);
        setTitle("Users Managment ");
        Container cp = getContentPane();
        cp.setLayout(null);

        
       
        //label
        
        JLabel username = new JLabel("Username");
        cp.add(username);
        username.setBounds(50,285, 80, 40);
        username.setFont(new Font("Arial", Font.PLAIN, 16) );
        JLabel id = new JLabel("ID");
        cp.add(id);
        id.setBounds(220, 285, 80, 40);
        id.setFont(new Font("Arial", Font.PLAIN, 16));
        JLabel usertybe = new JLabel("User Type");
        cp.add(usertybe);
        usertybe.setBounds(320, 285, 80, 40);
        usertybe.setFont(new Font("Arial", Font.PLAIN, 16));
        JLabel password = new JLabel("password");
        cp.add(password);
        password.setBounds(450, 285, 80, 40);
        password.setFont(new Font("Arial", Font.PLAIN, 16));

        //line label
        JLabel line2 = new JLabel("_____________________________________________________");
        cp.add(line2);
        line2.setBounds(20, 330,1000, 50);
        line2.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel line3 = new JLabel("_____________________________________________________");
        cp.add(line3);
        line3.setBounds(20, 255, 1000, 50);
        line3.setFont(new Font("Arial", Font.PLAIN, 20));

        //taxt field
         JTextField uname = new JTextField();
        cp.add(uname);
        uname.setBounds(45, 315, 80, 40);
        uname.setFont(new Font("Arial", Font.PLAIN, 20));
         JTextField uid = new JTextField();
        cp.add(uid);
        uid.setBounds(190, 315, 80, 40);
        uid.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField utype = new JTextField();
        cp.add(utype);
        utype.setBounds(325, 315, 80, 40);
        utype.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField up = new JTextField();
        cp.add(up);
        up.setBounds(465, 315, 80, 40);
        up.setFont(new Font("Arial", Font.PLAIN, 20));
         //buttons-----------
        JButton adduser = new JButton("Add User");
        cp.add(adduser);
        adduser.setBounds(5, 420, 170, 40);
        adduser.setFont(new Font("Arial", Font.PLAIN, 20) );
         
        //----------------------------------------------------------
        
        
        
        JButton deluser = new JButton("Delet User");
        cp.add(deluser);
        deluser.setBounds(190, 420, 200, 40);
        deluser.setFont(new Font("Arial", Font.PLAIN, 20));
        
        //----------------------------------------------------------------
        
        
        
        JButton upuser = new JButton("Update User");
        cp.add(upuser);
        upuser.setBounds(410, 420, 210, 40);
        upuser.setFont(new Font("Arial", Font.PLAIN, 20));
        
        //--------------------------------------------------------------


        //table
         DefaultTableModel dtm = new DefaultTableModel();
        String[] columnNames = {" username",
            "password","usertype","ID"};
        Object[][] data = {};
        final JTable table = new JTable(data, columnNames);
        table.setModel(dtm);
        cp.add(table);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setBounds(0, 42, 650, 230);
        cp.setLayout(new BorderLayout());
        cp.add(table, BorderLayout.PAGE_START);
        cp.add(table.getTableHeader(), BorderLayout.PAGE_START);
        table.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 20));
        int HEADER_HEIGHT = 42;
        table.getTableHeader().setPreferredSize(new Dimension(1000, HEADER_HEIGHT));
        dtm.addColumn("Username");
        dtm.addColumn("Password");
        dtm.addColumn("usertype");
        dtm.addColumn("ID");
        a.show_users(dtm);
        table.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {

                    int i = table.getSelectedRow();
                    utype.setText(dtm.getValueAt(i, 2).toString());
                    uid.setText(dtm.getValueAt(i, 3).toString());
                    uname.setText(dtm.getValueAt(i, 0).toString());
                    up.setText(dtm.getValueAt(i, 1).toString());
                }
            });

            upuser.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    int i = table.getSelectedRow();
                    if (i >= 0) {
                        dtm.setValueAt(uname.getText(), i, 0);
                        dtm.setValueAt(uid.getText(), i, 2);
                        dtm.setValueAt(utype.getText(), i, 3);
                        dtm.setValueAt(up.getText(), i, 1);
                    }
                }

            });
            
            
            
            //action of button add
            adduser.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
                    
        {          
           clear_table(dtm);
          a.add_users(uname.getText(),up.getText(),utype.getText());
          a.show_users(dtm);
        } 
        });
            
            //----------------------
            //action of del user
             deluser.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
                    
        {
            clear_table(dtm);
            
            a.delete_user(Integer.parseInt(uid.getText()));
           
            a.show_users(dtm);      
          
        } 
        });
             
             //---------------------------
             //action of update user
              upuser.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
                    
        {
            clear_table(dtm);
            a.update_user(uname.getText(),up.getText(),utype.getText(),Integer.parseInt(uid.getText()));
           a.show_users(dtm);
        } 
        });
              
        }
    
    public void clear_table(DefaultTableModel dtm)
    {
         int rowCount = dtm.getRowCount();

             for (int i = rowCount - 1; i >= 0; i--) 
             {
                dtm.removeRow(i);
             }
    }
    
    
}

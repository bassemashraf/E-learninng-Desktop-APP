package gui;

import users.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Login_view extends JFrame {
    public Login_view() throws MalformedURLException, SQLException {
        user u=new student();
        
        setSize(500, 400);
        setTitle("Login Page");
        Container cp = getContentPane();

        //text field
        final JTextField name = new JTextField(null);
        cp.add(name);
        name.setBounds(210, 80, 160, 40);
        final JPasswordField pass = new JPasswordField();
        cp.add(pass);
        pass.setBounds(210, 165, 160, 40);

        //label
        JLabel userName = new JLabel("User Name:");
        cp.add(userName);
        userName.setBounds(40, 50, 200, 90);
        userName.setFont(new Font("Arial", Font.PLAIN, 30));
        JLabel Password = new JLabel("Password:");
        cp.add(Password);
        Password.setBounds(40, 140, 150, 90);
        Password.setFont(new Font("Arial", Font.PLAIN, 30));

        //button
        JButton login1 = new JButton("Login");
        cp.setLayout(null);
        cp.add(login1);
        login1.setBounds(120, 250, 250, 50);
        login1.setFont(new Font("Arial", Font.PLAIN, 30));
        login1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                try {
                   
                     u.login(name.getText(), pass.getText());
                    if (u.getId() == -1) {
                        JOptionPane.showMessageDialog(null, "login falid", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        if(u.getUsertype()==0){
                            studentpage student = new studentpage();
                            student.setVisible(true);
                            
                        }
                        if(u.getUsertype()== 1){
                           doctorpage doctor = new doctorpage();
                           doctor.setVisible(true);
                             
                        }
                        if(u.getUsertype()==2){
                            Admin_dashboard admin = new Admin_dashboard();
                            admin.setVisible(true);
                        }
                    }
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Login_view.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}

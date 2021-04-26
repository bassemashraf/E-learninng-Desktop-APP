
package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import users.student;


public class studentpage  extends JFrame{
    public studentpage() throws MalformedURLException {
        student s=new student();
        
        
        setSize(650, 650);
        setTitle("Student Page");
        Container cp = getContentPane();
        

        //button
        JButton assig = new JButton("Exams");
        cp.add(assig);
        assig.setBounds(30, 460, 220, 40);
        assig.setFont(new Font("Arial", Font.PLAIN, 20));
        JButton drop = new JButton(" Drop Course");
        cp.add(drop);
        drop.setBounds(350, 460, 210, 40);
        drop.setFont(new Font("Arial", Font.PLAIN, 20));
        JButton add = new JButton("Add Course");
        cp.add(add);
        add.setBounds(200, 510, 210, 40);
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        
        
        //label
        JLabel l1 = new JLabel("Courae Name :");
        cp.add(l1);
        l1.setBounds(40, 310, 150, 50);
        l1.setFont(new Font("Arial", Font.PLAIN, 20));
       
        /*JLabel l2 = new JLabel("Time");
        cp.add(l2);
        l2.setBounds(350, 310, 100, 50);
        l2.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel l3 = new JLabel("Lecture");
        cp.add(l3);
        l3.setBounds(40, 370, 100, 50);
        l3.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel l4 = new JLabel("Time");
        cp.add(l4);
        l4.setBounds(350, 370, 100, 50);
        l4.setFont(new Font("Arial", Font.PLAIN, 20));*/
        
        
        //JTextField
        JTextField CourseName = new JTextField();
        cp.add(CourseName);
        CourseName.setBounds(190, 315, 180, 40);
        CourseName.setFont(new Font("Arial", Font.PLAIN, 20));
        
        
        
        
        //line label
        JLabel line2 = new JLabel("_____________________________________________________");
        cp.add(line2);
        line2.setBounds(20, 410,1000, 50);
        line2.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel line3 = new JLabel("_____________________________________________________");
        cp.add(line3);
        line3.setBounds(20, 255, 1000, 50);
        line3.setFont(new Font("Arial", Font.PLAIN, 20));

        //table
        final DefaultTableModel dtm = new DefaultTableModel();
        String[] columnNames = {"Course Name","lec day ","Time","Crediy Hours "};
        Object[][] data = {};
        final JTable table = new JTable(data, columnNames);
        table.setModel(dtm);
        cp.add(table);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setBounds(0, 43, 650, 230);
        cp.setLayout(new BorderLayout());
        cp.add(table, BorderLayout.PAGE_START);
        cp.add(table.getTableHeader(), BorderLayout.PAGE_START);
        table.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 20));
        int HEADER_HEIGHT = 42;
        table.getTableHeader().setPreferredSize(new Dimension(10000, HEADER_HEIGHT));
        dtm.addColumn("Course Name");
        dtm.addColumn("Lec Day");
        dtm.addColumn("Time");
         dtm.addColumn("Credit Hours ");
         s.show_courses(dtm);
          table.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    int i = table.getSelectedRow();
                    CourseName.setText(dtm.getValueAt(i,0).toString());
                }
            });

    }         
}

package hotel.management.system;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee extends JFrame {
    Employee(){
        JPanel  panel = new JPanel();
     panel.setBounds(5,5,99,590);
 panel.setBackground(new Color(21, 64, 65));
panel.setLayout(null);
add(panel);


JTable table =  new JTable();
table.setBounds(10,34,980,450);
table.setForeground(Color.WHITE);
table.setBackground(new Color(21, 64, 65));
panel.add(table);

 try{
     con c= new con();
     String EmployeeSQL = "select * from Employee";
     ResultSet resultSet = c.statement.executeQuery(EmployeeSQL);
     table.setModel(DbUtils.resultSetToTableModel(resultSet));

 }catch (Exception e) {
     e.printStackTrace();
 }


     JButton back = new JButton("Back");
     back.setBounds(350,500,120,30);
     back.setBackground(Color.WHITE);
     back.setForeground(Color.BLACK);
     panel.add(back);
     back.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             setVisible(false);
         }
     });


     JLabel name = new JLabel("Name");
     name.setForeground(Color.WHITE);
     name.setBounds(41,11,70,19);
     name.setFont(new Font("Tahoma",Font.BOLD,14));
     panel.add(name);


        JLabel age  = new JLabel("Age");
        age.setForeground(Color.WHITE);
        age.setBounds(159,11,70,19);
        age.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(age);


        JLabel gender = new JLabel("Gender");
        gender.setForeground(Color.WHITE);
        gender.setBounds(273,11,70,19);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(gender);


        JLabel job = new JLabel("Job");
        job.setForeground(Color.WHITE);
        job.setBounds(416,11,70,19);
        job.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(job);

        JLabel salary = new JLabel("Salary");
        salary.setForeground(Color.WHITE);
        salary.setBounds(536,11,70,19);
        salary.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(salary);


        JLabel phone = new JLabel("Phone");
        phone.setForeground(Color.WHITE);
        phone.setBounds(656,11,70,19);
        phone.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(phone);


        JLabel email = new JLabel("Email ");
        email .setForeground(Color.WHITE);
        email.setBounds(786,11,70,19);
        email.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(email);

        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setForeground(Color.WHITE);
        aadhar.setBounds(906,11,70,19);
        aadhar.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(aadhar);

 setSize(1000,600);
 setVisible(true);
 setLocation(430,100);
 setLayout(null);
 setUndecorated(true);
    }
    public static void main(String[] args) {
        new Employee();
    }
}

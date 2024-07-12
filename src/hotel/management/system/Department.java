package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {
    JTable table;

    Department(){

        JPanel panel= new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(21, 64, 65));
        panel.setLayout(null);
        add(panel);


        JTable table= new JTable();
        table.setBackground(new Color(21, 64, 65));
        table.setForeground(Color.WHITE);
        table.setBounds(0,40,700,350);
      panel.add(table);


      try{
           con c= new con();
           String q = "select * from department";
          ResultSet resultSet= c.statement.executeQuery(q);
          table.setModel(DbUtils.resultSetToTableModel(resultSet));



      }
      catch(Exception e){
          e.printStackTrace();
      }


      JButton back = new JButton("Back");
      back.setBounds(400,410,120,30);
      back.setBackground(  Color.WHITE);
      back.setForeground(Color.BLACK);
      panel.add(back);
      back.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              setVisible(false);
          }
      });


      JLabel label1= new JLabel("Department");
      label1.setBounds(145,11,105,14);
      label1.setForeground(Color.WHITE);
      label1.setFont(new Font("Tahoma", Font.BOLD,14));
      panel.add(label1);

        JLabel label2= new JLabel("Budget");
        label2.setBounds(431,11,105,14);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(label2);





        setLayout(null);
        setLocation(550,150);
        setSize(700,500);
        setVisible(true);



    }
    public static void main(String[] args) {
        new Department();
    }
}

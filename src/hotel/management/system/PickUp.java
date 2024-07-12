package hotel.management.system;

import com.mysql.cj.protocol.a.BinaryResultsetReader;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickUp extends JFrame  {
    PickUp(){

        JPanel panel = new JPanel();
        panel.setBackground(new Color(21, 64, 65));
        panel.setBounds(5,5,790,590);
        panel.setLayout(null);
        add(panel);


        JLabel  pus = new JLabel("Pick Up Service");
        pus.setBounds(90,11,160,20);
        pus.setForeground(Color.WHITE);
        pus.setFont(new Font("Tahoma",Font.BOLD,14));
           panel.add(pus);


        JLabel  TOC = new JLabel("Type of Car");
        TOC.setBounds(32,97,89,14);
        TOC.setForeground(Color.WHITE);
        TOC.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(TOC);


        Choice c= new Choice();
        c.setBounds(123,94,150,25);
        panel.add(c);


        try{
            con C = new con();
            ResultSet resultSet= C.statement.executeQuery("select * from driver");
            while(resultSet.next()) {
                c.add(resultSet.getString("company"));
            }
        }catch( Exception e){
            e.printStackTrace();

        }


        JTable table = new JTable();
        table.setBounds(10,233,800,250);
        table.setBackground(new Color(21, 64, 65));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            con C=  new con();
            String q ="select * from driver";
            ResultSet resultSet= C.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));



        }
        catch( Exception e){
            e.printStackTrace();

        }


        JLabel name  = new JLabel("Name");
        name.setForeground(Color.WHITE);
        name.setBounds(24,208,46,14);
        panel.add(name);


        JLabel age  = new JLabel("Age");
        age.setForeground(Color.WHITE);
        age.setBounds(165,208,46,14);
        panel.add(age);

        JLabel gender  = new JLabel("Gender");
        gender.setForeground(Color.WHITE);
        gender.setBounds(264,208,46,14);
        panel.add(gender);

        JLabel company  = new JLabel("Company");
        company.setForeground(Color.WHITE);
        company.setBounds(366,208,100,14);
        panel.add(company);

        JLabel available  = new JLabel("Available");
        available.setForeground(Color.WHITE);
        available.setBounds(480,208,100,14);
        panel.add(available);


        JLabel location  = new JLabel("Location");
        location.setForeground(Color.WHITE);
        location.setBounds(600,208,100,14);
        panel.add(location);


        JButton display = new JButton("Display");
        display.setBounds(200,500,120,30);
        display.setBackground(Color.WHITE);
        display.setForeground(Color.BLACK);
        panel.add(display);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from driver where company ='"+c.getSelectedItem()+"'";
                try{
                    con c= new con();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));


                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(420,500,120,30);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);

        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });







        setLayout(null);
        setLocation(500,100);
        setVisible(true);
        setSize(800,600);

    }
    public static void main(String[] args) {
        new PickUp();
    }
}

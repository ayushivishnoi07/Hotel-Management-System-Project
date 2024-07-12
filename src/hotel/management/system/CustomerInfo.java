package hotel.management.system;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo  extends JFrame {
    CustomerInfo(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(21, 64, 65));
        panel.setLayout(null);
        add(panel);


        JTable table = new JTable();
        table.setBounds(10,40,980,450);
        table.setBackground(new Color(21, 64, 65));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            con c= new con();
            String  q = "select * from customer";
            ResultSet resultSet= c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));


        }catch(Exception e){
            e.printStackTrace();

        }
        JLabel id = new JLabel("id");
        id.setBounds(31,11,100,14);
        id.setForeground(Color.WHITE);
        id.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(id);

        JLabel number  = new JLabel("Number");
        number.setBounds(150,11,100,14);
        number.setForeground(Color.WHITE);
        number.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(number);

        JLabel name = new JLabel("Name");
        name.setBounds(270,11,100,14);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(name);


        JLabel gender = new JLabel("Gender");
        gender.setBounds(400,11,100,14);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(gender);

        JLabel country = new JLabel("Country");
        country.setBounds(520,11,100,25);
        country.setForeground(Color.WHITE);
        country.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(country);

        JLabel room = new JLabel("Room");
        room.setBounds(650,11,100,14);
        room.setForeground(Color.WHITE);
        room.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(room);

        JLabel citime = new JLabel("Date");
        citime.setBounds(770,15,100,14);
        citime.setForeground(Color.WHITE);
        citime.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(citime);

        JLabel deposit = new JLabel("Deposit");
        deposit.setBounds(890,11,100,25);
        deposit.setForeground(Color.WHITE);
        deposit.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(deposit);

       JButton  back= new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.white);
        back.setBounds(450,510,120,30);
        panel.add(back);
        back.addActionListener( new ActionListener(){
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        setVisible(false);
                                    }
                                });

        setSize(1000,600);
        setVisible(true);
        setLocation(500,100);
        setLayout(null);
        setUndecorated(true);
    }
    public static void main(String[] args) {
        new CustomerInfo();
    }
}

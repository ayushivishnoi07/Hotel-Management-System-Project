package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CheckOut extends JFrame {

    CheckOut() {

        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(21, 64, 65));
        panel.setLayout(null);
        add(panel);

         JLabel label = new JLabel("Check Out");
         label.setBounds(100,20,150,30);
         label.setForeground(Color.WHITE);
         label.setFont(new Font ("Tahoma", Font.PLAIN, 20));
        panel.add(label);

        JLabel userid = new JLabel("Customer ID");
        userid.setBounds(30,80,150,30);
        userid.setForeground(Color.WHITE);
        userid.setFont(new Font ("Tahoma", Font.BOLD, 14));
        panel.add(userid);


        Choice customer= new Choice();
        customer.setBounds(200,80,150,25);
        panel.add(customer);


        JLabel roomnum = new JLabel("Room Number");
        roomnum.setBounds(30,130,150,30);
        roomnum.setForeground(Color.WHITE);
        roomnum.setFont(new Font ("Tahoma", Font.BOLD, 14));
        panel.add(roomnum);


        JLabel labelroomnum = new JLabel();
        labelroomnum.setBounds(200,130,150,30);
        labelroomnum.setForeground(Color.WHITE);
        labelroomnum.setFont(new Font ("Tahoma", Font.BOLD, 14));
        panel.add(labelroomnum);


        JLabel checkintime = new JLabel("Check-In time");
        checkintime.setBounds(30,180,150,30);
        checkintime.setForeground(Color.WHITE);
        checkintime.setFont(new Font ("Tahoma", Font.BOLD, 14));
        panel.add(checkintime);

        JLabel labelcheckintime = new JLabel();
        labelcheckintime.setBounds(200,180,200,30);
        labelcheckintime.setForeground(Color.WHITE);
        labelcheckintime.setFont(new Font ("Tahoma", Font.BOLD, 14));
        panel.add(labelcheckintime);

        JLabel checkouttime = new JLabel("Check-Out Time");
        checkouttime.setBounds(30,230,150,30);
        checkouttime.setForeground(Color.WHITE);
        checkouttime.setFont(new Font ("Tahoma", Font.BOLD, 14));
        panel.add(checkouttime);

        Date date = new Date();

        JLabel labelcheckouttime = new JLabel(""+date);
        labelcheckouttime.setBounds(200,230,200,30);
        labelcheckouttime.setForeground(Color.WHITE);
        labelcheckouttime.setFont(new Font ("Tahoma", Font.BOLD, 14));
        panel.add(labelcheckouttime);



try{
    con c = new con();
    ResultSet resultSet = c.statement.executeQuery("select * from customer");
    while (resultSet.next()){
        customer.add(resultSet.getString("number"));

    }





} catch( Exception E){
    E.printStackTrace();
}






        JButton check = new JButton("Check");
        check.setBounds(300,300,120,30);
        check.setBackground( Color.WHITE);
        check.setForeground(Color.BLACK);
        panel.add(check);

        JButton back = new JButton("Back");
        back.setBounds(170,300,120,30);
        back.setBackground( Color.WHITE);
        back.setForeground(Color.BLACK);

        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con  c = new con();

                try{
ResultSet resultSet = c.statement.executeQuery("select * from customer where number = '"+customer.getSelectedItem()+"'");

while(resultSet.next()){
    labelroomnum.setText(resultSet.getString(("room")));
    labelcheckintime.setText(resultSet.getString(("checkintime")));
}
            }catch(Exception E){
 E.printStackTrace();
                }
            }
        });





        JButton checkOut = new JButton("Check-Out");
        checkOut.setBounds(30,300,120,30);
        checkOut.setBackground( Color.WHITE);
        checkOut.setForeground(Color.BLACK);
        panel.add(checkOut);
        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    con cv = new con();
                    cv.statement.executeUpdate("delete from customer where number = '"+customer.getSelectedItem()+"'");
                    cv.statement.executeUpdate("update room set availability = 'Available' where roomnum= '"+labelroomnum.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);



                }catch( Exception E){
                    E.printStackTrace();
                }
            }
        });







        setLayout(null);
        setLocation(500,200);
        setSize(800,400);
        setVisible(true);
setUndecorated(true);

    }


    public static void main(String[] args) {
        new CheckOut();
    }
}
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import static java.awt.SystemColor.text;

public class login extends JFrame implements ActionListener{
    JTextField textField1;
    JPasswordField passwordField1;
    JButton b1, b2;


    login() {

        JLabel label1 = new JLabel("Username");
        label1.setBounds(40, 20, 100, 30);
        label1.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        label1.setForeground(Color.WHITE);
        add(label1);


        JLabel label2 = new JLabel("Password");
        label2.setBounds(40, 70, 100, 30);
        label2.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        label2.setForeground(Color.WHITE);
        add(label2);

        textField1 = new JTextField();
        textField1.setBounds(150, 20, 150, 30);
        textField1.setForeground(Color.BLACK);
        textField1.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        textField1.setBackground(new Color(240, 246, 246));
        add(textField1);

        passwordField1 = new JPasswordField();
        passwordField1.setBounds(150, 70, 150, 30);
        passwordField1.setBackground(new Color(239, 246, 246));
        passwordField1.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(passwordField1);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login0.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(225, 300, Image.SCALE_DEFAULT);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(315, -30, 255, 300);
        add(label);


        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("Tahoma", Font.BOLD, 15));
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("Tahoma", Font.BOLD, 15));
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(new Color(21, 64, 65));
        setLayout(null);
        setLocation(400, 270);
        setSize(600, 300);
        setVisible(true);
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == b1){
//            try{
//                   con c = new con();
//                   String user = textField1.getText();
//                   //String pass= passwordField1.getPassword().toString();
//                    String pass = String.valueOf(passwordField1.getPassword());
//                   String q = "select * from login where username='" +user+ "' and password= '"+pass+"'";
//                   ResultSet resultSet = c.statement.executeQuery(q);
//
//                   if (resultSet.next()) {
//                       new Dashboard();
//                       setVisible(false);
//                   }
//                   else{
//                           JOptionPane.showMessageDialog(null,"Invalid");
//                       }
//
//            }catch (Exception E){
//                E.printStackTrace();
//            }
//
//
//
//    } else{
//            System.exit(102);
//
// }
//
// }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            try{
                con c = new con();
                String user = textField1.getText();
                //String pass= passwordField1.getPassword().toString();
                String pass = String.valueOf(passwordField1.getPassword());
                String q = "select * from login where username='" +user+ "' and password='"+pass+"'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if (resultSet.next()) {
                    new reception();
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid");
                }

            }catch (Exception E){
                E.printStackTrace();
            }



        } else{
            new Dashboard();
            setVisible(false);

        }
    }



    public static void main(String[] args) {

  new login();

    }

}

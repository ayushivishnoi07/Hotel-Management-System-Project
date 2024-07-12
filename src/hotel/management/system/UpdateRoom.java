package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame {
    UpdateRoom(){
        JPanel panel= new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(21, 64, 65));
        panel.setLayout(null);
        add(panel);



        ImageIcon imageIcon = new ImageIcon((ClassLoader.getSystemResource("icon/updated.png")));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);


        JLabel label1 = new JLabel("Update Room Status");
        label1.setBounds(124,11,222,25);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(label1);


        JLabel label2 = new JLabel("ID  ");
        label2.setBounds(25,88,46,14);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(label2);

        Choice c = new Choice();
        c.setBounds(248,85,140,20);
        panel.add(c);

        try{
            con C= new con();
            ResultSet resultSet = C.statement.executeQuery("select * from customer");
            while(resultSet.next()){
                c.add(resultSet.getString("number"));
            }
        }catch(Exception E){
            E.printStackTrace();

        }




        JLabel label3 = new JLabel("Room Number ");
        label3.setBounds(25,129,107,14);
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(label3);


        JTextField textfield3 = new JTextField();
        textfield3.setBounds(248,129,140,20);
        panel.add(textfield3);

        JLabel label4 = new JLabel("Availability");
        label4.setBounds(25,174,97,14);
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(label4);


        JTextField textfield4 = new JTextField();
        textfield4.setBounds(248,174,140,20);
        panel.add(textfield4);

        JLabel label5 = new JLabel("Cleaning Status");
        label5.setBounds(25,216,97,14);
        label5.setForeground(Color.WHITE);
        label5.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(label5);


        JTextField textfield5 = new JTextField();
        textfield5.setBounds(248,216,140,20);
        panel.add(textfield5);

        JButton update = new JButton("Update");
        update.setBounds(120,315,89,23);
        update.setBackground( Color.WHITE);
        update.setForeground(Color.BLACK);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                   con C = new con();
                   String status =textfield5.getText();
                   C.statement.executeUpdate("update room set cleaning_status= '"+status+"' where roomnumber = '"+textfield3.getText()+"'");
                   JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(false);



                }catch(Exception E){
                    E.printStackTrace();

                }
            }
        });





        JButton back = new JButton("Check");
        back.setBounds(180,355,89,23);
        back.setBackground( Color.WHITE);
        back.setForeground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = c.getSelectedItem();
                String q= "select * from customer where number ='"+id+"'";
                try{
                    con c= new con();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while(resultSet.next()){
                        textfield3.setText(resultSet.getString("room"));




                    }

                    ResultSet resultSet1= c.statement.executeQuery("select * from room where roomnumber= '"+textfield3.getText()+"'");
                    while(resultSet1.next()){
                        textfield4.setText(resultSet1.getString("availability"));
                        textfield5.setText(resultSet1.getString("cleaning_status"));
                    }
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });


        JButton check = new JButton("Back");
        check.setBounds(60,355,89,23);
        check.setBackground( Color.WHITE);
        check.setForeground(Color.BLACK);
        panel.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setLayout(null);
        setSize(950,450);
        setLocation(400,200);
        setVisible(true);




    }
    public static void main(String[] args) {


        new UpdateRoom();
    }
}

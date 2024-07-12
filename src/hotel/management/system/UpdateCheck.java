package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck  extends JFrame {
     UpdateCheck(){
         JPanel panel= new JPanel();
         panel.setBounds(5,5,940,490);
         panel.setBackground(new Color(21, 64, 65));
         panel.setLayout(null);
         add(panel);



ImageIcon imageIcon = new ImageIcon((ClassLoader.getSystemResource("icon/update.png")));
Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
ImageIcon imageIcon1 = new ImageIcon(image);
JLabel label = new JLabel(imageIcon1);
label.setBounds(500,60,300,300);
panel.add(label);


             JLabel label1 = new JLabel("Check In Class");
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

         JLabel label4 = new JLabel("Name");
         label4.setBounds(25,174,97,14);
         label4.setForeground(Color.WHITE);
         label4.setFont(new Font("Tahoma",Font.PLAIN,14));
         panel.add(label4);


         JTextField textfield4 = new JTextField();
         textfield4.setBounds(248,174,140,20);
         panel.add(textfield4);

         JLabel label5 = new JLabel("Checked-In");
         label5.setBounds(25,216,97,14);
         label5.setForeground(Color.WHITE);
         label5.setFont(new Font("Tahoma",Font.PLAIN,14));
         panel.add(label5);


         JTextField textfield5 = new JTextField();
         textfield5.setBounds(248,216,140,20);
         panel.add(textfield5);


         JLabel label6 = new JLabel("Amount Paid(Rs)");
         label6.setBounds(25,261,150,14);
         label6.setForeground(Color.WHITE);
         label6.setFont(new Font("Tahoma",Font.PLAIN,14));
         panel.add(label6);


         JTextField textfield6 = new JTextField();
         textfield6.setBounds(248,261,140,20);
         panel.add(textfield6);

         JLabel label7 = new JLabel("Pending Amount(Rs)");
         label7.setBounds(25,302,150,14);
         label7.setForeground(Color.WHITE);
         label7.setFont(new Font("Tahoma",Font.PLAIN,14));
         panel.add(label7);


         JTextField textfield7 = new JTextField();
         textfield7.setBounds(248,302,140,20);
         panel.add(textfield7);


  JButton update = new JButton("Update");
  update.setBounds(56,378,89,23);
  update.setBackground( Color.WHITE);
  update.setForeground(Color.BLACK);
 panel.add(update);
 update.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
         try{
             con C= new con();
             String q= c.getSelectedItem();
            String room =  textfield3.getText();
             String name = textfield4.getText();
             String  check = textfield5.getText();
             String  amount = textfield6.getText();
              C.statement.executeUpdate("update customer set room = '"+room+"', name = '"+name+"', checkintime = '"+check+"', deposit= '"+amount+"' where number = '"+q+"'");
JOptionPane.showMessageDialog(null,"Updated Successfully");
setVisible(false);



         }catch(Exception E){
             E.printStackTrace();

         }
     }
 });





         JButton back = new JButton("Check");
         back.setBounds(168,378,89,23);
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
         textfield4.setText(resultSet.getString("name"));
         textfield5.setText(resultSet.getString("checkintime"));
         textfield6.setText(resultSet.getString("deposit"));



     }

     ResultSet resultSet1= c.statement.executeQuery("select * from room where roomnumber= '"+textfield3.getText()+"'");
while(resultSet1.next()){
    String price = resultSet1.getString("price");
    int amountPaid = Integer.parseInt(price) - Integer.parseInt(textfield6.getText());
    textfield7.setText(""+amountPaid);
}
                 }catch(Exception E){
                     E.printStackTrace();
                 }
             }
         });


         JButton check = new JButton("Back");
         check.setBounds(281,378,89,23);
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
         setSize(950,500);
         setLocation(400,200);
         setVisible(true);

    }

    public static void main(String[] args) {
        new UpdateCheck();
    }
}

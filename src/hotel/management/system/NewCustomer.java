package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NewCustomer extends JFrame implements ActionListener {
    JComboBox comboBox;
    JTextField textFieldNumber, textName,textCountry, textDeposit;
    JRadioButton r1,r2;

    Choice c1;

    JButton add, back;

JLabel date;

    NewCustomer(){






        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setLayout(null);
        panel.setBackground(new Color(21, 64, 65));
        add(panel);

        ImageIcon imageIcon = new ImageIcon((ClassLoader.getSystemResource("icon/customer.png")));

        Image image= imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);

        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imglabel = new JLabel(imageIcon1);
        imglabel.setBounds(550,150,200,200);
        panel.add(imglabel);


        JLabel labelName = new JLabel("New Customer Form");
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
         labelName.setForeground(Color.WHITE);
       panel.add(labelName);

       JLabel labelID= new JLabel(("ID"));
       labelID.setBounds(35,76,200,14);
       labelID.setForeground(Color.WHITE);
       labelID.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(labelID);

comboBox = new JComboBox((new String[]{"Password", "Aadhar Card", "Voter ID", "Driving license" }));
comboBox.setForeground(Color.WHITE);
comboBox.setBounds(271,73,150,20);
comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
comboBox.setBackground(new Color(21, 64, 65));
panel.add(comboBox);

        JLabel lableNumber = new JLabel("Number");
        lableNumber.setBounds(35,111,200,14);
        lableNumber.setFont(new Font("Tahoma",Font.BOLD,14));
        lableNumber.setForeground(Color.WHITE);
        panel.add(lableNumber);
 textFieldNumber= new JTextField();
   textFieldNumber.setBounds(271,111,150,20);
   panel.add(textFieldNumber);


        JLabel labelname = new JLabel("Name");
        labelname.setBounds(35,151,200,14);
        labelname.setFont(new Font("Tahoma",Font.BOLD,14));
        labelname.setForeground(Color.WHITE);
        panel.add(labelname);
        textName= new JTextField();
        textName.setBounds(271,151,150,20);
        panel.add(textName);

        JLabel labelgender = new JLabel("Gender");
        labelgender.setBounds(35,191,200,14);
        labelgender.setFont(new Font("Tahoma",Font.BOLD,14));
        labelgender.setForeground(Color.WHITE);
        panel.add(labelgender);

r1= new JRadioButton(("Male"));
r1.setFont(new Font("Tahoma",Font.BOLD,14));
r1.setForeground(Color.WHITE);
r1.setBackground(new Color(21, 64, 65));
r1.setBounds(271,191,80,12);
panel.add(r1);


        r2= new JRadioButton(("Female"));
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(21, 64, 65));
        r2.setBounds(350,191,80,12);
        panel.add(r2);

        JLabel labelCountry = new JLabel("Country");
        labelCountry.setBounds(35,231,200,14);
        labelCountry.setFont(new Font("Tahoma",Font.BOLD,14));
        labelCountry.setForeground(Color.WHITE);
        panel.add(labelCountry);
        textCountry= new JTextField();
        textCountry.setBounds(271,231,150,20);
        panel.add(textCountry);

        JLabel labelRoom = new JLabel("Allocated Room Number");
        labelRoom.setBounds(35,274,200,14);
        labelRoom.setFont(new Font("Tahoma",Font.BOLD,14));
        labelRoom.setForeground(Color.WHITE);
        panel.add(labelRoom);


c1= new Choice();
try{

    con c= new con();
    ResultSet resultSet= c.statement.executeQuery("select*from room");
    while(resultSet.next()){
        c1.add(resultSet.getString("roomnumber"));
    }

}catch(Exception e){
    e.printStackTrace();

        }
c1.setBounds(271,274,150,20);
c1.setFont(new Font("Tahoma",Font.BOLD, 14));
c1.setForeground(Color.WHITE);
c1.setBackground(new Color(21, 64, 65));
panel.add(c1);


        JLabel labelcis= new JLabel("Check-In  ");
        labelcis.setBounds(35,316,200,14);
        labelcis.setFont(new Font("Tahoma",Font.BOLD,14));
        labelcis.setForeground(Color.WHITE);
        panel.add(labelcis);



        Date date1 = new Date();

        date = new JLabel(""+date1);
        date.setBounds(271,316,200,14);
        date.setFont(new Font("Tahoma",Font.BOLD,14));
        date.setForeground(Color.WHITE);
        panel.add(date);


        JLabel labelDeposit = new JLabel("Deposit");
        labelDeposit.setBounds(35,359,200,14);
        labelDeposit.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDeposit.setForeground(Color.WHITE);
        panel.add(labelDeposit);
        textDeposit= new JTextField();
        textDeposit.setBounds(271,359,150,20);
        panel.add(textDeposit);


add= new JButton("Add");
add.setForeground(Color.BLACK);
add.setBackground(Color.WHITE);
add.setBounds(100,430,120,30);
add.addActionListener(this);
panel.add(add);

        back= new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.setBounds(260,430,120,30);

        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });







            setLayout(null);
        setLocation(500,150);
        setSize(850,550);
        setVisible(true);



    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == add){
            con c = new con();
            String radioBTn = null;
            if (r1.isSelected()){
                radioBTn = "Male";

            }else if(r2.isSelected()){
                radioBTn= "Female";
            }
            else{
                setVisible(false);
            }

            String s1 = (String)comboBox.getSelectedItem();
            String s2= textFieldNumber.getText();
            String s3 = textName.getText();
            String s4= radioBTn;
            String s5= textCountry.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textDeposit.getText();

            try{

                String q="insert into customer values('"+s1+"', '"+s2+"', '"+s3+"', '"+s4+"', '"+s5+"', '"+s6+"', '"+s7+"', '"+s8+"')";
                String q1=  "update room set availability = 'Occupied'where roomnumber="+s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Added Successfully");

            }catch(Exception E){
                E.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}

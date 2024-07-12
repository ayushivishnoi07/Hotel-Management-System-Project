package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reception  extends JFrame {
    reception(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(280,5,1238,820);
        panel.setBackground(new Color(21, 64, 65));
        add(panel);


 JPanel panel1= new JPanel();
 panel1.setLayout(null);
 panel1.setBounds(5,5,270,820);
 panel1.setBackground(new Color(21, 64, 65));
 add(panel1);


        ImageIcon i111= new ImageIcon(ClassLoader.getSystemResource("icon/hello.png"));
        Image i22 = i111.getImage().getScaledInstance(350,210, Image.SCALE_DEFAULT);
        ImageIcon imageIcon111 = new ImageIcon(i22);
        JLabel label11 = new JLabel(imageIcon111);
        label11.setBounds(750,20,350,800);
        panel.add(label11);


        ImageIcon i11= new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i11.getImage().getScaledInstance(280,200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon11 = new ImageIcon(i2);
        JLabel label1 = new JLabel(imageIcon11);
        label1.setBounds(5,500,300,200);
        panel1.add(label1);

          JButton btnNCF = new JButton ("New Customer Form");
          btnNCF.setBounds(30,30,200,30);
          btnNCF.setBackground(Color.WHITE);
          btnNCF.setForeground(Color.BLACK);
         panel1.add(btnNCF);
         btnNCF .addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                   new   NewCustomer();

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });
         JButton btnRoom = new JButton("Room");
        btnRoom.setBounds(30,70,200,30);
        btnRoom.setBackground(Color.WHITE);
        btnRoom.setForeground(Color.BLACK);
        panel1.add(btnRoom);
        btnRoom.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          try{
                                              new Room();

                                          }catch(Exception E){
                                              E.printStackTrace();
                                          }
                                      }
                                  });

        JButton btnDEPT= new JButton("Department");
        btnDEPT.setBounds(30,110,200,30);
        btnDEPT.setBackground(Color.WHITE);
        btnDEPT.setForeground(Color.BLACK);
        panel1.add(btnDEPT);
        btnDEPT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                     new Department();

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnAemp= new JButton("All Employee Information ");
        btnAemp.setBounds(30,150,200,30);
        btnAemp.setBackground(Color.WHITE);
        btnAemp.setForeground(Color.BLACK);
        panel1.add(btnAemp);
        btnAemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                  new Employee();
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });
        JButton btnCI= new JButton("Customer Information ");
        btnCI.setBounds(30,190,200,30);
        btnCI.setBackground(Color.WHITE);
        btnCI.setForeground(Color.BLACK);
        panel1.add(btnCI);
        btnCI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                   new CustomerInfo();
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });
        JButton btnMI= new JButton("Manager Information ");
        btnMI.setBounds(30,230,200,30);
        btnMI.setBackground(Color.WHITE);
        btnMI.setForeground(Color.BLACK);
        panel1.add(btnMI);
        btnMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new ManagerInfo();

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });
        JButton btnCO= new JButton("Check Out ");
        btnCO.setBounds(30,270,200,30);
        btnCO.setBackground(Color.WHITE);
        btnCO.setForeground(Color.BLACK);
        panel1.add(btnCO);
        btnCO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
             new CheckOut();
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });
        JButton btnCB= new JButton("Update Check-In Details");
        btnCB.setBounds(30,310,200,30);
        btnCB.setBackground(Color.WHITE);
        btnCB.setForeground(Color.BLACK);
        panel1.add(btnCB);
        btnCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                  new  UpdateCheck();

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });
        JButton btnURS= new JButton("Update Room Status");
        btnURS.setBounds(30,350,200,30);
        btnURS.setBackground(Color.WHITE);
        btnURS.setForeground(Color.BLACK);
        panel1.add(btnURS);
        btnURS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
              new  UpdateRoom();
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });
        JButton btnPS= new JButton("PickUP Service");
        btnPS.setBounds(30,390,200,30);
        btnPS.setBackground(Color.WHITE);
        btnPS.setForeground(Color.BLACK);
        panel1.add(btnPS);
        btnPS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new PickUp();

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnSR= new JButton(" Search Room");
        btnSR.setBounds(30,430,200,30);
        btnSR.setBackground(Color.WHITE);
        btnSR.setForeground(Color.BLACK);
        panel1.add(btnSR);
        btnSR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
      new SearchRoom();
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });





                getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
    }

    public static void main(String[] args) {
        new reception();
    }
}
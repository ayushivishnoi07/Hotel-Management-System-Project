package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addDriver extends JFrame implements ActionListener {
    JTextField nameText, ageText, carCText, carNText, locText;

    JComboBox comboBox, comboBox1;

    JButton add, back;
    addDriver(){

        JPanel  panel = new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setBackground(new Color(21, 64, 65));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Add Driver");
        label.setBounds(194,10,200,22);
        label.setForeground((Color.WHITE));
        label.setFont(new Font("Tahoma",Font.BOLD, 22));
        panel.add(label);



        JLabel name = new JLabel("Name");
        name.setBounds(64,70,102,22);
        name.setFont( new Font("Tahoma",Font.BOLD, 14));
        name.setForeground(Color.WHITE);
        panel.add(name);
        nameText = new JTextField();
        nameText.setBounds(174,70,156,20);
        nameText.setForeground(Color.BLACK);
        nameText.setFont(new Font("Tahoma",Font.BOLD,14));
        nameText.setBackground(new Color(242, 245, 245));
        panel.add(nameText);

        JLabel age = new JLabel("Age");
        age.setBounds(64,110,102,22);
        age.setFont( new Font("Tahoma",Font.BOLD, 14));
        age.setForeground(Color.WHITE);
        panel.add(age);
        ageText = new JTextField();
        ageText.setBounds(174,110,156,20);
        ageText.setForeground(Color.BLACK);
        ageText.setFont(new Font("Tahoma",Font.BOLD,14));
        ageText.setBackground(new Color(242, 245, 245));
        panel.add(ageText);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(64,150,102,22);
        gender.setFont( new Font("Tahoma",Font.BOLD, 14));
        gender.setForeground(Color.WHITE);
        panel.add(gender);
        comboBox = new JComboBox(new String[]{"Male","Female"});
        comboBox.setBounds(176,150,154,20);
        comboBox.setForeground(Color.BLACK);
        comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        comboBox.setBackground(new Color(242, 245, 245));
        panel.add(comboBox);

        JLabel carC = new JLabel("Car Company");
        carC.setBounds(64,190,102,22);
        carC.setFont( new Font("Tahoma",Font.BOLD, 14));
        carC.setForeground(Color.WHITE);
        panel.add(carC);
        carCText = new JTextField();
        carCText.setBounds(174,190,156,20);
        carCText.setForeground(Color.BLACK);
        carCText.setFont(new Font("Tahoma",Font.BOLD,14));
        carCText.setBackground(new Color(242, 245, 245));
        panel.add(  carCText);






        JLabel available= new JLabel("Available");
        available.setBounds(64,230,102,22);
        available.setFont( new Font("Tahoma",Font.BOLD, 14));
        available.setForeground(Color.WHITE);
        panel.add(available);
        comboBox1 = new JComboBox(new String[]{"Yes","No"});
        comboBox1.setBounds(176,230,154,20);
        comboBox1.setForeground(Color.BLACK);
        comboBox1.setFont(new Font("Tahoma",Font.BOLD,14));
        comboBox1.setBackground(new Color(242, 245, 245));
        panel.add(comboBox1);

        JLabel loc= new JLabel("Location");
        loc.setBounds(64,270,102,22);
        loc.setFont( new Font("Tahoma",Font.BOLD, 14));
        loc.setForeground(Color.WHITE);
        panel.add(loc);
        locText = new JTextField();
        locText.setBounds(174,270,156,20);
        locText.setForeground(Color.BLACK);
        locText.setFont(new Font("Tahoma",Font.BOLD,14));
        locText.setBackground(new Color(242, 245, 245));
        panel.add(  locText);

        add = new JButton("Add");
        add.setBounds(60,310,111,33);
        add.setBackground(Color.WHITE);
        add.setForeground(Color.BLACK);
        add.addActionListener(this);
        panel.add(add);


        back = new JButton("Back");
        back.setBounds(198,310,111,33);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        panel.add(back);

        setSize(900,500);
        setVisible(true);
        setLocation(20,200);
        setLayout(null);
setUndecorated(true);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String name = nameText.getText();
            String age = ageText.getText();
            String gender = (String) comboBox.getSelectedItem();
            String company = carCText.getText();
            String available = (String) comboBox1.getSelectedItem();
            String location = locText.getText();





            try {
                con c = new con();
                String q = "insert into driver values('"+name+"', '"+age+"', '"+ gender+"', '"+company+"','"+available+"', '"+location+"')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Driver Added");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();

            }

        } else {
            setVisible(false);
        }
    }

        public static void main (String[] args)
        {
            new addDriver();
        }

    }
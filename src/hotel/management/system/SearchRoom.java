package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom  extends JFrame implements ActionListener {



    JCheckBox checkBox;
    Choice choice;
    JTable table;

    JButton add, back;
    SearchRoom(){





        JPanel panel = new JPanel();
        panel.setBackground(new Color(21, 64, 65));
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        add(panel);


        JLabel searchForRoom = new JLabel(("Search For Room"));
        searchForRoom.setForeground(Color.WHITE);
        searchForRoom.setFont(new Font("Tahoma",Font.BOLD,20));
        searchForRoom.setBounds(250,11,186,31);
        panel.add(searchForRoom);


        JLabel rbt = new JLabel(("Room Bed Type"));
        rbt.setForeground(Color.WHITE);
        rbt.setFont(new Font("Tahoma",Font.BOLD,14));
        rbt.setBounds(50,73,120,14);
        panel.add(rbt);


        JLabel rn = new JLabel(("Room Number"));
        rn.setForeground(Color.WHITE);
        rn.setFont(new Font("Tahoma",Font.BOLD,14));
        rn.setBounds(23,162,150,20);
        panel.add(rn);



        JLabel available = new JLabel(("Available"));
        available.setForeground(Color.WHITE);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        available.setBounds(175,162,150,20);
        panel.add(available);


        JLabel ss = new JLabel(("Cleaning Status"));
        ss.setForeground(Color.WHITE);
        ss.setFont(new Font("Tahoma",Font.BOLD,14));
        ss.setBounds(306,162,150,20);
        panel.add(ss);



        JLabel price = new JLabel(("Price"));
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        price.setBounds(458,162,150,20);
        panel.add(price);


        JLabel bt = new JLabel(("Bed Type"));
        bt.setForeground(Color.WHITE);
        bt.setFont(new Font("Tahoma",Font.BOLD,14));
        bt.setBounds(580,162,150,20);
        panel.add(bt);











        checkBox = new JCheckBox("Only Display Available");
        checkBox.setBounds(400,69,209,23);
        checkBox.setBackground( new Color(25,68,95));
        checkBox.setForeground(Color.WHITE);
           panel.add(checkBox);

 choice = new Choice();
 choice.add("Single Bed");
 choice.add("Double  Bed");
 choice.setBounds(170,70,120,20);
 panel.add(choice);

table = new JTable();
table.setBounds(0,187,700,150);
table.setBackground(new Color(21, 64, 65));
table.setForeground(Color.WHITE);
panel.add(table);

try
{
    con c = new con();
    String q = "select * from room";
    ResultSet resultSet = c.statement.executeQuery(q);
    table.setModel(DbUtils.resultSetToTableModel(resultSet));

}catch(Exception e){
    e.printStackTrace();

}


 add = new JButton("Search");
add.setBackground(Color.WHITE);
add.setBounds(100,400,120,30);
add.setForeground(Color.BLACK);
add.addActionListener(this);
panel.add(add);



        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setBounds(380,400,120,30);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        panel.add(back);


        setSize(700,500);
        setVisible(true);
        setLayout(null);
        setLocation(500,200);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
  if(e.getSource()==add){
      String Q = " select * from Room where bed_type =  '"+choice.getSelectedItem()+"'";
      String Q1 = " select * from Room where availability = 'Available' And  bed_type = '"+choice.getSelectedItem()+"'";
try{
    con c= new con();
    ResultSet resultSet = c.statement.executeQuery(Q);
    table.setModel(DbUtils.resultSetToTableModel(resultSet));
      if(checkBox.isSelected()){
          ResultSet resultSet1 = c.statement.executeQuery(Q1);
          table.setModel(DbUtils.resultSetToTableModel(resultSet1));

      }


}


    catch(Exception E){
    E.printStackTrace();
      }

  }

  else {
      setVisible(false);
  }
    }




    public static void main(String[] args) {
        new SearchRoom();
    }
}

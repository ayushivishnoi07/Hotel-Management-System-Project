package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Dashboard  extends JFrame implements ActionListener {
    JButton add,rec;
    Dashboard(){
        super("HOTEL MANAGEMENT SYSTEM");

        getContentPane().setBackground(new Color(21, 64, 65));


rec = new JButton("Admin");
rec.setBounds(425,510,140,30);
rec.setFont(new Font("Tahoma", Font.BOLD,15));
rec.setBackground(new Color(242, 245, 245));
rec.setForeground(Color.BLACK);
rec.addActionListener(this);
add(rec);
        rec = new JButton("Reception");
        rec.setBounds(880,510,140,30);
        rec.setFont(new Font("Tahoma", Font.BOLD,15));
        rec.setBackground( new Color(242, 245, 245));
        rec.setForeground(Color.BLACK);
        rec.addActionListener(this);
        add(rec);

        ImageIcon i11= new ImageIcon(ClassLoader.getSystemResource("icon/reception.png"));
        Image i2  = i11.getImage().getScaledInstance(150,160, Image.SCALE_DEFAULT);
        ImageIcon imageIcon11 = new ImageIcon(i2);
        JLabel label1 = new JLabel(imageIcon11);
        label1.setBounds(850,300,200,195);
        add(label1);

        ImageIcon i111= new ImageIcon(ClassLoader.getSystemResource("icon/admin.png"));
        Image i22 = i111.getImage().getScaledInstance(150,160, Image.SCALE_DEFAULT);
        ImageIcon imageIcon111 = new ImageIcon(i22);
        JLabel label11 = new JLabel(imageIcon111);
        label11.setBounds(400,300,200,195);
        add(label11);









        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==rec){
        new reception();
        }else{
                  new login2();
                  setVisible(false);
        }
    }

    public static void main(String[] args) {
 new Dashboard();
    }
}

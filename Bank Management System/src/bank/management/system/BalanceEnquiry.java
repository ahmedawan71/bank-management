package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    String pinnumber;
    JButton back;
    
    BalanceEnquiry(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750, 750);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(290, 432, 130, 25);
        back.addActionListener(this);
        image.add(back);

        Connect conn = new Connect();
        int balance = 0;        
        try{    
            String query1 = "select * from bank where pin = '"+pinnumber+"'";
            ResultSet rs = conn.s.executeQuery(query1);
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch(Exception e){
            System.out.println(e);
        }
        
        JLabel text = new JLabel("Your Current Balance is Rs "+ balance);
        text.setBounds(150, 260, 400, 25);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        setSize(750, 750);
        setLocation(350, 0);
        setUndecorated(true);
        
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
    
    public static void main(String args[]){
        new BalanceEnquiry("").setVisible(true);
    }
}

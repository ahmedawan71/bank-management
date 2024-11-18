package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JButton deposit, back;
    String pinnumber;
    JTextField amount;
    
    Deposit(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750, 750);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(150, 250, 400, 35);
        text.setForeground(Color.WHITE);    
        text.setFont(new Font("Raleway", Font.BOLD, 13));
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(150, 285, 270, 24);
        amount.setForeground(Color.BLACK);    
        amount.setFont(new Font("Raleway", Font.BOLD, 13));
        image.add(amount);
        
        deposit = new JButton("Deposit");   
        deposit.setBounds(290, 404, 130, 25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back = new JButton("Back");   
        back.setBounds(290, 432, 130, 25);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(750, 750);
        setLocation(350, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new Deposit("");
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }
            else{
                try{
                    Connect conn = new Connect();
                    String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+number+"')";                
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+ number + " Deposited Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } catch(Exception e){
                    System.out.print(e);
                }
            }
        }  
        else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    } 
}

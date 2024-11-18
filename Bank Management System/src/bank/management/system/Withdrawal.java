package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener{
    
    JButton withdraw, back;
    String pinnumber;
    JTextField amount;
    
    Withdrawal(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750, 750);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setBounds(150, 250, 400, 35);
        text.setForeground(Color.WHITE);    
        text.setFont(new Font("Raleway", Font.BOLD, 13));
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(150, 285, 270, 24);
        amount.setForeground(Color.BLACK);    
        amount.setFont(new Font("Raleway", Font.BOLD, 13));
        image.add(amount);
        
        withdraw = new JButton("Withdraw");   
        withdraw.setBounds(290, 404, 130, 25);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
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
        new Withdrawal("");
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == withdraw){
            String number = amount.getText();
            Date date = new Date();
            
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            } else {
                try {
                    int withdrawAmount = Integer.parseInt(number);
                    Connect conn = new Connect();
                    
                    // Calculate the current balance
                    String query1 = "select * from bank where pin = '"+pinnumber+"'";
                    ResultSet rs = conn.s.executeQuery(query1);
                    int balance = 0;
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    
                    if(balance < withdrawAmount){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    } else {
                        String query2 = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdraw', '"+number+"')";
                        conn.s.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null, "Rs "+ number + " Withdrawn Successfully");
                        setVisible(false);
                        new Transaction(pinnumber).setVisible(true);
                    }
                    
                } catch(Exception e){
                    System.out.print(e);
                }
            }
        } else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
}

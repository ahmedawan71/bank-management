package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit, cashW, fcash, miniS, pinC, balanceI, exit;
    String pinnumber;
    
    FastCash(String pinnumber){
    
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750, 750);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(160, 250, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(text);
         
        deposit = new JButton("Rs 100");
        deposit.setBounds(140, 347, 140, 25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        fcash = new JButton("Rs 500");
        fcash.setBounds(290, 347, 130, 25);
        fcash.addActionListener(this);
        image.add(fcash);
        
        cashW = new JButton("Rs 1000");
        cashW.setBounds(140, 376, 140, 25);
        cashW.addActionListener(this);
        image.add(cashW);
        
        miniS = new JButton("Rs 2000");
        miniS.setBounds(290, 376, 130, 25);
        miniS.addActionListener(this);
        image.add(miniS);
        
        pinC = new JButton("Rs 5000");
        pinC.setBounds(140, 404, 140, 25);
        pinC.addActionListener(this);
        image.add(pinC);
        
        balanceI = new JButton("Rs 10000");
        balanceI.setBounds(290, 404, 130, 25);
        balanceI.addActionListener(this);
        image.add(balanceI);
        
        exit = new JButton("BACK");
        exit.setBounds(290, 432, 130, 25);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(750, 750);
        setLocation(350, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
    
    if(ae.getSource() == exit){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    } else {
        String amount = ((JButton)ae.getSource()).getText().substring(3);
        Connect conn = new Connect();
        try{    
            String query1 = "select * from bank where pin = '"+pinnumber+"'";
            ResultSet rs = conn.s.executeQuery(query1);
            int balance = 0;
            
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            
            if(balance < Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return; 
            }
            
            Date date = new Date();
            String query2 = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdraw', '"+amount+"')";
            conn.s.executeUpdate(query2);
            JOptionPane.showMessageDialog(null, "Rs "+ amount + " Debited Successfully");
        
            setVisible(false);
            new Transaction(pinnumber).setVisible(true); 
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
}

    
    
    public static void main(String args[]){
        new FastCash("");
    }
    
}

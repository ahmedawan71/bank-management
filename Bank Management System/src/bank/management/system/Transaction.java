package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 

public class Transaction extends JFrame implements ActionListener{
    
    JButton deposit, cashW, fcash, miniS, pinC, balanceE, exit;
    String pinnumber;
    
    Transaction(String pinnumber){
    
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750, 750);
        add(image);
        
        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(160, 250, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(text);
         
        deposit = new JButton("Deposit");
        deposit.setBounds(140, 347, 140, 25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        fcash = new JButton("Fast Cash");
        fcash.setBounds(290, 347, 132, 25);
        fcash.addActionListener(this);
        image.add(fcash);
        
        cashW = new JButton("Cash Withdrawal");
        cashW.setBounds(140, 376, 140, 25);
        cashW.addActionListener(this);
        image.add(cashW);
        
        miniS = new JButton("Mini Statement");
        miniS.setBounds(290, 376, 132, 25);
        miniS.addActionListener(this);
        image.add(miniS);
        
        pinC = new JButton("PIN Change");
        pinC.setBounds(140, 404, 140, 25);
        pinC.addActionListener(this);
        image.add(pinC);
        
        balanceE = new JButton("Balance Enquiry");
        balanceE.setBounds(290, 404, 132, 25);
        balanceE.addActionListener(this);
        image.add(balanceE);
        
        exit = new JButton("Exit");
        exit.setBounds(290, 432, 132, 25);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(750, 750);
        setLocation(350, 0);
        //setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == exit){
            System.exit(0);
        } else if (ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if(ae.getSource() == cashW){
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        } else if(ae.getSource() == fcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if(ae.getSource() == pinC){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if(ae.getSource() == balanceE){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if (ae.getSource() == miniS){
            new MiniStatement(pinnumber).setVisible(true);
        }
        
        
    }
    
    
    public static void main(String args[]){
        new Transaction("");
    }
    
}

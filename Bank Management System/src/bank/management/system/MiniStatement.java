package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;  
        
public class MiniStatement extends JFrame{
    
    String pinnumber;
    
    MiniStatement(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setTitle("Mini Statement"); 
        setLayout(null);
        
        JLabel mini = new JLabel();
        add(mini);
        
        
        JLabel bank = new JLabel("Pakistan Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        
        try{
            
            Connect conn = new Connect();
            ResultSet rs= conn.s.executeQuery("select * from login where pinNumber = '"+this.pinnumber+"'");  
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("cardNumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12));
            }
        } catch (Exception e){
            System.out.println(e);
        }
        
        try{
            Connect conn = new Connect();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+this.pinnumber+"'");  

            StringBuilder statementHTML = new StringBuilder("<html>");

            while(rs.next()){
                statementHTML.append(rs.getString("date"))
                             .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                             .append(rs.getString("type"))
                             .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                             .append(rs.getString("amount"))
                             .append("<br><br>");
                if(rs.getString("type").equals("Deposit")){
                        bal += Integer.parseInt(rs.getString("amount"));
                    }
                else{
                        bal -= Integer.parseInt(rs.getString("amount"));
                    } 
            }

            statementHTML.append("</html>");

            mini.setText(statementHTML.toString()); 
            
            balance.setText("Your current balance is Rs " + bal);

        } catch (Exception e){
            System.out.println(e);
        }
        mini.setBounds(20, 140, 400, 200);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(400, 600);
        setLocation(20, 20);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new MiniStatement("");
    }
}
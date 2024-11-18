package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class SignupThree extends JFrame implements ActionListener{
        
    JRadioButton account1, account2, account3, account4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;
    
    SignupThree(String formno){

        this.formno = formno;
        
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        
        JLabel accDetails = new JLabel("Page 3: Account Details" );
        accDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        accDetails.setBounds(280, 30, 400, 40);
        add(accDetails);
        
        JLabel type = new JLabel("Account Type:" );
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 100, 200, 30);
        add(type);
        
        account1 = new JRadioButton("Saving Account");
        account1.setBounds(100, 140, 150, 20);
        account1.setBackground(Color.WHITE);
        account1.setFont(new Font("Raleway", Font.BOLD, 16));
        add(account1);
        
        account2 = new JRadioButton("Fixed Deposit Account");
        account2.setBounds(350, 140, 250, 20);
        account2.setBackground(Color.WHITE);
        account2.setFont(new Font("Raleway", Font.BOLD, 16));
        add(account2);
        
        account3 = new JRadioButton("Current Account");
        account3.setBounds(100, 180, 250, 20);
        account3.setBackground(Color.WHITE);
        account3.setFont(new Font("Raleway", Font.BOLD, 16));
        add(account3);
        
        account4 = new JRadioButton("Reccuring Deposit Account");
        account4.setBounds(350, 180, 250, 20);
        account4.setBackground(Color.WHITE);
        account4.setFont(new Font("Raleway", Font.BOLD, 16));
        add(account4);
        
        ButtonGroup accgroup = new ButtonGroup();
        accgroup.add(account1);
        accgroup.add(account2);
        accgroup.add(account3);
        accgroup.add(account4);
        
        JLabel card = new JLabel("Card Number:" );
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 240, 200, 30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-0786");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 240, 300, 30);
        add(number);
        
        JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetail.setBounds(100, 270, 300, 15);
        add(cardDetail);
        
        JLabel pin = new JLabel("PIN Number:" );
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 310, 200, 30);
        add(pin);
        
        JLabel pineg = new JLabel("XXXX");
        pineg.setFont(new Font("Raleway", Font.BOLD, 22));
        pineg.setBounds(330, 310, 300, 30);
        add(pineg);
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 370, 300, 30);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 420, 200, 30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 420, 200, 30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 460, 200, 30);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alert");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 460, 200, 30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 500, 200, 30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 500, 200, 30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 560, 600, 30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBounds(250, 640, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(420, 640, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
        
        }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == submit){
            
            String accountType = "";
            if(account1.isSelected()){
                accountType = "Saving Account";
            }
            else if(account2.isSelected()){
                accountType = "Fixed Deposit Account";
            }
            else if(account3.isSelected()){
                accountType = "Current Type";
            }
            else if(account4.isSelected()){
                accountType = "Reccuring Deposit Account";
            }
            
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            if(c1.isSelected()){
                facility = facility + " ATM Card";
            }
            else if(c2.isSelected()){
                facility = facility + " Internet Banking";
            }
            else if(c3.isSelected()){
                facility = facility + " Mobile Banking";
            }
            else if(c4.isSelected()){
                facility = facility + " Email & SMS Alert";
            }
            else if(c5.isSelected()){
                facility = facility + " Cheque Book";
            }
            else if(c6.isSelected()){
                facility = facility + " E-Statement";
            }
                
            try {
                if (accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is required.");
                }
                else if (facility.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please select at least one facility.");
                }
                else if (cardnumber.equals("")) {
                    JOptionPane.showMessageDialog(null, "Card number generation failed.");
                }
                else if (pinNumber.equals("")) {
                    JOptionPane.showMessageDialog(null, "Pin number generation failed.");
                }
                else {
                    Connect conn = new Connect();
                    String query1 = "Insert into signupthree values ('" + formno + "', '" + accountType + "', '" + cardnumber + "', '" + pinNumber + "', '" + facility + "')";
                    String query2 = "Insert into login values ('" + formno + "', '" + cardnumber + "', '" + pinNumber + "')";

                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\nPin: " + pinNumber);
                    
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                }
                
            } catch (Exception e) {
                System.out.print(e);
            }
        }
        else if (ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        
        new SignupThree("");
    
    }
    
}

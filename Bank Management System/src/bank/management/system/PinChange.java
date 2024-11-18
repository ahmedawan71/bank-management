package bank.management.system;

import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{

    String pinnumber;
    JPasswordField pinText, newpinText;
    JButton back, change;
    
    PinChange(String pinnumber){
    
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750, 750);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(200, 240, 150, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN:");
        pintext.setBounds(130, 280, 150, 25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 15));
        image.add(pintext);        
        
        pinText = new JPasswordField();
        pinText.setBounds(270, 280, 150, 25);
        pinText.setFont(new Font("Raleway", Font.BOLD, 22));
        image.add(pinText);

        JLabel newpintext = new JLabel("Enter PIN Again:");
        newpintext.setBounds(130, 320, 150, 25);
        newpintext.setForeground(Color.WHITE);
        newpintext.setFont(new Font("System", Font.BOLD, 15));
        image.add(newpintext);

        newpinText = new JPasswordField();
        newpinText.setBounds(270, 320, 150, 25);
        newpinText.setFont(new Font("Raleway", Font.BOLD, 22));
        image.add(newpinText);

        change = new JButton("Change");
        change.setBounds(290, 404, 130, 25);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(290, 432, 130, 25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(750, 750);
        setLocation(350, 0);
        setUndecorated(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try{
                String npin = pinText.getText();
                String rpin = newpinText.getText();
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter new PIN");
                    return;
                }
                
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-Enter new PIN");
                    return;
                }
                
                Connect conn = new Connect ();
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query2 = "update login set pinNumber = '"+rpin+"' where pinNumber = '"+pinnumber+"'";
                String query3 = "update signupthree set pinNumber = '"+rpin+"' where pinNumber = '"+pinnumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
            }
            catch(Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}

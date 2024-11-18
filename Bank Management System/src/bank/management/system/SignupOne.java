package bank.management.system;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{
    
    JTextField emailText, stateText, cityText, addressText;
    JTextField nameText, pinText, fnameText;
    JButton next;
    JRadioButton male, female, other, yes, no;
    long random;
    JDateChooser calendar;
            
    SignupOne(){ 
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
         
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel personD = new JLabel("Page 1: Personal Details" );
        personD.setFont(new Font("Raleway", Font.BOLD, 22));
        personD.setBounds(290, 80, 400, 30);
        add(personD);
        
        JLabel name = new JLabel("Name:" );
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        nameText = new JTextField();
        nameText.setBounds(300, 140, 400, 30);
        nameText.setFont(new Font("Helvetica", Font.BOLD, 16));
        add(nameText);
        
        JLabel fname = new JLabel("Father's Name:" );
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        fnameText = new JTextField();
        fnameText.setBounds(300, 190, 400, 30);
        fnameText.setFont(new Font("Helvetica", Font.BOLD, 16));
        add(fnameText);
        
        JLabel dob = new JLabel("Date of Birth:" );
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        calendar = new JDateChooser();
        calendar.setBounds(300, 240, 400, 30);
        calendar.setFont(new Font("Helvetica", Font.BOLD, 16));
        calendar.setForeground(Color.BLACK);
        add(calendar);
        
        JLabel gender = new JLabel("Gender:" );
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 100, 30);
        male.setBackground(Color.WHITE);
        male.setFont(new Font("Helvetica", Font.BOLD, 16));
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 150, 30);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("Helvetica", Font.BOLD, 16));
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("Email Address:" );
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        emailText = new JTextField();
        emailText.setBounds(300, 340, 400, 30);
        emailText.setFont(new Font("Helvetica", Font.BOLD, 16));
        add(emailText);
        
        JLabel marry = new JLabel("Marital Status:" );
        marry.setFont(new Font("Raleway", Font.BOLD, 20));
        marry.setBounds(100, 390, 200, 30);
        add(marry);
        
        yes = new JRadioButton("Married");
        yes.setBounds(300, 390, 100, 30);
        yes.setBackground(Color.WHITE);
        yes.setFont(new Font("Raleway", Font.BOLD, 16));
        add(yes);
        
        no = new JRadioButton("Unmarried");
        no.setBounds(450, 390, 150, 30);
        no.setBackground(Color.WHITE);
        no.setFont(new Font("Raleway", Font.BOLD, 16));
        add(no);
        
        other = new JRadioButton("Other");
        other.setBounds(600, 390, 100, 30);
        other.setBackground(Color.WHITE);
        other.setFont(new Font("Raleway", Font.BOLD, 16));
        add(other);
        
        
        ButtonGroup marrygroup = new ButtonGroup();
        marrygroup.add(yes);
        marrygroup.add(no);
        marrygroup.add(other);
        
        JLabel state = new JLabel("State:" );
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 440, 200, 30);
        add(state);
        
        stateText = new JTextField();
        stateText.setBounds(300, 440, 400, 30);
        stateText.setFont(new Font("Helvetica", Font.BOLD, 16));
        add(stateText);
        
        JLabel city = new JLabel("City:" );
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        cityText = new JTextField();
        cityText.setBounds(300, 490, 400, 30);
        cityText.setFont(new Font("Helvetica", Font.BOLD, 16));
        add(cityText);
        
        JLabel address = new JLabel("Address:" );
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 540, 200, 30);
        add(address);
        
        addressText = new JTextField();
        addressText.setBounds(300, 540, 400, 30);
        addressText.setFont(new Font("Helvetica", Font.BOLD, 16));
        add(addressText);
        
        JLabel pin = new JLabel("PIN Code:" );
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 590, 200, 30);
        add(pin);
        
        pinText = new JTextField();
        pinText.setBounds(300, 590, 400, 30);
        pinText.setFont(new Font("Helvetica", Font.BOLD, 16));
        add(pinText);
        
        next = new JButton("Next");
        next.setBounds(600, 650, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String formno = "" + random;
        String name = nameText.getText();
        String fname = fnameText.getText();
        String dob = ((JTextField)calendar.getDateEditor().getUiComponent()).getText();
        
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }
        
        String email = emailText.getText();
        
        String marry = null;
        if(yes.isSelected()){
            marry = "Married";
        }
        else if(no.isSelected()){
            marry = "Unmarried";
        }
        else if(other.isSelected()){
            marry = "Other";
        }
        
        String state = stateText.getText();
        String city = cityText.getText();
        String address = addressText.getText();
        String pin = pinText.getText();
        
        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } 
            else if (fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Father's Name is Required");
            } 
            else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "Date of Birth is Required");
            } 
            else if (gender == null) {
                JOptionPane.showMessageDialog(null, "Gender is Required");
            } 
            else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Email Address is Required");
            } 
            else if (address.equals("")) {
                JOptionPane.showMessageDialog(null, "Address is Required");
            } 
            else if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "City is Required");
            } 
            else if (state.equals("")) {
                JOptionPane.showMessageDialog(null, "State is Required");
            } 
            else if (pin.equals("")) {
                JOptionPane.showMessageDialog(null, "Pincode is Required");
            } 
            else {
                Connect c = new Connect();
		String query = "INSERT INTO signup (formno, name, father_name, dob, gender, email, marital_status, state, city, address, pin) " +
               "VALUES ('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + email + "','"+ marry+
               "', '" + state + "', '" + city + "', '" + address + "', '" + pin + "')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new SignupTwo(formno).setVisible(true);
            }
            } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new SignupOne();
    }
}
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField panText, cnicText;
    JButton next;
    JRadioButton sno, syes, eyes, eno;
    JComboBox religion, category, income, EQ, occupation;
    String formno;
            
    SignupTwo(String formno){ 
        
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel addDetails = new JLabel("Page 2: Additional Details" );
        addDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        addDetails.setBounds(290, 80, 400, 30);
        add(addDetails);
        
        JLabel name = new JLabel("Religion:" );
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        String[] valR = {"Muslim", "Hindu", "Christian", "Buddhist", "Other"};
        religion = new JComboBox(valR);   
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);        
        
        JLabel fname = new JLabel("Category:" );
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        String[] valC = {"General", "Backward Classes", "Scheduled Class", "Scheduled Tribes", "Other"};
        category = new JComboBox(valC);   
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel dob = new JLabel("Income:" );
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        String[] valI = {"Null", "< 150,000", "< 250,000", "< 500,000", "< 1,000,000"};
        income = new JComboBox(valI);   
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel gender = new JLabel("Educational" );
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        JLabel email = new JLabel("Qualification:" );
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 315, 200, 30);
        add(email);
        
        String[] valEQ = {"Non-Graduation", "Graduate", "Post-Graduation", "Doctrate", "Others"};
        EQ = new JComboBox(valEQ);   
        EQ.setBounds(300, 303, 400, 30);
        EQ.setBackground(Color.WHITE);
        add(EQ);
        
        JLabel marry = new JLabel("Occupation:" );
        marry.setFont(new Font("Raleway", Font.BOLD, 20));
        marry.setBounds(100, 390, 200, 30);
        add(marry);
        
        String[] valO = {"Salaried", "Self-Employed", "Business", "Retired", "Student", "Others"};
        occupation = new JComboBox(valO);   
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel state = new JLabel("PAN:" );
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 440, 200, 30);
        add(state);
        
        panText = new JTextField();
        panText.setBounds(300, 440, 400, 30);
        panText.setFont(new Font("Helvetica", Font.BOLD, 16));
        add(panText);
        
        JLabel city = new JLabel("CNIC:" );
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        cnicText = new JTextField();
        cnicText.setBounds(300, 490, 400, 30);
        cnicText.setFont(new Font("Helvetica", Font.BOLD, 16));
        add(cnicText);
        
        JLabel address = new JLabel("Senior Citizen:" );
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 540, 200, 30);
        add(address);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        syes.setFont(new Font("Raleway", Font.BOLD, 16));
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 150, 30);
        sno.setBackground(Color.WHITE);
        sno.setFont(new Font("Raleway", Font.BOLD, 16));
        add(sno);
        
        ButtonGroup marrygroup = new ButtonGroup();
        marrygroup.add(syes);
        marrygroup.add(sno);
        
        JLabel pin = new JLabel("Existing Account:" );
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 590, 200, 30);
        add(pin);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        eyes.setFont(new Font("Raleway", Font.BOLD, 16));
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 150, 30);
        eno.setBackground(Color.WHITE);
        eno.setFont(new Font("Raleway", Font.BOLD, 16));
        add(eno);
        
        ButtonGroup egroup = new ButtonGroup();
        egroup.add(eyes);
        egroup.add(eno);
        
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
        
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String sEQ = (String)EQ.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "Yes";
        }
        else if(sno.isSelected()){
            seniorcitizen = "No";
        }
        
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        }
        else if(eno.isSelected()){
            existingaccount = "No";
        }
        
        String span = panText.getText();
        String scnic = cnicText.getText();
        
        try{
               Connect c = new Connect();
               String query = "Insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+sEQ+"', '"+soccupation+"', '"+span+"', '"+scnic+"', '"+seniorcitizen+"', '"+existingaccount+"')";
               c.s.executeUpdate(query);
               
               setVisible(false);
               new SignupThree(formno).setVisible(true);
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new SignupTwo("");
    }
}
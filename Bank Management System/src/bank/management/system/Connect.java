package bank.management.system;

import java.sql.*;

public class Connect {
    
    Connection c;
    Statement s;
    
    public Connect(){
        try{         
        
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Oppoa.71plus");
            s = c.createStatement();
                
        } catch(Exception e){
            System.out.println(e); 
        }
        
    }
    
}
package employee.administration.platform;

import java.sql.*;

public class Conn{
    
    Connection c;
    Statement s;
    
    public Conn(){
      try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        c = DriverManager.getConnection("jdbc:mysql:///employeeadministrationplatform", "root", "S@rvesh$oni#15");
        s = c.createStatement();
        } catch(Exception e){
          e.printStackTrace();
      }
    } 
}

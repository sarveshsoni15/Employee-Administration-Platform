package employee.administration.platform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    JTextField tfeducation,tfFname,tfsalary,tfaddress,tfphone,tfaadhar,tfemail,tfdesignation;
    JLabel lblempId;
    JButton add,back;
    String empId;
    
    UpdateEmployee(String empId){
        this.empId = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
        add(heading); 
        
        JLabel labelName = new JLabel("Name :");
        labelName.setBounds(50, 150, 150, 30);
        labelName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelName);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);
        
        JLabel labelFname = new JLabel("Father's Name :");
        labelFname.setBounds(400, 150, 150, 30);
        labelFname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelFname);
        
        tfFname = new JTextField();
        tfFname.setBounds(600, 150, 150, 30);
        add(tfFname);
        
        JLabel labeldob = new JLabel("Date of Birth :");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        JLabel lbldob =  new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);
        
        JLabel labelSalary = new JLabel("Salary :");
        labelSalary.setBounds(400, 200, 150, 30);
        labelSalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelSalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);
        
        JLabel labelAddress = new JLabel("Address :");
        labelAddress.setBounds(50, 250, 150, 30);
        labelAddress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelAddress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        JLabel labelPhone = new JLabel("Phone :");
        labelPhone.setBounds(400, 250, 150, 30);
        labelPhone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelPhone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        JLabel labelEmail = new JLabel("Email :");
        labelEmail.setBounds(50, 300, 150, 30);
        labelEmail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEmail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        JLabel labelEducation = new JLabel("Highest Education");
        labelEducation.setBounds(400, 300, 150, 30);
        labelEducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEducation);
        
        tfeducation = new JTextField();
        tfeducation.setBounds(600, 300, 150, 30);
        add(tfeducation);
        
        JLabel labelDesignation = new JLabel("Designation :");
        labelDesignation.setBounds(50, 350, 150, 30);
        labelDesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelDesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        add(tfdesignation);
        
        JLabel labelAadhar = new JLabel("Aadhar Number :");
        labelAadhar.setBounds(400, 350, 150, 30);
        labelAadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelAadhar);
        
        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(600, 350, 150, 30);
        add(lblaadhar);
        
        JLabel labelempid = new JLabel("Employee Id :");
        labelempid.setBounds(50, 400, 150, 30);
        labelempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempid);
                
        lblempId = new JLabel();
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
               lblname.setText(rs.getString("name"));
               tfFname.setText(rs.getString("fname"));
               lbldob.setText(rs.getString("dob"));
               tfaddress.setText(rs.getString("address"));
               tfsalary.setText(rs.getString("salary"));
               tfphone.setText(rs.getString("phone"));
               tfemail.setText(rs.getString("email"));
               tfeducation.setText(rs.getString("education"));
               lblaadhar.setText(rs.getString("aadhar"));
               lblempId.setText(rs.getString("empId"));
               tfdesignation.setText(rs.getString("designation"));
            }
        } catch(Exception e) {
             e.printStackTrace();
        }
        
       add = new JButton("Update Details");
       add.setBounds(250, 550, 150, 40);
       add.addActionListener(this);
       add.setBackground(Color.BLACK);
       add.setForeground(Color.WHITE);
       add(add);
       
       back = new JButton("Back");
       back.setBounds(450, 550, 150, 40);
       back.addActionListener(this);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       add(back);
       
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String fname = tfFname.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();
            
            try{
               Conn conn = new Conn();
               String query = "update employee set fname = '"+fname+"',salary = '"+salary+"',address = '"+address+"',phone = '"+phone+"',email = '"+email+"', education = '"+education+"',designation = '"+designation+"' where empId = '"+empId+"'";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Details updated successfully");
               setVisible(false);
               new Home();
            } catch(Exception e){
            
            }
      } else {
          setVisible(false);
          new Home();
      }
    }
        
    
    public static void main(String args[]){
       new UpdateEmployee("");
    } 
}


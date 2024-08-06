package employee.administration.platform;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname,tfFname,tfsalary,tfaddress,tfphone,tfaadhar,tfemail,tfdesignation;
    JDateChooser dcdob;
    JComboBox cbEducation;
    JLabel lblempId;
    JButton add,back;
    
    AddEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
        add(heading); 
        
        JLabel labelName = new JLabel("Name :");
        labelName.setBounds(50, 150, 150, 30);
        labelName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelName);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
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
        
        dcdob =  new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);
        
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
        
        String courses[] = {"B.TECH", "BCA", "BA", "BSC", "B.COM", "BBA", "MBA", "MCA", "MA", "M.TECH", "MSC", "PHD"};
        cbEducation = new JComboBox(courses);
        cbEducation.setBackground(Color.WHITE);
        cbEducation.setBounds(600, 300, 150, 30);
        add(cbEducation);
        
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
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        add(tfaadhar);
        
        JLabel labelempid = new JLabel("Employee Id :");
        labelempid.setBounds(50, 400, 150, 30);
        labelempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempid);
                
        lblempId = new JLabel("" + number);
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
       add = new JButton("Add Details");
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
            String name = tfname.getText();
            String fname = tfFname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbEducation.getSelectedItem();
            String designation = tfdesignation.getText();
            String aadhar = tfaadhar.getText();
            String empId = lblempId.getText();
            
            try{
               Conn conn = new Conn();
               String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empId+"')";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Details added successfully");
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
       new AddEmployee();
    } 
}



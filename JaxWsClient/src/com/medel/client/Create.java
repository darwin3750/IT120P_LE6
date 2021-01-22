package com.medel.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.xml.ws.Service;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.medel.employee.fx.Employee;
import com.medel.employee.fx.EmployeeFx;

public class Create extends JFrame {
	public Create(Client mainMenu, Service service) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 260, 306);
    
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
    panel.setLayout(null);
    
    JLabel status = new JLabel("");
		status.setBounds(10, 3, 224, 23);
    
    //id group
		JLabel idLabel = new JLabel("ID");
    JTextField idTextField = new JTextField();
    idLabel.setBounds(10, 24, 224, 14);
    idTextField.setBounds(10, 37, 224, 28);
    
    //empNumber group
		JLabel empNumberLabel = new JLabel("Employee Number");
    JTextField empNumberTextField = new JTextField();
    empNumberLabel.setBounds(10, 69, 224, 14);
    empNumberTextField.setBounds(10, 82, 224, 28);
    
    //empName group
		JLabel empNameLabel = new JLabel("Name");
    JTextField empNameTextField = new JTextField();
    empNameLabel.setBounds(10, 119, 224, 14);
		empNameTextField.setBounds(10, 132, 224, 28);
    
    JButton backButton = new JButton("Back");
    backButton.setBounds(10, 221, 103, 35);

    JButton submitButton = new JButton("Submit");
    submitButton.setBounds(136, 221, 98, 35);
    
    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        status.setText("");
        System.out.println("asd");
      }
    });
    backButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        mainMenu.setVisible(true);
      }
    });
    
    panel.add(backButton);
    panel.add(status);
    panel.add(idLabel);
    panel.add(idTextField);
    panel.add(empNumberLabel);
    panel.add(empNumberTextField);
    panel.add(empNameLabel);
    panel.add(empNameTextField);
    panel.add(submitButton);
    
    setContentPane(panel);

    EmployeeFx employee = service.getPort(EmployeeFx.class);
    Employee emp = new Employee();

    emp.setId(1);
    emp.setName("Paul");
    emp.setEmployeeNumber(111111);
    employee.createEmployee(emp);

    emp.setId(2);
    emp.setName("Paula");
    emp.setEmployeeNumber(222222);
    employee.createEmployee(emp);

    System.out.println(employee.getEmployeeDetails(1).getName() + " " +
    employee.getEmployeeDetails(1).getEmployeeNumber());
    System.out.println(employee.getEmployeeDetails(2).getName() + " " +
    employee.getEmployeeDetails(2).getEmployeeNumber());
	}

}

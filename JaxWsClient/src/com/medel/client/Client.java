package com.medel.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

//GUI IMPORTS
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.medel.employee.fx.Employee;
import com.medel.employee.fx.EmployeeFx;

public class Client extends JFrame {
  public static void main(String[] args) throws MalformedURLException {
    // TODO Auto-generated method stub
    URL url = new URL("http://localhost:50000/employee?wsdl");
    QName qname = new QName("http://Impl.employee.medel.com/", "EmployeeImplService");
    Service service = Service.create(url, qname);

    // GUI
    Client mainMenu = new Client();
    mainMenu.setTitle("Main Menu");
    mainMenu.setVisible(true);
    mainMenu.setDefaultCloseOperation(mainMenu.EXIT_ON_CLOSE);
    mainMenu.setBounds(100, 100, 260, 306);
    
    JPanel panel = new JPanel();
	  panel.setBorder(new EmptyBorder(5, 5, 5, 5));
    panel.setLayout(null);
    
    JButton createButton = new JButton("Create Employee");
    JButton deleteButton = new JButton("Delete Employee");
    JButton updateButton = new JButton("Update Employee");
    JButton getButton = new JButton("Get Employee Details");
    JButton getAllButton = new JButton("Get All Employees");

    createButton.setBounds(10, 11, 224, 36);
    deleteButton.setBounds(10, 58, 224, 36);
    updateButton.setBounds(10, 105, 224, 36);
    getButton.setBounds(10, 152, 224, 36);
    getAllButton.setBounds(10, 199, 224, 36);
    createButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        mainMenu.setVisible(false);
        Create c = new Create(mainMenu, service);
        c.setVisible(true);
      }
    });
    deleteButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    updateButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    getButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    getAllButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });


    panel.add(createButton);
    panel.add(deleteButton);
    panel.add(updateButton);
    panel.add(getButton);
    panel.add(getAllButton);
    mainMenu.setContentPane(panel);


    // EmployeeFx employee = service.getPort(EmployeeFx.class);

    // Employee emp = new Employee();
    // emp.setId(1);
    // emp.setName("Paul");
    // emp.setEmployeeNumber(111111);
    // employee.createEmployee(emp);

    // emp.setId(2);
    // emp.setName("Paula");
    // emp.setEmployeeNumber(222222);
    // employee.createEmployee(emp);

    // System.out.println(employee.getEmployeeDetails(1).getName() + " " +
    // employee.getEmployeeDetails(1).getEmployeeNumber());
    // System.out.println(employee.getEmployeeDetails(2).getName() + " " +
    // employee.getEmployeeDetails(2).getEmployeeNumber());

  }

}

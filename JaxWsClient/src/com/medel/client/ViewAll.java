package com.medel.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.xml.ws.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ViewAll extends JFrame {
  public ViewAll(Client mainMenu) {
    setTitle("View All");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 260, 306);

    JPanel panel = new JPanel();
    panel.setBorder(new EmptyBorder(5, 5, 5, 5));
    panel.setLayout(null);

    JTextArea textArea = new JTextArea();
    textArea.setBounds(10, 11, 197, 199);

    JScrollPane scrollBar = new JScrollPane(textArea);
    scrollBar.setBounds(10, 11, 224, 199);

    JButton backButton = new JButton("Back");
    backButton.setBounds(10, 221, 103, 35);

    JButton refreshButton = new JButton("Refresh");
    refreshButton.setBounds(136, 221, 98, 35);

    // LISTENERS
    refreshButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
    	  renderOutput(mainMenu, textArea);
      }
    });
    backButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        mainMenu.setVisible(true);
      }
    });

    // RENDER TO GUI
    renderOutput(mainMenu, textArea);

    panel.add(backButton);
    panel.add(refreshButton);
    panel.add(scrollBar);

    setContentPane(panel);

  }
  
  private void renderOutput(Client mainMenu, JTextArea textArea) {
	  EmployeeFx employee = mainMenu.getService().getPort(EmployeeFx.class);
      String output = "";
      for(Employee emp : employee.getAllEmployees()){
        output += 
            "ID: " + emp.getId() + "\n" +
            "Name: " + emp.getName() + "\n" +
            "Employee Number: " + emp.getEmployeeNumber() + "\n\n";
      }
      textArea.setText(output);
  }
}

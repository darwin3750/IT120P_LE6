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

public class Create extends JFrame {
  public Create(Client mainMenu) {
    setTitle("Create");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 260, 306);

    JPanel panel = new JPanel();
    panel.setBorder(new EmptyBorder(5, 5, 5, 5));
    panel.setLayout(null);

    JLabel status = new JLabel("");
    status.setBounds(10, 3, 224, 23);

    // id group
    JLabel idLabel = new JLabel("ID");
    JTextField idTextField = new JTextField();
    idLabel.setBounds(10, 24, 224, 14);
    idTextField.setBounds(10, 37, 224, 28);

    // empNumber group
    JLabel empNumberLabel = new JLabel("Employee Number");
    JTextField empNumberTextField = new JTextField();
    empNumberLabel.setBounds(10, 69, 224, 14);
    empNumberTextField.setBounds(10, 82, 224, 28);

    // empName group
    JLabel empNameLabel = new JLabel("Name");
    JTextField empNameTextField = new JTextField();
    empNameLabel.setBounds(10, 119, 224, 14);
    empNameTextField.setBounds(10, 132, 224, 28);

    JButton backButton = new JButton("Back");
    backButton.setBounds(10, 221, 103, 35);

    JButton submitButton = new JButton("Submit");
    submitButton.setBounds(136, 221, 98, 35);

    // LISTENERS
    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        EmployeeFx employee = mainMenu.getService().getPort(EmployeeFx.class);
        Employee emp = new Employee();

        // input validation
        if (idTextField.getText().isEmpty() || empNumberTextField.getText().isEmpty()
            || empNameTextField.getText().isEmpty()) {
          status.setText("Please fill in all fields.");
        } else {
          Pattern nonNumberPattern = Pattern.compile("[^1-9]+"); // check for non-numbers
          Matcher idMatcher = nonNumberPattern.matcher(idTextField.getText());
          Matcher empNumberMatcher = nonNumberPattern.matcher(empNumberTextField.getText());
          if (idMatcher.find() || empNumberMatcher.find()) {
            status.setText("ID and Emp. Num. must be a number.");
          } else {
            emp.setId(Integer.parseInt(idTextField.getText()));
            emp.setName(empNameTextField.getText());
            emp.setEmployeeNumber(Integer.parseInt(empNumberTextField.getText()));
            status.setText(employee.createEmployee(emp));
          }
        }

      }
    });
    backButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        mainMenu.setVisible(true);
      }
    });

    // RENDER TO GUI
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
  }

}

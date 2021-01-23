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

public class Update extends JFrame {
  public Update(Client mainMenu) {
    setTitle("Update");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 260, 306);

    JPanel panel = new JPanel();
    panel.setBorder(new EmptyBorder(5, 5, 5, 5));
    panel.setLayout(null);

    JLabel status = new JLabel("");
    status.setBounds(10, 3, 224, 23);

    // old id group
    JLabel oldIdLabel = new JLabel("Old ID");
    JTextField oldIdTextField = new JTextField();
    oldIdLabel.setBounds(10, 24, 224, 14);
    oldIdTextField.setBounds(10, 37, 224, 28);

    // new ID group
    JLabel newIdLabel = new JLabel("New ID");
    JTextField newIdTextField = new JTextField();
    newIdLabel.setBounds(10, 69, 224, 14);
    newIdTextField.setBounds(10, 82, 224, 28);

    // empNum group
    JLabel empNumberLabel = new JLabel("Employee Number");
    JTextField empNumberTextField = new JTextField();
    empNumberLabel.setBounds(10, 119, 224, 14);
    empNumberTextField.setBounds(10, 132, 224, 28);

    //emName group
    JLabel empNameLabel = new JLabel("Employee Name");
    JTextField empNameTextField = new JTextField();
    empNameLabel.setBounds(10, 169, 224, 14);
    empNameTextField.setBounds(10, 182, 224, 28);

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
        if (oldIdTextField.getText().isEmpty() || newIdTextField.getText().isEmpty()
            || empNumberTextField.getText().isEmpty() || empNameTextField.getText().isEmpty()) {
          status.setText("Please fill in all fields.");
        } else {
          Pattern nonNumberPattern = Pattern.compile("[^1-9]+"); // check for non-numbers
          Matcher oldIdMatcher = nonNumberPattern.matcher(oldIdTextField.getText());
          Matcher newIdMatcher = nonNumberPattern.matcher(newIdTextField.getText());
          Matcher empNumberMatcher = nonNumberPattern.matcher(empNumberTextField.getText());
          if (oldIdMatcher.find() || newIdMatcher.find() || empNumberMatcher.find()) {
            status.setText("ID and Emp. Num. must be a number.");
          } else {
            emp.setId(Integer.parseInt(newIdTextField.getText()));
            emp.setName(empNameTextField.getText());
            emp.setEmployeeNumber(Integer.parseInt(empNumberTextField.getText()));
            status.setText(employee.updateEmployee(Integer.parseInt(oldIdTextField.getText()), emp));
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
    panel.add(oldIdLabel);
    panel.add(oldIdTextField);
    panel.add(newIdLabel);
    panel.add(newIdTextField);
    panel.add(empNumberLabel);
    panel.add(empNumberTextField);
    panel.add(empNameLabel);
    panel.add(empNameTextField);
    panel.add(submitButton);

    setContentPane(panel);
    
  }
}

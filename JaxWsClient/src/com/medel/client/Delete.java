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

public class Delete extends JFrame {
	public Delete(Client mainMenu) {
	    setTitle("Delete");
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

	    JButton backButton = new JButton("Back");
	    backButton.setBounds(10, 221, 103, 35);

	    JButton submitButton = new JButton("Submit");
	    submitButton.setBounds(136, 221, 98, 35);

	    // LISTENERS
	    submitButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {

	        EmployeeFx employee = mainMenu.getService().getPort(EmployeeFx.class);

	        // input validation
	        if (idTextField.getText().isEmpty()) {
	          status.setText("Please fill in all fields.");
	        } else {
	          Pattern nonNumberPattern = Pattern.compile("[^1-9]+"); // check for non-numbers
	          Matcher idMatcher = nonNumberPattern.matcher(idTextField.getText());
	          if (idMatcher.find()) {
	            status.setText("ID must be a number.");
	          } else {
	            status.setText(employee.deleteEmployee(Integer.parseInt(idTextField.getText())));
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
	    panel.add(submitButton);

	    setContentPane(panel);
	  }

}

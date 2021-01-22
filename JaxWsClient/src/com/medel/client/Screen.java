package com.medel.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Screen extends JFrame {

	private JPanel panel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen frame = new Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Screen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 306);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(136, 221, 98, 35);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(10, 37, 224, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setBounds(10, 26, 46, 14);
		panel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 82, 224, 28);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("id");
		lblNewLabel_1.setBounds(10, 71, 46, 14);
		panel.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 132, 224, 28);
		panel.add(textField_2);
		
		JLabel lblNewLabel_2 = new JLabel("id");
		lblNewLabel_2.setBounds(10, 121, 224, 14);
		panel.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 182, 224, 28);
		panel.add(textField_3);
		
		JLabel lblNewLabel_3 = new JLabel("id");
		lblNewLabel_3.setBounds(10, 171, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(75, 3, 159, 23);
		panel.add(lblNewLabel_4);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10, 221, 103, 35);
		panel.add(btnBack);
	}
}

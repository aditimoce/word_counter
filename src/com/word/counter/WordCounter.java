package com.word.counter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class WordCounter {

	private JFrame frmWordCounterTool;
	private JTextField numberOfWordsTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WordCounter window = new WordCounter();
					window.frmWordCounterTool.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WordCounter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWordCounterTool = new JFrame();
		frmWordCounterTool.setTitle("Word Counter Tool");
		frmWordCounterTool.setBounds(100, 100, 450, 300);
		frmWordCounterTool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmWordCounterTool.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel enterTextLabel = new JLabel("Enter text and click Count:");
		enterTextLabel.setBounds(29, 30, 138, 29);
		panel.add(enterTextLabel);
		
		JTextArea enteredTextArea = new JTextArea();
		enteredTextArea.setLineWrap(true);
		enteredTextArea.setWrapStyleWord(true);
		enteredTextArea.setBounds(177, 32, 172, 67);
		panel.add(enteredTextArea);
		
		JButton countButton = new JButton("Count");
		countButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enteredText = enteredTextArea.getText();
				int numberOfWords = 0;
				
				for (int i = 0; i < enteredText.length(); i++) {
					if(enteredText.charAt(i) == ' ')
						numberOfWords++;
				}
				numberOfWordsTextField.setText(" " + numberOfWords);
				
			}
		});
		countButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		countButton.setBounds(39, 80, 105, 19);
		panel.add(countButton);
		
		numberOfWordsTextField = new JTextField();
		numberOfWordsTextField.setBounds(177, 132, 121, 39);
		panel.add(numberOfWordsTextField);
		numberOfWordsTextField.setColumns(10);
		
		JLabel numberOfWordsLabel = new JLabel("Number of words:");
		numberOfWordsLabel.setBounds(29, 142, 121, 19);
		panel.add(numberOfWordsLabel);
		
		
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enteredTextArea.setText("");
				numberOfWordsTextField.setText("");
			}
		});
		clearButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		clearButton.setBounds(82, 213, 89, 23);
		panel.add(clearButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		exitButton.setForeground(Color.RED);
		exitButton.setBounds(259, 213, 89, 23);
		panel.add(exitButton);
		
		
	}
}

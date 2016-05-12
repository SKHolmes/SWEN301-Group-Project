package core;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;

public class MainScreen {

	private JFrame frame;
	private XMLParser parser;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 */
	public MainScreen(String user) {
		initialize(user);
		parser = new XMLParser();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String user) {
		frame = new JFrame();
		frame.setTitle("Welcome back " + user + "!");
		frame.setBounds(100, 100, 750, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnFunction = new JButton("New Mail Event");
		toolBar.add(btnFunction);
		
		JButton btnNewButton = new JButton("New Cost Event");
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New Price Event");
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New Discontinue Event");
		toolBar.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New TimeLimit Event");
		toolBar.add(btnNewButton_3);
		
		JTextArea textArea = new JTextArea("This is a non-editable JTextArea. ");
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
			
		JScrollPane areaScrollPane = new JScrollPane(textArea);
		areaScrollPane.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(250, 100));
			
		frame.getContentPane().add(areaScrollPane, BorderLayout.SOUTH);
		
		frame.setVisible(true);
	}

}

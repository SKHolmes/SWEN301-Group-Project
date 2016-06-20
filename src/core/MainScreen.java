package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import events.CostEventWindow;
import events.DiscontinueEventWindow;
import events.MailEventWindow;
import events.PriceEventWindow;
import events.TimeLimitEventWindow;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Dimension;

public class MainScreen {

	private JFrame frame;
	private XMLParser parser;
	private Controller controller;

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
	 * @param controller 
	 */
	public MainScreen(String user, Controller controller) {
		initialize(user);
		parser = new XMLParser();
		this.controller = controller;
		controller.setXMLParser(parser);
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
		
		ButtonClickListener BtnListener = new ButtonClickListener();
		
		JButton btnFunction = new JButton("New Mail Event");
		toolBar.add(btnFunction);
		btnFunction.setActionCommand("mailEvent");
		btnFunction.addActionListener(BtnListener);
		
		JButton btnNewButton = new JButton("New Cost Event");
		toolBar.add(btnNewButton);
		btnNewButton.setActionCommand("costEvent");
		btnNewButton.addActionListener(BtnListener);
		
		JButton btnNewButton_1 = new JButton("New Price Event");
		toolBar.add(btnNewButton_1);
		btnNewButton_1.setActionCommand("priceEvent");
		btnNewButton_1.addActionListener(BtnListener);
		
		JButton btnNewButton_2 = new JButton("New Discontinue Event");
		toolBar.add(btnNewButton_2);
		btnNewButton_2.setActionCommand("discontinueEvent");
		btnNewButton_2.addActionListener(BtnListener);
		
		JButton btnNewButton_3 = new JButton("New TimeLimit Event");
		toolBar.add(btnNewButton_3);
		btnNewButton_3.setActionCommand("timeLimitEvent");
		btnNewButton_3.addActionListener(BtnListener);
		
		JButton historyButton = new JButton("History");
		toolBar.add(historyButton);
		historyButton.setActionCommand("history");
		historyButton.addActionListener(BtnListener);
		
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
	
	/**
	 * Handle the button presses
	 *
	 */
	private class ButtonClickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();  
			
			switch (command){
			
			case "history":
				new HistoryWindow();
				break;
			case "mailEvent":
				new MailEventWindow(controller);
				break;
			case "costEvent":
				new CostEventWindow(controller);
				break;
			case "priceEvent":
				new PriceEventWindow(controller);
				break;
			case "discontinueEvent":
				new DiscontinueEventWindow(controller);
				break;
			case "timeLimitEvent":
				new TimeLimitEventWindow(controller);
				break;
			default:
				System.out.println("New event? " + command);
			
			}			
		}
	}

}

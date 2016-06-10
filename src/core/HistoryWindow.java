/**
 * 
 */
package core;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author george
 *
 */
public class HistoryWindow {

	private JFrame mainFrame;
	private JPanel contentPanel;
	private JPanel controlPanel;
	private JLabel contentLabel;
	private int index;
	
	public HistoryWindow() {
		initialize();
		index = 0;
	}

	private void initialize() {
		mainFrame = new JFrame("History");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(1, 2));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controlPanel = new JPanel();
	    controlPanel.setLayout(new FlowLayout());
	      
	    contentPanel = new JPanel();
	    contentPanel.setLayout(new FlowLayout());
	    
	    //add controls to control panel
	    JButton forwardButton = new JButton("Forward");
	    JButton backButton = new JButton("Back");
	    
	    forwardButton.setActionCommand("forward");
	    backButton.setActionCommand("back");
	    
	    forwardButton.addActionListener(new ButtonClickListener());
	    backButton.addActionListener(new ButtonClickListener());
	    
	    controlPanel.add(backButton);
	    controlPanel.add(forwardButton);
	    
	    //add content to content panel
	    contentLabel = new JLabel("");
	    contentPanel.add(contentLabel);
	    
	    //add panels to main window
	    mainFrame.add(controlPanel);
	    mainFrame.add(contentPanel);
	    
	    mainFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		//HistoryWindow window = new HistoryWindow();
	}
	
	private class ButtonClickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();  
			
			if(command.equals("forward")){
				//go forward in history
				contentLabel.setText("forward\n " + index++);
			}
			else if(command.equals("back")){
				//go back in history
				contentLabel.setText("back\n " + index--);
			}
		}
	}
}

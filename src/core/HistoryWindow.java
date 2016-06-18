/**
 * 
 */
package core;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import events.CostEvent;
import events.DiscontinueEvent;
import events.Event;
import events.MailEvent;
import events.PriceEvent;
import events.TimeLimitEvent;

/**
 * @author george
 *
 */
public class HistoryWindow implements WindowFocusListener, ItemListener{

	private JFrame mainFrame;
	private JPanel contentPanel;
	private JPanel controlPanel;
	private JButton forwardButton;
	private JButton backButton;
	private int index;
	private ArrayList<Event> allEvents;
	private ArrayList<Event> subsetEvents;
	private MainScreen mainScreen;
	private boolean showCostEvents;
	private boolean showDiscontinueEvents;
	private boolean showMailEvents;
	private boolean showPriceEvents;
	private boolean showTimeLimitEvents;
	private JCheckBox costEvent;
	private JCheckBox discontinueEvent;
	private JCheckBox mailEvent;
	private JCheckBox priceEvent;
	private JCheckBox timeLimitEvent;
	private JSpinner eventChooser;
	private JButton eventNumButton;
	private int minIndex;
	private int maxIndex;
	
	public HistoryWindow(MainScreen mainScreen) {
		index = 0;
		this.allEvents = mainScreen.getEvents();
		this.subsetEvents = mainScreen.getEvents();
		this.mainScreen = mainScreen;
		this.minIndex = 1;
		this.maxIndex = subsetEvents.size();
		showCostEvents = true;
		showDiscontinueEvents = true;
		showMailEvents = true;
		showPriceEvents = true;
		showTimeLimitEvents = true;
		
		initialize();
	}

	private void initialize() {
		mainFrame = new JFrame("History");
		mainFrame.setSize(520, 400);
		mainFrame.setLayout(new GridLayout(1, 2));
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.addWindowFocusListener(this);
		
		controlPanel = new JPanel();
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
		controlPanel.setBorder(BorderFactory.createTitledBorder("Controls"));
		
	    contentPanel = new JPanel();
	    contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
	    contentPanel.setBorder(BorderFactory.createTitledBorder("Event Information"));
	    //if the passed in array of events is zero
	    if(allEvents.size() < 1){
	    	displayError("No history to view");
	    } else {
	    	addContent(allEvents.get(index));
	    }
	    
	    // create the arrow buttons
	    JPanel arrowPanel = new JPanel();
	    arrowPanel.setLayout(new FlowLayout());
	    
	    forwardButton = new JButton(">");
	    forwardButton.setActionCommand("forward");
	    forwardButton.addActionListener(new ButtonClickListener());
	    
	    backButton = new JButton("<");
	    backButton.setActionCommand("back");
	    backButton.addActionListener(new ButtonClickListener());
	    backButton.setEnabled(false);
	    
	    arrowPanel.add(backButton);
	    arrowPanel.add(forwardButton);
	    arrowPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), 
	    		"Navigation", 
	    		TitledBorder.CENTER,
	    		TitledBorder.TOP));
	    controlPanel.add(arrowPanel);
	    
	    // create the page num panel
	    JPanel pageNumPanel = new JPanel();
	    pageNumPanel.setLayout(new FlowLayout());
	    
	    JLabel goToPageLabel = new JLabel("Go to Event ");
	    
	    createNumSpinner();

        eventNumButton = new JButton("Go");
		eventNumButton.setActionCommand("goTo");
		eventNumButton.addActionListener(new ButtonClickListener());
		
		pageNumPanel.add(goToPageLabel);
        pageNumPanel.add(eventChooser);
        pageNumPanel.add(eventNumButton);
        
        controlPanel.add(pageNumPanel);
		
	    
	    // create the check boxes
	    JPanel filterPanel = new JPanel();
	    
	    costEvent = new JCheckBox("Cost Events");
	    costEvent.setSelected(true);
 
	    discontinueEvent = new JCheckBox("Discontinue Events");
	    discontinueEvent.setSelected(true);
 
	    mailEvent = new JCheckBox("Mail Events");
	    mailEvent.setSelected(true);
 
	    priceEvent = new JCheckBox("Price Events");
	    priceEvent.setSelected(true);
        
	    timeLimitEvent = new JCheckBox("Time Limit Events");
	    timeLimitEvent.setSelected(true);
 
        costEvent.addItemListener(this);
        discontinueEvent.addItemListener(this);
        mailEvent.addItemListener(this);
        priceEvent.addItemListener(this);
        timeLimitEvent.addItemListener(this);
        
        JPanel checkPanel = new JPanel(new GridLayout(0, 1));
        checkPanel.add(costEvent);
        checkPanel.add(discontinueEvent);
        checkPanel.add(mailEvent);
        checkPanel.add(priceEvent);
        checkPanel.add(timeLimitEvent);
	    
        filterPanel.add(checkPanel);
	    filterPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), 
				"Filters", 
				TitledBorder.CENTER,
				TitledBorder.TOP));
	    controlPanel.add(filterPanel);
	    
	    //add panels to main window
	    mainFrame.add(controlPanel);
	    mainFrame.add(contentPanel);
	    
	    mainFrame.setVisible(true);
	}
	
	private void createNumSpinner() {
		SpinnerNumberModel numberModel = new SpinnerNumberModel(new Integer(minIndex), 
				new Integer(minIndex), new Integer(maxIndex), new Integer(1));
        eventChooser = new JSpinner(numberModel);
	}

	private class ButtonClickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();  
			
			if(command.equals("forward")){
				//go forward in history
				index+=1;
				addContent(subsetEvents.get(index));
			}
			else if(command.equals("back")){
				//go back in history
				index-=1;
				addContent(subsetEvents.get(index));
			}
			else if(command.equals("goTo")){
				//go to event number eventChooser.getValue()
				index = (int) eventChooser.getValue();
				index -=1;
				System.out.println( (int) eventChooser.getValue());
				addContent(subsetEvents.get(index));
			}
			
			checkButtons();
		}
	}
	
	private void checkButtons() {
		if(index > 0){
			backButton.setEnabled(true);
		} else {
			backButton.setEnabled(false);
		}
		if(index >= subsetEvents.size()-1){
			forwardButton.setEnabled(false);
		} else {
			forwardButton.setEnabled(true);
		}
		if(subsetEvents.size() == 0){
			eventNumButton.setEnabled(false);
		} else {
			eventNumButton.setEnabled(true);
		}
	}
	
	private void addContent(Event event) {
		String data = event.toString();
		contentPanel.removeAll();
		String[] bits = data.split("/");
		JLabel label1 = new JLabel("Viewing event number: " +  (index+1));
		contentPanel.add(label1);
		contentPanel.add(Box.createRigidArea(new Dimension(10,10)));
		
		for(String s : bits){
			JLabel label = new JLabel(s);
		    contentPanel.add(label);
		    label.setText(s);
		    SwingUtilities.updateComponentTreeUI(mainFrame);
		}
	}

	@Override
	public void windowGainedFocus(WindowEvent arg0) {
		//re initialize the event list and redraw the window
		int temp = index;
		reinitSubset();
		index = temp;
		if(subsetEvents.size() > 0){
			addContent(subsetEvents.get(index));
		} else {
			displayError("No history to view");
		}
		
		checkButtons();
	}

	@Override
	public void windowLostFocus(WindowEvent arg0) {
		// not used
				
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		//set boolean values when changed
		Object checkBox = arg0.getItemSelectable();
		
		if(checkBox == costEvent){
			if(arg0.getStateChange() == ItemEvent.DESELECTED){
				showCostEvents = false;
				reinitSubset();
			}
			else if(arg0.getStateChange() == ItemEvent.SELECTED){
				showCostEvents = true;
				reinitSubset();
			}
		}
		else if(checkBox == discontinueEvent){
			if(arg0.getStateChange() == ItemEvent.DESELECTED){
				showDiscontinueEvents = false;
				reinitSubset();
			}
			else if(arg0.getStateChange() == ItemEvent.SELECTED){
				showDiscontinueEvents = true;
				reinitSubset();
			}
		}
		else if(checkBox == mailEvent){
			if(arg0.getStateChange() == ItemEvent.DESELECTED){
				showMailEvents = false;
				reinitSubset();
			}
			else if(arg0.getStateChange() == ItemEvent.SELECTED){
				showMailEvents = true;
				reinitSubset();
			}
		}
		else if(checkBox == priceEvent){
			if(arg0.getStateChange() == ItemEvent.DESELECTED){
				showPriceEvents = false;
				reinitSubset();
			}
			else if(arg0.getStateChange() == ItemEvent.SELECTED){
				showPriceEvents = true;
				reinitSubset();
			}
		}
		else if(checkBox == timeLimitEvent){
			if(arg0.getStateChange() == ItemEvent.DESELECTED){
				showTimeLimitEvents = false;
				reinitSubset();
			}
			else if(arg0.getStateChange() == ItemEvent.SELECTED){
				showTimeLimitEvents = true;
				reinitSubset();
			}
		}
		
		//if all are deselected change content label to display 'please choose events to view'
		if(showCostEvents == false
				&& showDiscontinueEvents == false
				&& showMailEvents == false
				&& showPriceEvents == false
				&& showTimeLimitEvents == false) {
			displayError("No history to view");
		}
		else {//refresh the frame
			addContent(subsetEvents.get(index));
			
		}
		
		checkButtons();
	}
	
	private void displayError(String err) {
		contentPanel.removeAll();
		JLabel label1 = new JLabel(err);
		contentPanel.add(label1);
		SwingUtilities.updateComponentTreeUI(mainFrame);
	}

	private void reinitSubset() {
		ArrayList<Event> newSubset = new ArrayList<Event>();
		
		for(Event event : allEvents){
			//add to new subset if its boolean is true
			if(event instanceof CostEvent){
				if(showCostEvents){
					newSubset.add(event);
				}
			}
			else if(event instanceof DiscontinueEvent){
				if(showDiscontinueEvents){
					newSubset.add(event);
				}
			}
			else if(event instanceof MailEvent){
				if(showMailEvents){
					newSubset.add(event);
				}
			}
			else if(event instanceof PriceEvent){
				if(showPriceEvents){
					newSubset.add(event);
				}
			}
			else if(event instanceof TimeLimitEvent){
				if(showTimeLimitEvents){
					newSubset.add(event);
				}
			}
		}
		index = 0;
		subsetEvents = newSubset;
		maxIndex = subsetEvents.size();
		((SpinnerNumberModel) eventChooser.getModel()).setMaximum(new Integer(maxIndex));
	}
}

package events;

import java.awt.Dialog.ModalityType;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import core.Controller;
import core.Popup;

public class PriceEventWindow {

	private JDialog dialog;
	private Controller controller;
	private ArrayList<JTextField> fields;

	private JTextField toField;
	private JTextField fromField;
	private JTextField priorityField;
	private JTextField weightCostField;
	private JTextField volumeCostField;


	/**
	 * Create the application.
	 * @param controller
	 */
	public PriceEventWindow(Controller controller) {
		this.controller = controller;
		initialize();
	}

	private void submitEvent(){
		boolean empty = false;
		for(JTextField j: fields){
			if(j.getText().trim().equals("")){
				empty = true;
			}
		}
		if(empty){
			Popup.infoBox(dialog, "A field is empty!", "Error!");
		}else{
			PriceEvent p = null;
			try{
				p = new PriceEvent(toField.getText().trim(),
				fromField.getText().trim(),
				priorityField.getText().trim(),
				Integer.parseInt(weightCostField.getText().trim()),
				Integer.parseInt(volumeCostField.getText().trim()));
			}catch(NumberFormatException e){
				Popup.infoBox(dialog, "One of the fields contains incorrect characters!", "Error!");
			}
			if(p != null){
				controller.addEvent(p);
				dialog.dispose();
			}
		}
	}

	private void initialize() {
		dialog = new JDialog();
		dialog.setTitle("Add a new price event");
		dialog.setBounds(100, 100, 750, 750);
		dialog.setModal(true);
		dialog.setAlwaysOnTop(true);
		dialog.setModalityType(ModalityType.APPLICATION_MODAL);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		JLabel to = new JLabel("To:");
		to.setBounds(10, 10, 100, 15);
		dialog.getContentPane().add(to);

		toField = new JTextField();
		toField.setBounds(110, 10, 150, 15);
		dialog.getContentPane().add(toField);
		toField.setColumns(20);

		JLabel from = new JLabel("From:");
		from.setBounds(10, 40, 100, 15);
		dialog.getContentPane().add(from);

		fromField = new JTextField();
		fromField.setBounds(110, 40, 150, 15);
		dialog.getContentPane().add(fromField);
		fromField.setColumns(20);

		JLabel priority = new JLabel("Priority:");
		priority.setBounds(10, 70, 100, 15);
		dialog.getContentPane().add(priority);

		priorityField = new JTextField();
		priorityField.setBounds(110, 70, 150, 15);
		dialog.getContentPane().add(priorityField);
		priorityField.setColumns(20);

		JLabel weightCost = new JLabel("Weight Cost:");
		weightCost.setBounds(10, 100, 100, 15);
		dialog.getContentPane().add(weightCost);

		weightCostField = new JTextField();
		weightCostField.setBounds(110, 100, 150, 15);
		dialog.getContentPane().add(weightCostField);
		weightCostField.setColumns(20);

		JLabel volumeCost = new JLabel("Volume Cost:");
		volumeCost.setBounds(10, 130, 100, 15);
		dialog.getContentPane().add(volumeCost);

		volumeCostField = new JTextField();
		volumeCostField.setBounds(110, 130, 150, 15);
		dialog.getContentPane().add(volumeCostField);
		volumeCostField.setColumns(20);

		JButton confirmButton = new JButton("Confirm");
		confirmButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				submitEvent();
			}
		});
		confirmButton.setBounds(10, 160, 100, 25);
		dialog.getContentPane().add(confirmButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dialog.dispose();
			}
		});
		cancelButton.setBounds(160, 160, 100, 25);
		dialog.getContentPane().add(cancelButton);

		//The last label in swing seems to stick to the middle and move
		//around when the frame is getting resized. A weird interaction
		//worked around by adding and empty label as the last label.
		JLabel dummy = new JLabel("");
		dummy.setBounds(10, 370, 100, 15);
		dialog.getContentPane().add(dummy);
		groupFields();

		dialog.setVisible(true);
	}

	private void groupFields() {
		fields = new ArrayList<JTextField>();
		fields.add(toField);
		fields.add(fromField);
		fields.add(priorityField);
		fields.add(weightCostField);
		fields.add(volumeCostField);
	}
}

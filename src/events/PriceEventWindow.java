package events;

import java.awt.Dialog.ModalityType;

import javax.swing.JDialog;

import core.Controller;

public class PriceEventWindow {

	private JDialog dialog;

	/**
	 * Create the application.
	 * @param controller 
	 */
	public PriceEventWindow(Controller controller) {
		initialize();
	}

	private void initialize() {
		dialog = new JDialog();
		dialog.setTitle("Add a new price event");
		dialog.setBounds(100, 100, 750, 750);
		dialog.setModal(true);
		dialog.setAlwaysOnTop(true);
		dialog.setModalityType(ModalityType.APPLICATION_MODAL);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
}

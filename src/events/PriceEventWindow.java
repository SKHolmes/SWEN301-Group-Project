package events;

import javax.swing.JFrame;

public class PriceEventWindow {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public PriceEventWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Add a new price event");
		frame.setBounds(100, 100, 750, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

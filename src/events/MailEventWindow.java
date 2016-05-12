package events;

import javax.swing.JFrame;

public class MailEventWindow {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public MailEventWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Add a new mail event");
		frame.setBounds(100, 100, 750, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

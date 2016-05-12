package events;

import javax.swing.JFrame;

public class DiscontinueEventWindow {


	private JFrame frame;

	/**
	 * Create the application.
	 */
	public DiscontinueEventWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Add a new discontinue event");
		frame.setBounds(100, 100, 750, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

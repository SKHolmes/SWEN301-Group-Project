package events;

import javax.swing.JFrame;

public class TimeLimitEventWindow {


	private JFrame frame;

	/**
	 * Create the application.
	 */
	public TimeLimitEventWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Add a new timelimit event");
		frame.setBounds(100, 100, 750, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

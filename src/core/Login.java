package core;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

	private JFrame frmKpsmart;
	private JPasswordField pwdPassword;
	private JTextField textField;
	private Controller controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmKpsmart.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		controller = new Controller(this);
		initialize();
	}
	
	public Login(Controller c){
		controller = c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKpsmart = new JFrame();
		frmKpsmart.setTitle("KPSmart");
		frmKpsmart.setBounds(100, 100, 600, 600);
		frmKpsmart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKpsmart.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToKpsmart = new JLabel("Welcome to KPSmart, please log-in to continue.");
		lblWelcomeToKpsmart.setFont(new Font("Gisha", Font.PLAIN, 20));
		lblWelcomeToKpsmart.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToKpsmart.setBounds(10, 0, 459, 24);
		frmKpsmart.getContentPane().add(lblWelcomeToKpsmart);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(67, 140, 75, 14);
		frmKpsmart.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(67, 165, 75, 14);
		frmKpsmart.getContentPane().add(lblPassword);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(152, 162, 200, 20);
		frmKpsmart.getContentPane().add(pwdPassword);
		
		textField = new JTextField();
		textField.setBounds(152, 137, 200, 20);
		frmKpsmart.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign-in");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO Check if username or pw contain a '|' and throw exception.
				controller.signIn(textField.getText(), pwdPassword.getPassword());
			}
		});
		btnNewButton.setBounds(152, 193, 89, 23);
		frmKpsmart.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.register(textField.getText(), pwdPassword.getPassword());
			}
		});
		btnNewButton_1.setBounds(251, 193, 89, 23);
		frmKpsmart.getContentPane().add(btnNewButton_1);
	}
	
	public JFrame getJFrame(){
		return frmKpsmart;		
	}
}

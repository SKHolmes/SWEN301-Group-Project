package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;

public class Controller {
	
	private View view;
	private BufferedReader reader = null;

	public Controller(View view){
		this.view = view;
		System.out.println("Working Directory = " +
	              System.getProperty("user.dir"));
	}

	

	/**
	 * @param username - The username of the person attempting to sign in.
	 * @param password - The password of the user attempting to sign in.
	 * This method will check the username and password of the user attempting
	 * to sign in and if not found will deny them access to the main program.
	 */
	public void signIn(String username, char[] password) {
		String toCheck = new String(password);
		Boolean pass = false;
		
		toCheck = username + "|" + toCheck;
		try{
			BufferedReader reader = new BufferedReader(new FileReader("logins.txt"));
			String line;
			while((line = reader.readLine()) != null)
		    {
				if(line.equals(toCheck)){
			    	  pass = true;
			      }
			    }
			    reader.close();
		}catch(Exception e){
			System.out.println("Error: " + e.getLocalizedMessage());
		}
		if(pass){
			//TODO New window.
		}else{
			Popup.infoBox("Invalid Username or Password!", "Error!");
		}
	}



	/**
	 * @param text - The String of the username attempting to register.
	 * @param password - The char array of the user's password, safer this way.
	 * This method simply performs sanity checks on the attempt to register to ensure 
	 * neither field is empty and the username is still available.
	 */
	public void register(String text, char[] password) {
		String pw = new String(password);
		
		if(text.isEmpty()){
			Popup.infoBox("Username field is empty!", "Error!");
			return;
		}
		if(pw.isEmpty()){
			Popup.infoBox("Password field is empty", "Error!");
			return;
		}
		if(getPassword(text) != null){
			Popup.infoBox("Username is already taken try again!", "Error!");
			return;
		}
		addNewUser(text, pw);
	}



	/**
	 * Precondition - All sanity checks have passed and the user can now register in the file.
	 * @param text - The username of the user registering.
	 * @param pw - The password of the user.
	 */
	private void addNewUser(String text, String pw) {
		PrintStream fileStream;
		try {
			fileStream = new PrintStream(new File("logins.txt"));
			fileStream.println(text + "|" + pw);
			fileStream.close();
		} catch (FileNotFoundException e) {
			e.getLocalizedMessage();
		}
		Popup.infoBox("You have signed up!", "Congratulations!");
	}	



	/**
	 * @param text - The username to search the file for it's password.
	 * @return String - The password if the username is found. Null if no user exists by that name.
	 */
	private String getPassword(String text) {
		try{
			BufferedReader reader = new BufferedReader(new FileReader("logins.txt"));
			String line;
			while((line = reader.readLine()) != null)
		    {
				String user[] = line.split("\\|");
				if(user[0].equals(text)){
					return user[1];
				}
			}
			reader.close();
		}catch(Exception e){
			System.out.println("Error: " + e.getLocalizedMessage());
		}
		return null;
	}
	
}

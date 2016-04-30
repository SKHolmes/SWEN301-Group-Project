package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Controller {
	
	private View view;
	private BufferedReader reader = null;

	public Controller(View view){
		this.view = view;
		System.out.println("Working Directory = " +
	              System.getProperty("user.dir"));
	}

	

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
			
		}else{
			Popup.infoBox("Invalid Username or Password!", "Error!");
		}
	}
	
}

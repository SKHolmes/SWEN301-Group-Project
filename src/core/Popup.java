package core;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Popup {
	public static void infoBox(Object o, String infoMessage, String titleBar)
    {
		if(o instanceof Component){			
			Component c = (Component) o;
			JOptionPane.showMessageDialog(c, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
		}
        
    }	
}

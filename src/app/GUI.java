package app;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class GUI extends JPanel{
	
	public static void createAndShowGUI() {
		JFrame frame = new JFrame("Simple Example");
		frame.setContentPane(new GUI());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);		
	}

}

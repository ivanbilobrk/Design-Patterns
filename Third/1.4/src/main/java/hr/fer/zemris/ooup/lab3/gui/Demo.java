package hr.fer.zemris.ooup.lab3.gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Demo extends JFrame{
	
	Demo(){
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(500,500);
		initGUI();
	}
	
	private static final long serialVersionUID = 1L;

	private void initGUI() {
		this.getContentPane().add(new PracticeComponent(this));
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			new Demo().setVisible(true);
		});
	}
}

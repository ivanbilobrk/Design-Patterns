package hr.fer.zemris.ooup.lab3.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PracticeComponent extends JComponent{
	
	private final static String text1 = "Ovo je prva linija teksta.";
	private final static String text2 = "Ovo je druga linija teksta.";
	
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	
	PracticeComponent(JFrame frame){
		this.frame = frame;
		frame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		        	
		            frame.dispose();
		        }
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		Insets ins = getInsets();
		Dimension dim = getSize();
		Rectangle r = new Rectangle(
				ins.left, 
				ins.top, 
				dim.width-ins.left-ins.right,
				dim.height-ins.top-ins.bottom);
		
		//crtanje pozadine po potrebi
		if(isOpaque()) {
			g2d.setColor(getBackground());
			g2d.fillRect(r.x, r.y, r.width, r.height);
		}
		
		g2d.setColor(Color.red);
		g2d.drawLine(0, (int)(r.getHeight()/2), (int)(r.getWidth()), (int)(r.getHeight()/2));
		g2d.drawLine((int)(r.getWidth()/2), 0, (int)(r.getWidth()/2), (int)(r.getHeight()));
		
		g2d.setColor(Color.black);
		
		FontMetrics fm = g2d.getFontMetrics();
		g2d.drawString(text1, 0, ins.top + fm.getAscent());
		g2d.drawString(text2, 0, ins.top + fm.getAscent() + fm.getHeight());
		
	}
}

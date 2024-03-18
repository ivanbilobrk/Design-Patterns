package hr.fer.zemris.ooup.lab3.texteditor;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class CustomCursor extends JComponent implements CursorObserver{
	
	private static final long serialVersionUID = 1L;
	private volatile boolean showing;
	private volatile boolean stopRequested;
	
	
	public CustomCursor(JFrame frame) {
		showing = true;
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				CustomCursor.this.stop();
			}
		});
		
		Thread t = new Thread(()->{
			while(true) {
				try {
					Thread.sleep(500);
				} catch(Exception ex) {}
				if(stopRequested) break;
				SwingUtilities.invokeLater(()->{
					showing = !showing;
					CustomCursor.this.setVisible(showing);
					repaint();
				});
			}
		});
		t.setDaemon(true);
		t.start();
	}
	
	private void stop() {
		stopRequested = true;
	}
	
	@Override
	public void updateCursorLocation(Location loc) {
		setVisible(true);
		FontMetrics fm = getFontMetrics(new Font(Font.MONOSPACED, Font.PLAIN, 18));
		int letterWidth = fm.charWidth('a');
		
		this.setLocation(loc.getX()*letterWidth, loc.getY()*fm.getHeight()+5);
		repaint();
		
	}
	
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.drawLine(0, 0, 0, this.getHeight());
		
	}
	
}

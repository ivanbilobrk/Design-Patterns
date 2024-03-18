package hr.fer.zemris.ooup.lab3.texteditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class TextEditor extends JComponent{
	
	private static final long serialVersionUID = 1L;
	private TextModel model;
	private CustomCursor cursor;
	
	TextEditor(TextModel model, JFrame frame, Action undoAction, Action redoAction, Action cutAction, Action copyAction, Action pasteAction, 
			Action pasteTakeAction, Action deleteSelectionAction){
		setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
		this.setFocusable(true);
		this.model = model;
		this.cursor = new CustomCursor(frame);
		
		this.add(cursor);
		cursor.setLocation(0, 6);
		cursor.setSize(1, getFontMetrics(getFont()).getHeight()-2);
		
        InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = this.getActionMap();
        
        int undoKeyCode = KeyEvent.VK_Z;
        int ctrlModifier = InputEvent.CTRL_DOWN_MASK;
        inputMap.put(KeyStroke.getKeyStroke(undoKeyCode, ctrlModifier), "undo");
        actionMap.put("undo", undoAction);
        
        int redoKeyCode = KeyEvent.VK_Y;
        inputMap.put(KeyStroke.getKeyStroke(redoKeyCode, ctrlModifier), "redo");
        actionMap.put("redo", redoAction);
        
        int cutKeyCode = KeyEvent.VK_X;
        inputMap.put(KeyStroke.getKeyStroke(cutKeyCode, ctrlModifier), "cut");
        actionMap.put("cut", cutAction);
        
        int copyKeyCode = KeyEvent.VK_C;
        inputMap.put(KeyStroke.getKeyStroke(copyKeyCode, ctrlModifier), "copy");
        actionMap.put("copy", copyAction);
        
        int pasteKeyCode = KeyEvent.VK_V;
        inputMap.put(KeyStroke.getKeyStroke(pasteKeyCode, ctrlModifier), "paste");
        actionMap.put("paste", pasteAction);
        
        inputMap.put(KeyStroke.getKeyStroke(pasteKeyCode, ctrlModifier|InputEvent.SHIFT_DOWN_MASK), "paste2");
        actionMap.put("paste2", pasteTakeAction);
        
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "leftArrow");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, InputEvent.SHIFT_DOWN_MASK), "shiftLeft");
        
        AbstractAction leftArrow = new AbstractAction() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
            	int modifiers = e.getModifiers();

            	boolean shiftPressed = (modifiers & ActionEvent.SHIFT_MASK) != 0;
        		
                Location oldCursor = new Location(model.getCursorLocation().getX(), model.getCursorLocation().getY());
                model.moveCursorLeft(); 
                new ArrowFunction(model, (model, oldcursor) -> {
                    if (oldcursor.equals(model.getSelectionRange().getL2())) {
                        model.getSelectionRange().setL2(new Location(model.getCursorLocation().getX(), model.getCursorLocation().getY()));
                    } else {
                        model.getSelectionRange().setL1(new Location(model.getCursorLocation().getX(), model.getCursorLocation().getY()));
                    }
                }).doAction(shiftPressed, oldCursor); 
				
			}
		};
        
        actionMap.put("leftArrow", leftArrow);
        actionMap.put("shiftLeft", leftArrow);
        
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "rightArrow");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, InputEvent.SHIFT_DOWN_MASK), "shiftRight");
        
        AbstractAction rightArrow = new AbstractAction() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
            	int modifiers = e.getModifiers();

            	boolean shiftPressed = (modifiers & ActionEvent.SHIFT_MASK) != 0;
				
				Location oldCursor = new Location(model.getCursorLocation().getX(), model.getCursorLocation().getY());
				model.moveCursorRight();
			    new ArrowFunction(model, (model, oldcursor) -> {
			    	if(oldcursor.equals(model.getSelectionRange().getL1())) {
			    		model.getSelectionRange().setL1(new Location(model.getCursorLocation().getX(), model.getCursorLocation().getY()));
			    	
			    	} else {
			    		
			    		model.getSelectionRange().setL2(new Location(model.getCursorLocation().getX(), model.getCursorLocation().getY()));
			    	}
			        
			    }).doAction(shiftPressed, oldCursor);
			}
		};
		
        actionMap.put("rightArrow", rightArrow);
        actionMap.put("shiftRight", rightArrow);
        
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "upArrow");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, InputEvent.SHIFT_DOWN_MASK), "shiftUp");
        
        AbstractAction upArrow = new AbstractAction() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				
            	int modifiers = e.getModifiers();

            	boolean shiftPressed = (modifiers & ActionEvent.SHIFT_MASK) != 0;
				
				Location oldCursor = new Location(model.getCursorLocation().getX(), model.getCursorLocation().getY());
				model.moveCursorUp(); 
			    new ArrowFunction(model, (model, oldcursor) -> {
			    	
			    	if(model.getSelectionRange().getL2().getY() == model.getSelectionRange().getL1().getY()) {
			    		
			    		model.getSelectionRange().setL1(new Location(model.getCursorLocation().getX(), model.getCursorLocation().getY()));
			    	} else if(model.getCursorLocation().equals(model.getSelectionRange().getL2())) {
			    		model.getSelectionRange().setL2(new Location(model.getCursorLocation().getX(), model.getCursorLocation().getY()));
			    	} else if(oldcursor.equals(model.getSelectionRange().getL2())) {
			    		int x1 = model.getSelectionRange().getL1().getX();
			    		int x2 = model.getSelectionRange().getL2().getX();
			    		
			    		if(x1 > x2 || model.getCursorLocation().getY() > model.getSelectionRange().getL2().getY()) {
			    			System.out.println("da da da");
			    			model.getSelectionRange().setL2(model.getSelectionRange().getL1());
			    			model.getSelectionRange().setL1(new Location(model.getCursorLocation().getX(), model.getCursorLocation().getY()));
			    		} else {
			    			
			    			model.getSelectionRange().setL2(new Location(model.getCursorLocation().getX(), model.getCursorLocation().getY()));
			    		}
			    		
			    	} else {
			    		if(model.getSelectionRange().getL1().equals(model.getSelectionRange().getL2())) model.setSelectionRange(null);
			    		model.getSelectionRange().setL1(new Location(model.getCursorLocation().getX(), model.getCursorLocation().getY()));
			    	}
			        
			    }).doAction(shiftPressed, oldCursor);
				
			}
		};
		
        actionMap.put("upArrow", upArrow);
        actionMap.put("shiftUp", upArrow);
        
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "downArrow");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, InputEvent.SHIFT_DOWN_MASK), "shiftDown");
        
        AbstractAction downArrow = new AbstractAction() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				
            	int modifiers = e.getModifiers();

            	boolean shiftPressed = (modifiers & ActionEvent.SHIFT_MASK) != 0;
				
				Location oldCursor = new Location(model.getCursorLocation().getX(), model.getCursorLocation().getY());
				model.moveCursorDown(); 
			    new ArrowFunction(model, (model, oldcursor) -> {
			    	
			    	if(model.getSelectionRange().getL2().getY() == model.getSelectionRange().getL1().getY()) {
			    		System.out.println("gg");
			    			    			
			    			model.getSelectionRange().setL2(new Location(model.getCursorLocation().getX(), model.getCursorLocation().getY()));
			    		
			    	} else if(oldcursor.equals(model.getSelectionRange().getL1())) {
			    		System.out.println("ee");
			    		int x1 = model.getSelectionRange().getL1().getX();
			    		int x2 = model.getSelectionRange().getL2().getX();
			    		if(x1 <= x2 || model.getCursorLocation().getY() < model.getSelectionRange().getL2().getY()) {
			    			model.getSelectionRange().setL1(new Location(model.getCursorLocation().getX(), model.getCursorLocation().getY()));
			    		} else if(x1 > x2){
			    			model.getSelectionRange().setL1(model.getSelectionRange().getL2());
			    			model.getSelectionRange().setL2(new Location(model.getCursorLocation().getX(), model.getCursorLocation().getY()));
			    		} 
			    			
			    	} else {
			    		System.out.println(model.getCursorLocation().getY()+" "+model.getSelectionRange().getL1().getY());
			    		if(model.getSelectionRange().getL1().equals(model.getSelectionRange().getL2())) model.setSelectionRange(null);
			    		model.getSelectionRange().setL2(new Location(model.getCursorLocation().getX(), model.getCursorLocation().getY()));
			    	}
			        
			    }).doAction(shiftPressed, oldCursor);
				
			}
		};
		
        actionMap.put("downArrow", downArrow);
        actionMap.put("shiftDown", downArrow);
        
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "backSpace");
        
        AbstractAction backSpace = new AbstractAction() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if(model.getSelectionRange() != null) {
					model.deleteRange(model.getSelectionRange(), true);
				} else {
					model.deleteBefore(true);
				}
				
			}
		};
		
		actionMap.put("backSpace", backSpace);
		
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "delete");
		
		AbstractAction delete = new AbstractAction() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if(model.getSelectionRange() != null) {
					model.deleteRange(model.getSelectionRange(), true);
				} else {
					model.deleteAfter();
				}
			}
		};
        
        actionMap.put("delete", delete);
        
		initKeys();
	}
	
	private void initKeys() {
		
		model.addCursorObserver(cursor);
		
		model.addTextObserver(new TextObserver() {
			
			@Override
			public void updateText() {
	
				repaint();
				
			}
		});
		
		this.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e) {
		        if(!e.isShiftDown() && !e.isControlDown() && e.getKeyCode() != KeyEvent.VK_LEFT && e.getKeyCode() != KeyEvent.VK_RIGHT && e.getKeyCode() != KeyEvent.VK_UP && e.getKeyCode() != KeyEvent.VK_DOWN && e.getKeyCode() != KeyEvent.VK_DELETE && e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
		            model.insert(e.getKeyChar(), true);
		        }
		    }
		});
	}
	
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 18);
        g2d.setFont(font);
		
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
		
		FontMetrics fm = g2d.getFontMetrics();
		
		if(model.getSelectionRange() != null) {
			g2d.setColor(Color.cyan);
			LocationRange range = model.getSelectionRange();
			
			int y1 = range.getL1().getY();
			int y2 = range.getL2().getY();
			int x1 = range.getL1().getX();
			int x2 = range.getL2().getX();
			
			if(y1 == y2) {
				g2d.fillRect(x1*fm.stringWidth("a"), y1*fm.getHeight()+5, (x2-x1)*fm.stringWidth("a"), fm.getHeight());
			} else {
				Iterator<String> it = model.linesRange(y1, y2);
				boolean first = true;
				int count = y1;
				
				while(it.hasNext()) {
					String line = it.next();
					int length = line.length();
					if(first) {
						g2d.fillRect(x1*fm.stringWidth("a"), count*fm.getHeight()+5, (length-x1)*fm.stringWidth("a"), fm.getHeight());
						first = false;
					} else {
						g2d.fillRect(0, count*fm.getHeight()+5, length*fm.stringWidth("a"), fm.getHeight());
						
					}
					++count;
				}
				
				g2d.fillRect(0, count*fm.getHeight()+5, x2*fm.stringWidth("a"), fm.getHeight());
			}
			
			g2d.setColor(Color.black);
		}
		
		
		
		int i = 0;
		
		Iterator<String> linesIt = model.allLines();
		
		while(linesIt.hasNext()) {
			g2d.drawString(linesIt.next(), 0, ins.top+(i+1)*fm.getHeight());
			++i;
		}
	}
}

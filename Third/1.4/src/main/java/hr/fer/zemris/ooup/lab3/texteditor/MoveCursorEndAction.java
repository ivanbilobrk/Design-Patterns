package hr.fer.zemris.ooup.lab3.texteditor;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;

public class MoveCursorEndAction extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private TextModel model;
	
	public MoveCursorEndAction(String name, TextModel model){
		super(name);
		this.model = model;
		this.setEnabled(!model.getLines().isEmpty());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		List<String> lines = model.getLines();
		
		model.getCursorLocation().setX(lines.get(lines.size()-1).length());
		model.getCursorLocation().setY(lines.size()-1);
		model.alertCursorObservers();
	}

}

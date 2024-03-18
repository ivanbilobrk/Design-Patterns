package hr.fer.zemris.ooup.lab3.texteditor;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class MoveCursorStartAction extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private TextModel model;
	
	public MoveCursorStartAction(String name, TextModel model){
		super(name);
		this.model = model;
		this.setEnabled(!model.getLines().isEmpty());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		model.getCursorLocation().setX(0);
		model.getCursorLocation().setY(0);
		model.alertCursorObservers();
	}

}
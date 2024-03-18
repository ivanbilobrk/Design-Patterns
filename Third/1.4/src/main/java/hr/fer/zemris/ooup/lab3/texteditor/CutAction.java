package hr.fer.zemris.ooup.lab3.texteditor;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class CutAction extends AbstractAction implements TextObserver{

	private static final long serialVersionUID = 2590336408702287825L;
	
	private TextModel model;
	
	public CutAction(String name, TextModel model){
		super(name);
		this.model = model;
		this.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.cutAction();
	}

	@Override
	public void updateText() {
		if(model.getSelectionRange() != null) {
			this.setEnabled(true);
			return;
		}
		this.setEnabled(false);
		
	}
}
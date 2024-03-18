package hr.fer.zemris.ooup.lab3.texteditor;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class CopyAction extends AbstractAction implements TextObserver{

	private static final long serialVersionUID = 2590336408702287825L;
	
	private TextModel model;
	
	public CopyAction(String name, TextModel model){
		super(name);
		this.model = model;
		this.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.copyAction();
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
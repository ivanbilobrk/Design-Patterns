package hr.fer.zemris.ooup.lab3.texteditor;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class DeleteSelectionAction extends AbstractAction implements TextObserver{

	private static final long serialVersionUID = 1L;
	private TextModel model;
	
	public DeleteSelectionAction(String name, TextModel model){
		super(name);
		this.model = model;
		this.setEnabled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(model.getSelectionRange() != null) {
			model.deleteRange(model.getSelectionRange(), true);
		}
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

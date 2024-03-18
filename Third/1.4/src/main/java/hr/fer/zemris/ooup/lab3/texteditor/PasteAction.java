package hr.fer.zemris.ooup.lab3.texteditor;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class PasteAction extends AbstractAction implements ClipboardObserver{

	private static final long serialVersionUID = 2590336408702287825L;
	
	private TextModel model;
	
	public PasteAction(String name, TextModel model){
		super(name);
		this.model = model;
		this.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.pasteAction();
		model.setSelectionRange(null);
	}

	@Override
	public void updateClipboard() {
		if(model.getClipBoard().hasText()) {
			this.setEnabled(true);
			return;
		}
		
		this.setEnabled(false);
		
	}


}
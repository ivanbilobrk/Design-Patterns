package hr.fer.zemris.ooup.lab3.texteditor;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class UndoAction extends AbstractAction implements UndoObserver{

	private static final long serialVersionUID = 2590336408702287825L;
	

	public UndoAction(String name){
		super(name);

		this.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UndoManager manager = UndoManager.getUndoManagerInstance();
		manager.undo();
		
	}

	@Override
	public void managerChanged() {
		if(UndoManager.getUndoManagerInstance().isUndoEmpty()) {
			this.setEnabled(false);
			return;
		}
			
		this.setEnabled(true);
		
	}

}

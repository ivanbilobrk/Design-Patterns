package hr.fer.zemris.ooup.lab3.texteditor;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class RedoAction extends AbstractAction implements UndoObserver{

	private static final long serialVersionUID = 2590336408702287825L;
	

	public RedoAction(String name){
		super(name);

		this.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UndoManager manager = UndoManager.getUndoManagerInstance();
		
		EditAction action = manager.popRedoStack();
		if(action != null) {
			action.execute_do();
			manager.pushUndo(action);
		}
		
	}

	@Override
	public void managerChanged() {
		if(UndoManager.getUndoManagerInstance().isRedoEmpty()) {
			this.setEnabled(false);
			return;
		}
			
		this.setEnabled(true);
		
	}

}

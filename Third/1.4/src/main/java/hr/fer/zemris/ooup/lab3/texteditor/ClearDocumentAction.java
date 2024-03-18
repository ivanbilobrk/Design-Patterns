package hr.fer.zemris.ooup.lab3.texteditor;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;

public class ClearDocumentAction extends AbstractAction implements TextObserver{

	private static final long serialVersionUID = 1L;
	private TextModel model;
	
	public ClearDocumentAction(String name, TextModel model){
		super(name);
		this.model = model;
		this.setEnabled(!model.getLines().isEmpty());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		List<String> lines = model.getLines();
		LocationRange selectionAll = new LocationRange(new Location(0, 0), new Location(lines.get(lines.size()-1).length(), lines.size()-1));
		model.deleteRange(selectionAll, true);
	}

	@Override
	public void updateText() {
		
		if(model.getLines().size() > 0) {
			this.setEnabled(true);
			return;
		}
		
		this.setEnabled(false);
	}

}
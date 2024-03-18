package hr.fer.zemris.ooup.lab3.texteditor;

import java.util.List;

public class DeleteAfterAction implements EditAction{
	
	private Location cursorLocation;
	private List<String> lines;
	private char removedChar;
	private TextModel model;
	boolean multipleRowDelete;
	
	public DeleteAfterAction(TextModel model) {
		this.model = model;
		this.cursorLocation = new Location(model.getCursorLocation().getX(), model.getCursorLocation().getY());
		this.lines = model.getLines();
	}
	
	@Override
	public void execute_do() {
		int x = cursorLocation.getX();
		int y = cursorLocation.getY();
		
		model.getCursorLocation().setX(x);
		model.getCursorLocation().setY(y);
		model.alertCursorObservers();
		
		if(x == lines.get(y).length() && y == lines.size()-1) return;
		
		if(x == lines.get(y).length()) {
			multipleRowDelete = true;
			int y1 = y+1;
			String newCombinedRow = lines.get(y)+lines.get(y1);
			lines.remove(y);
			
			
			lines.add(y, newCombinedRow);
			lines.remove(y1);
			
		} else {
			StringBuilder sb = new StringBuilder(lines.get(y));
			removedChar = lines.get(y).charAt(x);
			sb.deleteCharAt(x);
			
			lines.remove(y);
			lines.add(y, sb.toString()); 
		}
		model.alertTextObservers();
	}

	@Override
	public void execute_undo() {
		
		if(multipleRowDelete) {
			
			model.getCursorLocation().setX(cursorLocation.getX());
			model.getCursorLocation().setY(cursorLocation.getY());
			model.insert('\n', false);

			
		} else {
			int y = cursorLocation.getY();
			StringBuilder sb = new StringBuilder(lines.get(y));
			
			sb.insert(cursorLocation.getX(), removedChar);
			lines.remove(y);
			lines.add(y, sb.toString());
		}
		
		model.getCursorLocation().setX(cursorLocation.getX());
		model.getCursorLocation().setY(cursorLocation.getY());
		model.alertCursorObservers();
		model.alertTextObservers();
		
	}

}

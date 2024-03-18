package hr.fer.zemris.ooup.lab3.texteditor;

import java.util.List;

public class DeleteBeforeAction implements EditAction{
	
	private Location cursorLocation;
	private List<String> lines;
	private char removedChar;
	private TextModel model;
	boolean multipleRowDelete;
	int oldRowLength;
	
	public DeleteBeforeAction(TextModel model) {
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
		
		model.moveCursorLeft();
		
		if(x == 0 && y == 0) return;
		
		//treba spojiti dva redka
		if(x == 0) {
			multipleRowDelete = true;
			int y1 = y-1;
			String newCombinedRow = lines.get(y1)+lines.get(y);
			oldRowLength = lines.get(y1).length();
			lines.remove(y);
			lines.remove(y1);
			lines.add(y1, newCombinedRow);

		} else {
			//radimo brisanje jednog znaka
			StringBuilder sb = new StringBuilder(lines.get(y));
			removedChar = lines.get(y).charAt(x-1);
			sb.deleteCharAt(x-1);
		
			lines.remove(y);
			lines.add(y, sb.toString()); 
		}
		
		model.alertTextObservers();
	}

	@Override
	public void execute_undo() {

		if(multipleRowDelete) {
			
			int y = cursorLocation.getY()-1;
			model.getCursorLocation().setX(oldRowLength);
			model.getCursorLocation().setY(y);
			model.insert('\n', false);
			
			
		} else {
			int y = cursorLocation.getY();
			StringBuilder sb = new StringBuilder(lines.get(y));
			
			sb.insert(cursorLocation.getX()-1, removedChar);
			lines.remove(y);
			lines.add(y, sb.toString());
			model.getCursorLocation().setX(cursorLocation.getX());
			model.getCursorLocation().setY(cursorLocation.getY());
		}

		model.alertCursorObservers();
		model.alertTextObservers();
		
	}

}

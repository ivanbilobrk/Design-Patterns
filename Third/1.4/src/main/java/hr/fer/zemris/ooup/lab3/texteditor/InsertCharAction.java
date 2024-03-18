package hr.fer.zemris.ooup.lab3.texteditor;

import java.util.List;

public class InsertCharAction implements EditAction{
	
	private Location cursorLocation;
	private List<String> lines;
	private TextModel model;
	boolean multipleRowDelete;
	private char charInserted;
	
	public InsertCharAction(TextModel model, char charInserted) {
		this.charInserted = charInserted;
		this.model = model;
		this.cursorLocation = new Location(model.getCursorLocation().getX(), model.getCursorLocation().getY());
		this.lines = model.getLines();
	}

	@Override
	public void execute_do() {
		
		int lineNum = cursorLocation.getY();
		String line = lines.get(lineNum);
		if(charInserted != '\n') {
			StringBuilder sb = new StringBuilder(line);
			sb.insert(cursorLocation.getX(), charInserted);
			
			line = sb.toString();
			lines.remove(lineNum);
			lines.add(lineNum, line);
		} else {
			String line1 = line.substring(0, cursorLocation.getX());
			String line2 = line.substring(cursorLocation.getX());
			lines.remove(cursorLocation.getY());
			lines.add(lineNum, line1);
			lines.add(lineNum+1, line2);
		}

		model.moveCursorRight();
		model.alertTextObservers();
		
	}

	@Override
	public void execute_undo() {
		model.deleteBefore(false);
		
	}

}

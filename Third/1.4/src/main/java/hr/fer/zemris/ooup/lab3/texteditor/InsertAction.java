package hr.fer.zemris.ooup.lab3.texteditor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertAction implements EditAction{
	
	private Location cursorLocationBefore;
	private Location cursorLocationAfter;
	private Location modelCursor;
	private List<String> lines;
	private TextModel model;
	boolean multipleRowDelete;
	private String textInserted;
	
	
	public InsertAction(TextModel model, String textInserted) {
		this.textInserted = textInserted;
		this.model = model;
		this.modelCursor = model.getCursorLocation();
		this.cursorLocationBefore = new Location(model.getCursorLocation().getX(), model.getCursorLocation().getY());
		this.lines = model.getLines();
	}

	@Override
	public void execute_do() {
		List<String> newLines = new ArrayList<>(Arrays.asList(textInserted.split("\\r?\\n")));
		if(newLines.size() == 0) return;
		
		int lineNum = cursorLocationBefore.getY();
		String line = lines.get(lineNum);
		lines.remove(lineNum);
		
		if(newLines.size() == 1) {
			line = line.substring(0, modelCursor.getX()) + newLines.get(0) + line.substring(modelCursor.getX());
			lines.add(lineNum, line);
			modelCursor.setX(modelCursor.getX()+newLines.get(0).length());
		} else {
			String firstLineRemainder = line.substring(modelCursor.getX());
			
			line = line.substring(0, modelCursor.getX());
			line = line + newLines.get(0);
			
			lines.add(lineNum, line);
			
			for(int i = 1; i < newLines.size()-1; i++) {
				lines.add(lineNum + i, newLines.get(i));
			}
			
			
			int indexTemp = lineNum + newLines.size()-1;
			String lastLine = newLines.get(newLines.size()-1) + firstLineRemainder;
			
			lines.add(indexTemp, lastLine);
			

			modelCursor.setY(indexTemp);
			modelCursor.setX(newLines.get(newLines.size()-1).length());
		}
		
		cursorLocationAfter = new Location(modelCursor.getX(), modelCursor.getY());
		model.alertCursorObservers();
		model.alertTextObservers();
		
	}

	@Override
	public void execute_undo() {
		model.deleteRange(new LocationRange(cursorLocationBefore, cursorLocationAfter), false);
		
	}

}

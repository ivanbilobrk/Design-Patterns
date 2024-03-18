package hr.fer.zemris.ooup.lab3.texteditor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TextEditorModel implements TextModel{
	private List<String> lines;
	private LocationRange selectionRange;
	private Location cursorLocation;
	private List<CursorObserver> cursorObservers;
	private List<TextObserver> textObservers;
	private ClipboardStack stack;
	
	TextEditorModel(String text, ClipboardStack stack){
		this.stack = stack;
		lines = new ArrayList<>(Arrays.asList(text.split("\\r?\\n")));
		cursorLocation = new Location(0, 0);
		cursorObservers = new ArrayList<>();
		textObservers = new ArrayList<>();
	}
	
	public Location getCursorLocation() {
		return cursorLocation;
	}
	
	public void addCursorObserver(CursorObserver cobs) {
		cursorObservers.add(cobs);
	}
	
	public void removeCursorObserver(CursorObserver cobs) {
		cursorObservers.remove(cobs);
	}
	
	public void alertCursorObservers() {
		for(var x: cursorObservers) {
			x.updateCursorLocation(cursorLocation);
		}
	}

	@Override
	public List<String> getLines() {
		if(lines != null) return lines;
		
		throw new NullPointerException("Dokument nema linija teksta.");
	}

	@Override
	public Iterator<String> allLines() {
		return lines.iterator();
	}

	@Override
	public Iterator<String> linesRange(int index1, int index2) {
		List<String> temp = lines.subList(index1, index2);
		return temp.iterator();
	}

	@Override
	public void moveCursorLeft() {
		Location currentLocation = cursorLocation;
		int row = currentLocation.getY();
		int column = currentLocation.getX();
		
		--column;
		
		//slučaj kada smo u prvom redku i prvom stupcu i želimo se pomaknuti unazad
		if(row == 0 && column < 0) return;
		
		if(column < 0) {
			--row;
			column = lines.get(row).length();
		}
		
		currentLocation.setY(row);
		currentLocation.setX(column);
		alertCursorObservers();
		
	}

	@Override
	public void moveCursorRight() {
		Location currentLocation = cursorLocation;
		int row = currentLocation.getY();
		int column = currentLocation.getX();
		
		int currentRowChars = lines.get(row).length();
		
		++column;
		
		//slučaj za zadnji redak i zadnji stupac
		if(row == lines.size()-1 && column == currentRowChars+1) return;
		
		if(column == currentRowChars+1) {
			++row;
			column = 0;
		}
		
		currentLocation.setY(row);
		currentLocation.setX(column);
		alertCursorObservers();
		
	}

	@Override
	public void moveCursorUp() {
		Location currentLocation = cursorLocation;
		int row = currentLocation.getY();
		int column = currentLocation.getX();
		
		--row;
		
		if(row < 0) row = 0;
		
		int maxColumn = lines.get(row).length();
		if(column > maxColumn) column = maxColumn;
		
		currentLocation.setX(column);
		currentLocation.setY(row);
		alertCursorObservers();
		
	}

	@Override
	public void moveCursorDown() {
		Location currentLocation = cursorLocation;
		int row = currentLocation.getY();
		int column = currentLocation.getX();
		
		++row;
		
		if(row == lines.size()) row = lines.size()-1;
		
		int maxColumn = lines.get(row).length();
		if(column > maxColumn) column = maxColumn;
		
		currentLocation.setX(column);
		currentLocation.setY(row);
		alertCursorObservers();
		
	}

	@Override
	public void addTextObserver(TextObserver tobs) {
		textObservers.add(tobs);
	}

	@Override
	public void removeTextObserver(TextObserver tobs) {
		textObservers.remove(tobs);
	}

	@Override
	public void alertTextObservers() {
		for(var x: textObservers) {
			x.updateText();
		}
	}

	@Override
	public void deleteBefore(boolean flag) {
		
		EditAction delAction = new DeleteBeforeAction(this);
		
		delAction.execute_do();
		
		if(flag)
			UndoManager.getUndoManagerInstance().push(delAction);
		
		
	}

	@Override
	public void deleteAfter() {
		
		EditAction delAction = new DeleteAfterAction(this);
		
		delAction.execute_do();
		UndoManager.getUndoManagerInstance().push(delAction);
		
		
	}

	@Override
	public void deleteRange(LocationRange r, boolean flag) {
		EditAction delAction = new DeleteRangeAction(this, r);
		
		delAction.execute_do();
		
		if(flag)
			UndoManager.getUndoManagerInstance().push(delAction);
		
	}

	@Override
	public LocationRange getSelectionRange() {
		return selectionRange;
	}

	@Override
	public void setSelectionRange(LocationRange range) {
		selectionRange = range;
		alertTextObservers();
	}
	
	@Override
	public void insert(char c, boolean flag) {
		
		if(getSelectionRange() != null) {
			deleteRange(getSelectionRange(), true);
		}
		
		EditAction insertAction = new InsertCharAction(this, c);
		
		insertAction.execute_do();
		
		if(flag)
			UndoManager.getUndoManagerInstance().push(insertAction);
		
	}
	@Override
	public void insert(String text) {
		
		if(getSelectionRange() != null) {
			deleteRange(getSelectionRange(), true);
		}
		
		EditAction insertTextAction = new InsertAction(this, text);
		
		insertTextAction.execute_do();
		UndoManager.getUndoManagerInstance().push(insertTextAction);
		
	}

	@Override
	public void copyAction() {
		stack.pushText(getSelectionAsText());
	}
	
	private String getSelectionAsText() {
		if(selectionRange != null) {
			Location loc1 = getSelectionRange().getL1();
			Location loc2 = getSelectionRange().getL2();
			
			int y1 = loc1.getY();
			int y2 = loc2.getY();
			int x1 = loc1.getX();
			int x2 = loc2.getX();
			
			if(y1 == y2) {
				String textToCopy = lines.get(y1).substring(x1, x2);
				return textToCopy;
			} else {
				StringBuilder sb = new StringBuilder();
				
				sb.append(lines.get(y1).substring(x1));
				sb.append("\n");
				
				for(int i = y1+1; i < y2; i++) {
					sb.append(lines.get(i));
					sb.append("\n");
				}
				
				sb.append(lines.get(y2).substring(0, x2));
				
				return sb.toString();
			}
		} 
		return "";
	}

	@Override
	public void cutAction() {
		String selection = getSelectionAsText();
		
		if(selection.length() != 0) {
			stack.pushText(getSelectionAsText());
			deleteRange(selectionRange, true);
		}
	}

	@Override
	public void pasteAction() {
		if(stack.hasText()) {
			insert(stack.peek());
		}
		
	}

	@Override
	public void pasteAction2() {
		if(stack.hasText()) {
			insert(stack.popText());
		}
		
	}

	@Override
	public void setLines(List<String> lines) {
		this.lines = lines;
		
	}

	@Override
	public ClipboardStack getClipBoard() {
		return stack;
	}
	
	
}

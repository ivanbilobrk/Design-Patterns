package hr.fer.zemris.ooup.lab3.texteditor;

import java.util.Iterator;
import java.util.List;

public interface TextModel {
	
	public List<String> getLines();
	
	public Iterator<String> allLines();
	
	public Iterator<String> linesRange(int index1, int index2);
	
	public void moveCursorLeft();
	
	public void moveCursorRight();
	
	public void moveCursorUp(); 
	
	public void moveCursorDown();
	
	public void alertCursorObservers();
	
	public void addCursorObserver(CursorObserver cobs);
	
	public void removeCursorObserver(CursorObserver cobs);
	
	public void addTextObserver(TextObserver tobs);
	
	public void removeTextObserver(TextObserver tobs);
	
	public void alertTextObservers();
	
	public void deleteBefore(boolean flag);
	
	public void deleteAfter();
	
	public void deleteRange(LocationRange r, boolean flag);
	
	public LocationRange getSelectionRange();
	
	public void setSelectionRange(LocationRange range);
	
	public Location getCursorLocation();
	
	public void insert(char c, boolean flag);
	
	public void insert(String text);
	
	public void copyAction();
	
	public void cutAction();
	
	public void pasteAction();
	
	public void pasteAction2();
	
	public void setLines(List<String> lines);
	
	public ClipboardStack getClipBoard();
	
}

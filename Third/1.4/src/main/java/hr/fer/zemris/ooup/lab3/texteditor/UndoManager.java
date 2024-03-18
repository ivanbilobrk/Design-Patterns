package hr.fer.zemris.ooup.lab3.texteditor;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UndoManager {
	
	private Stack<EditAction> undoStack;
	private Stack<EditAction> redoStack;
	private static UndoManager undomanager;
	private List<UndoObserver> observers;
	
	private UndoManager() {
		super();
		
		undoStack = new Stack<>();
		redoStack = new Stack<>();
		observers = new ArrayList<>();
	}


	public static UndoManager getUndoManagerInstance() {
		if(undomanager == null) {
			undomanager = new UndoManager();
		}
		return undomanager;
	}


	public void undo() {
		if(!undoStack.isEmpty()) {
			EditAction action = undoStack.pop();
			action.execute_undo();
			redoStack.push(action);
			alertUndoObservers();
		}
		
	}
	
	public EditAction popRedoStack() {
		if(!redoStack.isEmpty()) return redoStack.pop();
		alertUndoObservers();
		return null;
	}
	
	public void pushUndo(EditAction c) {
		undoStack.push(c);
		alertUndoObservers();
	}
	
	public void push(EditAction c) {
		redoStack.removeAllElements();
		undoStack.push(c);
		alertUndoObservers();
	}
	
	public boolean isUndoEmpty() {
		return undoStack.isEmpty();
	}
	
	public boolean isRedoEmpty() {
		return redoStack.isEmpty();
	}
	
	public void clearAll() {
		undoStack = new Stack<>();
		redoStack = new Stack<>();
	}
	
	public void addUndoObserver(UndoObserver obs) {
		observers.add(obs);
	}
	
	public void removeUndoObservers(UndoObserver obs) {
		observers.remove(obs);
	}
	
	public void alertUndoObservers() {
		for(var x: observers) {
			x.managerChanged();
		}
	}
}

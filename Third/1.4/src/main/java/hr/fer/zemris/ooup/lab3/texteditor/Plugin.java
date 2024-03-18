package hr.fer.zemris.ooup.lab3.texteditor;

public interface Plugin {
	
	  String getName();
	  
	  String getDescription();
	  
	  void execute(TextModel model, UndoManager undoManager, ClipboardStack clipboardStack);
	  
}
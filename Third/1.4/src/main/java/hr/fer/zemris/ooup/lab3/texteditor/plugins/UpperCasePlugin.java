package hr.fer.zemris.ooup.lab3.texteditor.plugins;

import java.util.List;

import hr.fer.zemris.ooup.lab3.texteditor.ClipboardStack;
import hr.fer.zemris.ooup.lab3.texteditor.Plugin;
import hr.fer.zemris.ooup.lab3.texteditor.TextModel;
import hr.fer.zemris.ooup.lab3.texteditor.UndoManager;

public class UpperCasePlugin implements Plugin{
	

	@Override
	public String getName() {
		return "Uppercase";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Changes all first letters of words to uppercase letters.";
	}

	@Override
	public void execute(TextModel model, UndoManager undoManager, ClipboardStack clipboardStack) {
		
		List<String> lines = model.getLines();
		System.out.println("ee");
		
        for (int i = 0; i < lines.size(); i++) {
        	String newLine = "";
        	
        	String words[] = lines.get(i).split(" ");
        	
        	for(int j = 0; j < words.length; j++) {
        		String capitalized = words[j].substring(0, 1).toUpperCase() + words[j].substring(1);
        		if(j != words.length-1) {
        			capitalized+=" ";
        		}
        		newLine += capitalized;
        	}
        	
        	lines.set(i, newLine);
        }
        
        model.alertTextObservers();
		
		
	}

}
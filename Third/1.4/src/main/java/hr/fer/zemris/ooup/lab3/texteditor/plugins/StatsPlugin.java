package hr.fer.zemris.ooup.lab3.texteditor.plugins;

import java.util.Arrays;

import javax.swing.JOptionPane;

import hr.fer.zemris.ooup.lab3.texteditor.ClipboardStack;
import hr.fer.zemris.ooup.lab3.texteditor.Plugin;
import hr.fer.zemris.ooup.lab3.texteditor.TextModel;
import hr.fer.zemris.ooup.lab3.texteditor.UndoManager;

public class StatsPlugin implements Plugin{
	

	@Override
	public String getName() {
		return "Statistics";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Prints number of rows, words and characters.";
	}

	@Override
	public void execute(TextModel model, UndoManager undoManager, ClipboardStack clipboardStack) {
		int rowsNum = model.getLines().size();
		long wordsNum = model.getLines().stream().flatMap((line)->Arrays.stream(line.split(" "))).count();
		long charactersNum = model.getLines().stream().flatMapToInt((line)->line.chars()).count();
		
		String message = "Number of rows: "+rowsNum+", number of words: "+wordsNum+", number of characters: "+charactersNum;
		
		JOptionPane.showOptionDialog(null, message, "Statistics",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{"OK"}, "OK");
		
		
	}

}

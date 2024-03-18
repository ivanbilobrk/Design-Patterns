package hr.fer.zemris.ooup.lab3.texteditor;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class OpenMenuAction extends AbstractAction{
	

	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private TextModel model;

	public OpenMenuAction(String name, TextModel model, JFrame frame){
		super(name);
		this.model = model;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			JFileChooser fc = new JFileChooser();
			fc.setDialogTitle("Open File");
			
			if(fc.showOpenDialog(frame)!=JFileChooser.APPROVE_OPTION) {
				return;
			}
			
			File fileName = fc.getSelectedFile();
			Path filePath = fileName.toPath();
			List<String> lines = Files.readAllLines(filePath);
			
			model.setLines(lines);
			
			model.getCursorLocation().setX(0);
			model.getCursorLocation().setY(0);
			model.setSelectionRange(null);
			UndoManager.getUndoManagerInstance().clearAll();
			model.getClipBoard().deleteAllText();
			
			UndoManager.getUndoManagerInstance().alertUndoObservers();
			model.alertCursorObservers();
			model.alertTextObservers();
			
		} catch (IOException e1) {
			JOptionPane.showOptionDialog(frame, "Cannot open file", "File open failed",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{"OK"}, "OK");
		}
		
		
		
		
	}

}

package hr.fer.zemris.ooup.lab3.texteditor;

import java.awt.event.ActionEvent;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.*;

public class SaveMenuAction extends AbstractAction{
	
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private TextModel model;

	public SaveMenuAction(String name, TextModel model, JFrame frame){
		super(name);
		this.model = model;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			JFileChooser jfc = new JFileChooser();
			jfc.setApproveButtonText("Spremi");
			
			jfc.setDialogTitle("Save Document");
			
			if(jfc.showOpenDialog(frame)!=JFileChooser.APPROVE_OPTION) {
				return;
			}
			
			Path openedFilePath = jfc.getSelectedFile().toPath();
			
			if(!Files.exists(openedFilePath, LinkOption.NOFOLLOW_LINKS))
				new File(openedFilePath.toString()).createNewFile();
			
			BufferedWriter writer = Files.newBufferedWriter(openedFilePath, LinkOption.NOFOLLOW_LINKS);
			
            for (String item : model.getLines()) {
                writer.write(item);
                writer.write("\n");
            }
            writer.close();
			
		} catch(Exception exc) {
			JOptionPane.showOptionDialog(frame, "Cannot save file", "File save failed",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{"OK"}, "OK");
		}
		
	}

}

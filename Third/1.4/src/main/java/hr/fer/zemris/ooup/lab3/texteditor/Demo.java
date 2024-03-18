package hr.fer.zemris.ooup.lab3.texteditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Demo extends JFrame{
	private static final long serialVersionUID = 1L;
	
	Demo() throws IOException{
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(500,500);
		initGUI();
	}
	
	
	
	private void initGUI() throws IOException {
		
		
		
		TextModel model = new TextEditorModel("Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n"
				+ "Sed ut velit sed augue convallis scelerisque.\n"
				+ "Praesent euismod sapien ac convallis consequat.\n"
				+ "Phasellus vel ipsum eget mi commodo tincidunt. Fusce eu risus quis elit ultrices feugiat sed vel libero. \n"
				+ "Quisque interdum bibendum risus vel gravida.\n"
				+ "Curabitur vel consectetur urna. Vestibulum non enim at est fringilla consectetur.\n"
				+ "Donec eu mauris eu leo scelerisque efficitur ut nec nunc. Morbi et ipsum vel dolor dignissim pharetra. \n"
				+ "Cras vulputate diam ut elit ultrices imperdiet. Proin sed venenatis tellus.", new MyClipboardStack());
		
		UndoAction undoAction = new UndoAction("Undo");
		UndoManager.getUndoManagerInstance().addUndoObserver(undoAction);
		RedoAction redoAction = new RedoAction("Redo");
		UndoManager.getUndoManagerInstance().addUndoObserver(redoAction);
		CutAction cutAction = new CutAction("Cut", model);
		model.addTextObserver(cutAction);
		CopyAction copyAction = new CopyAction("Copy", model);
		model.addTextObserver(copyAction);
		PasteAction pasteAction = new PasteAction("Paste", model);
		model.getClipBoard().addClipboardObserver(pasteAction);
		PasteTakeAction pasteTakeAction = new PasteTakeAction("Paste and Take", model);
		model.getClipBoard().addClipboardObserver(pasteTakeAction);
		DeleteSelectionAction deleteSelectionAction = new DeleteSelectionAction("Delete selection", model);
		model.addTextObserver(deleteSelectionAction);
		ClearDocumentAction clearDocumentAction = new ClearDocumentAction("Clear document", model);
		model.addTextObserver(clearDocumentAction);
		MoveCursorStartAction moveCursorStartAction = new MoveCursorStartAction("Move Cursor Start", model);
		MoveCursorEndAction moveCursorEndAction = new MoveCursorEndAction("Move Cursor End", model);
		
		
		TextEditor editor = new TextEditor(model, this, undoAction, redoAction, cutAction, copyAction, pasteAction, pasteTakeAction, deleteSelectionAction);
		
		this.getContentPane().setLayout(new BorderLayout());
		
		JMenuBar menubar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		menubar.add(fileMenu);
		
		JMenuItem openItem = new JMenuItem(new OpenMenuAction("Open new file", model, this));
		fileMenu.add(openItem);
		
		
		JMenuItem saveItem = new JMenuItem(new SaveMenuAction("Save file", model, this));
		fileMenu.add(saveItem);
		
		JMenuItem exitItem = new JMenuItem(new AbstractAction("Exit") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Demo.this.dispose();
				
			}
		});
		fileMenu.add(exitItem);
		
		JMenu fileEdit = new JMenu("Edit");
		menubar.add(fileEdit);
		
		JMenuItem undoItem = new JMenuItem(undoAction);
		fileEdit.add(undoItem);
		
		JMenuItem redoItem = new JMenuItem(redoAction);
		fileEdit.add(redoItem);
		
		JMenuItem cutItem = new JMenuItem(cutAction);
		fileEdit.add(cutItem);
		
		JMenuItem copyItem = new JMenuItem(copyAction);
		fileEdit.add(copyItem);
		
		JMenuItem pasteItem = new JMenuItem(pasteAction);
		fileEdit.add(pasteItem);
		
		JMenuItem pasteTakeItem = new JMenuItem(pasteTakeAction);
		fileEdit.add(pasteTakeItem);
		
		JMenuItem deleteSelectionItem = new JMenuItem(deleteSelectionAction);
		fileEdit.add(deleteSelectionItem);
		
		JMenuItem clearDocumentItem = new JMenuItem(clearDocumentAction);
		fileEdit.add(clearDocumentItem);
		
		JMenu move = new JMenu("Move");
		menubar.add(move);
		
		JMenuItem moveCursorStartItem = new JMenuItem(moveCursorStartAction);
		move.add(moveCursorStartItem);
		
		JMenuItem moveCursorEndItem = new JMenuItem(moveCursorEndAction);
		move.add(moveCursorEndItem);
		
		JMenu plugins = new JMenu("Plugins");
		menubar.add(plugins);
		
        Path startingDir = Paths.get("/home/ivan/Desktop/labosi/labosi/OOUP/Treci/1.4/src/main/java/hr/fer/zemris/ooup/lab3/texteditor/plugins");
        
        Files.walkFileTree(startingDir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".java")) {
                	String pluginName = file.getFileName().toString().split(".java")[0];
            		try {
            			Class<Plugin> clazz = null;
            			clazz = (Class<Plugin>)Class.forName("hr.fer.zemris.ooup.lab3.texteditor.plugins."+pluginName);
            			Constructor<?> ctr = clazz.getConstructor();
            			
            			Plugin p = (Plugin)ctr.newInstance();
            		
            			
            			JMenuItem item = new JMenuItem(new AbstractAction(p.getName()) {
            				
            				private static final long serialVersionUID = 1L;

							@Override
            				public void actionPerformed(ActionEvent e) {
            					p.execute(model, UndoManager.getUndoManagerInstance(), model.getClipBoard());
            					
            				}
            			});
            			
            			plugins.add(item);
            			
            		} catch (Exception e) {
            			System.out.println("Error loading plugins.");
            		} 
                	
                }
                return FileVisitResult.CONTINUE;
            }
        });
		
		JToolBar toolBar = new JToolBar("Tools");
		toolBar.setFloatable(true);
		toolBar.add(new JButton(undoAction));
		toolBar.add(new JButton(redoAction));
		toolBar.add(new JButton(cutAction));
		toolBar.add(new JButton(copyAction));
		toolBar.add(new JButton(pasteAction));
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(editor, BorderLayout.CENTER);
		panel.add(menubar, BorderLayout.PAGE_START);
		
		String labelText = "Line: "+model.getCursorLocation().getY()+", column: "+model.getCursorLocation().getX()+", lines total: "+model.getLines().size();
		JLabel label = new JLabel(labelText);
		
		model.addCursorObserver(new CursorObserver() {
			
			@Override
			public void updateCursorLocation(Location loc) {
				label.setText("Line: "+model.getCursorLocation().getY()+", column: "+model.getCursorLocation().getX()+", lines total: "+model.getLines().size());
			}
		});
		
		model.addTextObserver(new TextObserver() {
			
			@Override
			public void updateText() {
				label.setText("Line: "+model.getCursorLocation().getY()+", column: "+model.getCursorLocation().getX()+", lines total: "+model.getLines().size());
				
			}
		});
		
		label.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.GRAY));
		
		this.getContentPane().add(panel, BorderLayout.CENTER);
		this.getContentPane().add(toolBar, BorderLayout.PAGE_START);
		this.getContentPane().add(label, BorderLayout.PAGE_END);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			try {
				new Demo().setVisible(true);
			} catch (IOException e) {
				System.out.println("Error while displaying text editor.");
			}
		});
	}

}

package hr.fer.zemris.ooup.lab3.texteditor;

import java.util.ArrayList;
import java.util.List;

public class DeleteRangeAction implements EditAction{
	
	private Location cursorLocation;
	private List<String> lines;
	private TextModel model;
	boolean multipleRowDelete;
	private LocationRange r;
	private List<String> linesRemoved;
	
	public DeleteRangeAction(TextModel model, LocationRange r) {
		this.r = new LocationRange(r.getL1(), r.getL2());
		this.model = model;
		this.cursorLocation = new Location(model.getCursorLocation().getX(), model.getCursorLocation().getY());
		this.lines = model.getLines();
	}

	@Override
	public void execute_do() {
		if(r == null) return;
		
		Location loc1 = r.getL1();
		Location loc2 = r.getL2();
		
		int y1 = r.getL1().getY();
		int y2 = r.getL2().getY();
		linesRemoved = new ArrayList<>();
		
		if(y1 != y2) {
			
			String firstLine = lines.get(loc1.getY());
			String lastLine = lines.get(loc2.getY());
			
			firstLine = firstLine.substring(0, loc1.getX());
			lastLine = lastLine.substring(loc2.getX());
			
			
			for(int i = loc1.getY(); i <= loc2.getY(); i++) {
				linesRemoved.add(lines.get(loc1.getY()));
				lines.remove(loc1.getY());
			}
			
			lines.add(loc1.getY(), firstLine+lastLine);

			
		} else {
			String line = lines.get(loc1.getY());
			linesRemoved.add(line);
			lines.remove(loc1.getY());
			
			line = line.substring(0, loc1.getX()) + line.substring(loc2.getX());
			lines.add(loc1.getY(), line);
			

		}
		
		
		model.getCursorLocation().setX(loc1.getX());
		model.getCursorLocation().setY(loc1.getY());
		model.alertCursorObservers();
		
		model.setSelectionRange(null);
		
	}

	@Override
	public void execute_undo() {
		if(linesRemoved != null) {
			int y = r.getL1().getY();
			lines.remove(y);
			
			for(int i = 0; i < linesRemoved.size(); i++) {
				lines.add(y+i, linesRemoved.get(i));
			}
			
			model.getCursorLocation().setX(cursorLocation.getX());
			model.getCursorLocation().setY(cursorLocation.getY());
			
			model.alertTextObservers();
			model.alertCursorObservers();
		}
		
	}
	
}

package hr.fer.zemris.ooup.lab3.texteditor;
import java.util.function.BiConsumer;

public class ArrowFunction{
	
	private BiConsumer<TextModel, Location> customAction;
	private TextModel model;
	
	public ArrowFunction(TextModel model, BiConsumer<TextModel, Location> customAction) {
		super();
		this.model = model;
		this.customAction = customAction;
	}

	public void doAction(boolean shift, Location oldCursor) {
		if(shift) {
			
			if(model.getSelectionRange() == null) {
				
				model.setSelectionRange(new LocationRange(oldCursor , model.getCursorLocation()));
			} else {
				customAction.accept(model, oldCursor);
				LocationRange selection = model.getSelectionRange();
				if(selection.getL1().equals(selection.getL2())) {
					model.setSelectionRange(null);
					
				} else {
					
					
				}
				
			}
		} else {
			model.setSelectionRange(null);
		}
		model.alertTextObservers();
	}

}
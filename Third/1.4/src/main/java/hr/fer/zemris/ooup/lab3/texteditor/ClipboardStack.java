package hr.fer.zemris.ooup.lab3.texteditor;

public interface ClipboardStack {
	
	public void pushText(String text);
	
	public String popText();
	
	public String peek();
	
	public boolean hasText();
	
	public void deleteAllText();
	
	public void addClipboardObserver(ClipboardObserver cobs);
	
	public void removeClipboardObserver(ClipboardObserver cobs);
	
	public void alertClipboardObservers();
	
}

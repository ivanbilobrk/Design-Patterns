package hr.fer.zemris.ooup.lab3.texteditor;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MyClipboardStack implements ClipboardStack{
	
	private Stack<String> stack;
	private List<ClipboardObserver> clipboardobservers;
	
	public MyClipboardStack() {
		super();
		this.stack = new Stack<>();
		this.clipboardobservers = new ArrayList<>();
	}

	@Override
	public void pushText(String text) {
		stack.push(text);
		alertClipboardObservers();
		
	}

	@Override
	public String popText() {
		String popped = stack.pop();
		alertClipboardObservers();
		return popped;
	}

	@Override
	public String peek() {
		return stack.peek();
	}

	@Override
	public boolean hasText() {
		return !stack.empty();
	}

	@Override
	public void deleteAllText() {
		stack.removeAllElements();
		alertClipboardObservers();
	}

	@Override
	public void addClipboardObserver(ClipboardObserver cobs) {
		clipboardobservers.add(cobs);
	}

	@Override
	public void removeClipboardObserver(ClipboardObserver cobs) {
		clipboardobservers.remove(cobs);
	}

	@Override
	public void alertClipboardObservers() {
		for(var x: clipboardobservers) {
			x.updateClipboard();
		}
	}
	

}

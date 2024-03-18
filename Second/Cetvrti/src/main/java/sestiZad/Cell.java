package sestiZad;

import java.util.ArrayList;
import java.util.List;

/**
 * Konkretna implementacija jedne celije
 *
 */
public class Cell implements CellAll{
	private String exp;
	private double value;
	private Sheet sheet;
	private List<CellListener> listeners;
	
	
	public Cell(String exp, Sheet sheet) {
		super();
		this.exp = exp;
		this.sheet = sheet;
		this.listeners = new ArrayList<>();
	}
	
	public void setExp(String exp) {
		this.exp = exp;
	}
	
	public void attach(CellListener cell) {
		listeners.add(cell);
	}
	
	public void dettach(CellListener cell) {
		listeners.remove(cell);
	}
	
	public void notifyListeners() {
		for(var x: listeners) {
			x.update();
		}	
	}
	
	public void update() {
		setValue(sheet.evaluate(this));
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
		notifyListeners();
	}
	
	public String getExp() {
		return exp;
	}
	
}

package sestiZad;

/**
 * Apstraktni razred za definiranje metoda koje jedan cell mora imati.
 *
 */
public interface AbstractCell {
	
	public abstract void setExp(String exp);
	
	public abstract void attach(CellListener cell);
	
	public abstract void dettach(CellListener cell);
	
	public abstract void notifyListeners();
	
	public abstract double getValue();
	
	public abstract void setValue(double value);
	
	public abstract String getExp();
}

package sestiZad;

import java.util.ArrayList;
import java.util.List;

/**
 * Sheet razred koji interno pohranjuje Cell objekte te nudi metodu za racunanje izraza i dodavanje novih Cell objekata.
 * Razred radi s Cell objektima preko reference na apstraktni razred CellAll
 *
 */
public class Sheet {
	private CellAll[][] cells;
	private int rows, columns;
	
	public Sheet(CellAll[][] cells) {
		super();
		this.rows = cells.length;
		this.columns = cells[0].length;
		
		this.cells = cells;
	}
	
	public CellAll cell(String ref) {
		int row = getRow(ref);
		int column = getColumn(ref);
		
		if(row >= rows || column >= columns) {
			throw new IllegalArgumentException("Out of bounds indexes for cell.");
		}
		
		return cells[row][column];
		
	}
	
	public void set(String ref, String content) {
				
		CellAll c = cell(ref);
		int row = getRow(ref);
		int column = getColumn(ref);
		if(c != null) {
			c.setExp(content);

			List<CellAll> oldCells = getrefs(c);
				
			for(var x: oldCells) {
				x.dettach(c);
			}
			
		} else {
			c = new Cell(content, this);
			cells[row][column] = c;
		}
		
		for(var x: getrefs(c)) {
			x.attach(c);
		}
		
		if(checkCyclicity(ref, c)) throw new Ciklicnost("Ciklicnost");
		c.setValue(evaluate(c));
	}
	
	public List<CellAll> getrefs(CellAll cell){
		List<CellAll> cellsRef = new ArrayList<>();
		
		String[] temp = cell.getExp().split("\\+");
		
		for(var x: temp) {
			if(Character.isAlphabetic(x.charAt(0))) {
				int row = getRow(x);
				int column = getColumn(x);
				cellsRef.add(cells[row][column]);
			}
		}
		return cellsRef;
	}
	
	private boolean checkCyclicity(String ref, CellAll c2) {
		for(var x: getrefs(c2)) {
			
			if(x == cell(ref)) {
				return true;
			}
			return checkCyclicity(ref, x);
		}
		return false;
	}
	
	private static int getRow(String ref) {
		return ref.charAt(0)-'A';
	}
	
	private static int getColumn(String ref) {
		return Integer.parseInt(ref.substring(1));
	}
	
	public double evaluate(CellAll cell) {
		double result = 0;
		
		for(var x: cell.getExp().split("\\+")) {
			if(!Character.isAlphabetic(x.charAt(0))) 
				result += Double.parseDouble(x);
		}
		
		for(var x: getrefs(cell)) {
			result += x.getValue();
		}
		
		return result;
	}
	
	private String getCellName(int i, int j) {
		String res = String.valueOf((char)('A'+i));
		res += j;
		return res;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				CellAll c = cells[i][j];
				if(c != null) {
					sb.append("Cell name: "+getCellName(i, j)+", cell expression: "+c.getExp()+", cell value: "+c.getValue()+"\n");
				}
			}
		}
		return sb.toString();
	}
	
}	

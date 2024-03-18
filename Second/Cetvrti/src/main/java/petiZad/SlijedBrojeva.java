package petiZad;

import java.util.ArrayList;
import java.util.List;

/**
 * Komponenta slijed brojeva koja pamti trenutno generirane brojeve od strane izvora brojeva u internoj kolekciji te svaki put prilikom dobivanja 
 * novog broja obavijesti sve promatrace kako bi se mogli azurirati 
 *
 */
public class SlijedBrojeva {
	private List<Integer> numbers;
	private IzvorBrojeva izvor;
	private List<AkcijaBrojevi> akcije;

	public SlijedBrojeva(IzvorBrojeva izvor) {
		numbers = new ArrayList<>();
		this.izvor = izvor;
		this.akcije = new ArrayList<>();
	}
	
	public void kreni() throws InterruptedException {
		
		int numberFromSource = -1;
		do {
			numberFromSource = izvor.getNextNumber();
			System.out.println(numberFromSource);
			numbers.add(numberFromSource);
			
			if(numberFromSource != -1) {
				notifyObservers();
			}
			Thread.sleep(1000);
		}while(numberFromSource != -1);
	}
	
	public void attach(AkcijaBrojevi akcija) {
		akcije.add(akcija);
	}
	
	public void dettach(AkcijaBrojevi akcija) {
		akcije.remove(akcija);
	}
	
	private void notifyObservers() {
		for(var x: akcije) {
			x.update();
		}
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
	
}

package petiZad;

import java.util.Collections;
import java.util.List;

/**
 * Konkretna implementacija akcije koja na zaslon ispisuje medijan trenutnih brojeva u kolekciji
 *
 */
public class MedijanAkcija extends AkcijaBrojevi{

	public MedijanAkcija(SlijedBrojeva slijed) {
		super(slijed);
	}

	@Override
	public void update() {
		List<Integer> numbers = super.slijed.getNumbers();
		Collections.sort(numbers);
		
		double medijan;
		
		if(numbers.size() == 0) {
			medijan = 0;
		}else if(numbers.size() % 2 == 1) {
			medijan = numbers.get(numbers.size()/2);
		} else {
			int p1 = numbers.size()/2;
			int p2 = p1-1;
			medijan = ((double)numbers.get(p1)+(double)numbers.get(p2))/2;
		}
		
		System.out.println("Medijan je "+medijan);
		
	}

}

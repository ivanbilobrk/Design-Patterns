package petiZad;

/**
 * Konkretna implementacija akcije koja na zaslon ispisuje prosjek trenutnih brojeva u kolekciji
 *
 */
public class ProsjekAkcija extends AkcijaBrojevi{

	public ProsjekAkcija(SlijedBrojeva slijed) {
		super(slijed);
	}

	@Override
	public void update() {
		double average = super.slijed.getNumbers().stream().mapToInt(Integer::intValue).average().getAsDouble();
		
		System.out.println("Aritmetička sredina je "+average);
		
	}

}

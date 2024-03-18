package petiZad;

/**
 * Konkretna implementacija akcije koja na zaslon ispisuje sumu trenutnih brojeva u kolekciji
 *
 */
public class SumaAkcija extends AkcijaBrojevi{
	
	public SumaAkcija(SlijedBrojeva slijed) {
		super(slijed);
	}

	@Override
	public void update() {
		int sum = super.slijed.getNumbers().stream().mapToInt(Integer::intValue).sum();
		
		System.out.println("Suma brojeva je "+sum);
		
	}

}

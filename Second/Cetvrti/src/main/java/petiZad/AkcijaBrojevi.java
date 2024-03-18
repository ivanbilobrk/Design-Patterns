package petiZad;

/**
 * Apstraktni razred koji govori koje metode mora jedna akcija za brojeve imati.
 *
 */
public abstract class AkcijaBrojevi {
	
	protected SlijedBrojeva slijed;
	
	public AkcijaBrojevi(SlijedBrojeva slijed) {
		super();
		this.slijed = slijed;
	}

	//metoda update koja se zove kad subjekt obavijesti akciju da je doslo do neke promjene stanja subjekta
	//na ovaj nacin subjekt obavijesti akciju da je promjena stanja mozda uzrokovala to da se mora poduzeti neka radnja
	public abstract void update();
}

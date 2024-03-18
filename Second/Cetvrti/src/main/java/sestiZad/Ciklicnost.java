package sestiZad;

/**
 * Iznimka koja se baca u slucaju ciklicne ovisnosti
 *
 */
public class Ciklicnost extends RuntimeException{
	private String message;
	
	

	public Ciklicnost(String message) {
		super();
		this.message = message;
	}



	private static final long serialVersionUID = 1L;
}

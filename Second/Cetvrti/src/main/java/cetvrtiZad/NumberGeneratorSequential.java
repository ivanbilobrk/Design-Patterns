package cetvrtiZad;

/**
 * Razred koji generira polje cijelih brojeva trazene duljine na nacin da mu u konstruktor predamo pocetni broj, zavrsni broj te razmak izmedu njih.
 * Ovaj razred je konkretna implementacija osnovnog razreda generatora brojeva.
 */
public class NumberGeneratorSequential extends NumberGenerator{
	
	private int min, max, step;

	public NumberGeneratorSequential(int min, int max, int step) {
		super();
		this.min = min;
		this.max = max;
		this.step = step;
	}



	@Override
	int[] generate() {
		int[] numbers = new int[max-min+1];
		
		int j = 0;
		for(int i = min; i <= max; i+=step) {
			numbers[j++] = i;
		}
		return numbers;
	}
	
}

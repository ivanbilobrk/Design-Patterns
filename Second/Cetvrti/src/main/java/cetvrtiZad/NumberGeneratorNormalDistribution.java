package cetvrtiZad;

/**
 * Razred koji generira polje cijelih brojeva trazene duljine u skladu s zeljenim parametrima normalne distribucije (standardna devijacija i srednja vrijednost). 
 * Parametre, ukljucujuci i zeljenu duljinu predajemo konstruktoru.
 * Ovaj razred je konkretna implementacija osnovnog razreda generatora brojeva.
 */
import java.util.Arrays;
import java.util.Random;

public class NumberGeneratorNormalDistribution extends NumberGenerator {
	
	private double mean, standardDeviation;
	private int n;
	
	public NumberGeneratorNormalDistribution(double mean, double standardDeviation, int n) {
		super();
		this.mean = mean;
		this.standardDeviation = standardDeviation;
		this.n = n;
	}

	@Override
	int[] generate() {
		Random rnd = new Random();
		int[] numbers = new int[n];
		
		for(int i = 0; i < n; i++) {
			numbers[i] = (int)(rnd.nextGaussian()*standardDeviation+mean);
		}
		
		//sortiranje polja jer nam treba sortirano polje za racunanje percentila
		Arrays.sort(numbers);
		return numbers;
	}

}	

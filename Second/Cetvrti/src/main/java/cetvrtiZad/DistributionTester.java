package cetvrtiZad;

/**
 * 
 * Razred koji moze generirati na zeljeni nacin polje brojeva trazene duljine te za polje cijelih brojeva izracunati percentil prema zeljenoj metodi racunanja.
 * U konstruktoru razreda predajemo mu zeljeni nacin generiranja brojeva i nacin izracuna percentila tako da mu predamo reference na osnovne razrede konkretnih postupaka.
 * Ovo je u skladu sa OO strategija.
 *
 */
public class DistributionTester {
	
	private NumberGenerator generator;
	private CalculatePercentile percentile;
	
	public DistributionTester(NumberGenerator generator, CalculatePercentile percentile) {
		super();
		this.generator = generator;
		this.percentile = percentile;
	}

	public void setGenerator(NumberGenerator generator) {
		this.generator = generator;
	}

	public void setPercentile(CalculatePercentile percentile) {
		this.percentile = percentile;
	}
	
	public int[] generateArray() {
		return generator.generate();
	}
	
	public double getPercentile(int p, int[] numbers) {
		return percentile.getPercentile(numbers, p);
	}
	
}

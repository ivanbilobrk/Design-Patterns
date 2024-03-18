package cetvrtiZad;

/**
 * Razred koji implementira nacin racunanja percentila kao kao element ciji je polozaj u sortiranom nizu (pocevsi od 1) najblizi polozaju percentila n_p
 * Ovaj razred je konkretna implementacija osnovnog razreda za racunanje percentila.
 *
 */
public class PercentileNearestRank extends CalculatePercentile{

	@Override
	public double getPercentile(int[] numbers, int p) {
		int position = (int)(Math.ceilDiv(p*numbers.length, 100))-1;
		return numbers[position];
	}

}

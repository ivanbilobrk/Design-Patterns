package cetvrtiZad;

/**
 * Razred koji implementira nacin racunanja percentila kao interpoliranu vrijednost izmedu elemenata polja: v[i] i v[i+1]
 * Ovaj razred je konkretna implementacija osnovnog razreda za racunanje percentila.
 *
 */
public class PercentileInterpolation extends CalculatePercentile{

	@Override
	public double getPercentile(int[] numbers, int p) {
		
		if(!(p >= 0 && p <= 100))
			throw new IllegalArgumentException("Percentil mora biti veci od 0 i manji od 100.");
		
		if(numbers.length == 1) {
			return numbers[0];
		} 
		
		if(numbers.length == 0) {
			return 0;
		}
		
		int n = numbers.length;
		
		double pv1 = calculatePercentilePosition(0, n);
		double pv2 = calculatePercentilePosition(n-1, n);
		
		if(p < pv1)
			return numbers[0];
		if(p > pv2)
			return numbers[n-1];
		
		for(int i = 0; i < n; i++) {
			if(i+1 < numbers.length) {
				double p1 = calculatePercentilePosition(i, n);
				double p2 = calculatePercentilePosition(i+1, n);
				
				if(p >= p1 && p <= p2) {
					return (double)numbers[i] + (double)n*((double)p-(double)p1)*((double)numbers[i+1]-(double)numbers[i])/100;
				}
			}
		}
		return 0;
	}
	
	public static double calculatePercentilePosition(int i, int n) {
		return 100*((double)i+1-0.5)/(double)n;
	}
	
}

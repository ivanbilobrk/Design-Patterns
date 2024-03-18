package cetvrtiZad;

/**
 * Razred koji implementira jedan generator brojeva tako da vraca polje cijelih brojeva trazene duljine u skladu prema fibonaccijevim algoritmom.
 * Ovaj razred je konkretni postupak koji izvodi osnovni razred.
 *
 */
public class NumberGeneratorFibonacci extends NumberGenerator{

	int n;
	
	public NumberGeneratorFibonacci(int n) {
		super();
		this.n = n;
	}


	@Override
	int[] generate() {
		int[] numbers = new int[n];
		
		for(int i = 0; i < n; i++) {
			if(i == 0) numbers[i] = 0;
			else if(i == 1) numbers[i] = 1;
			else numbers[i] = numbers[i-2]+numbers[i-1];
		}
		
		return numbers;
	}

}

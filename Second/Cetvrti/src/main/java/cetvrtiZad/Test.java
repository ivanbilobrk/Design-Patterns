package cetvrtiZad;

public class Test {

	public static void main(String[] args) {
		NumberGenerator gen = new NumberGeneratorFibonacci(5);
		CalculatePercentile percentileCalc1 = new PercentileNearestRank();
		CalculatePercentile percentileCalc2 = new PercentileInterpolation();
		
		DistributionTester tester = new DistributionTester(gen, percentileCalc2);
		
		int[] numbers = tester.generateArray();
		
		printResults(numbers, tester);
		
		
		tester.setGenerator(new NumberGeneratorNormalDistribution(10, 20, 15));
		numbers = tester.generateArray();
		printResults(numbers, tester);
		
		tester.setGenerator(new NumberGeneratorSequential(2,16, 3));
		numbers = tester.generateArray();
		printResults(numbers, tester);

	}
	
	public static void printResults(int[] numbers, DistributionTester tester) {
		System.out.print("Numbers array: ");
		
		for(var x: numbers) {
			System.out.print(x+" ");
		}
		System.out.println();
		for(int i = 10; i <= 90; i+=10) {
			System.out.print(tester.getPercentile(i, numbers)+" ");
		}
		System.out.println();
	}

}

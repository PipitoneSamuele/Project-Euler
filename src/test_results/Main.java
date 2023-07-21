package test_results;

import implementation.Solutions;

public class Main {

	public static void main(String[] args) {
		
		Solutions solution = new Solutions();
		double startTime = System.nanoTime();
	
		//1) Multiples of 3 and 5
		//System.out.println("1) " + solution.multiplesOf3And5(1000) + "\n");

		//2) Even fibonacci
		//System.out.println("2) " + solution.evenFibonacci(1, 1, 4000000, 0) + "\n");

		//3) Largest prime factor
		//System.out.println("2) " + solution.largestPrimeFactor(600851475143L) + "\n");

		//4) Largest palindrome product
		//System.out.println(solution.isPalindromeProduct() + "\n");

		//5) Smallest multiple
		//System.out.println(solution.smallestMultiple() + "\n");

		//6) Sum square difference
		//System.out.println(solution.sumSquareDifference() + "\n");

		//7) 10001st prime
		//System.out.println(solution.tenThousOneThPrime(10001) + "\n");

		//8) Largest product in a series
		//System.out.println(solution.largestProductInSeries() + "\n");

		//9) Special pythagorean triplet
		//System.out.println(solution.pythagoreanTriplet() + "\n");

		//10) Special pythagorean triplet
		//System.out.println(solution.sumPrime(2000000) + "\n");

		/**11) Largest product ina  grid  - IMPO - check commento nel codice */
		//System.out.println(solution.largestProductInGrid() + "\n");

		/**12) Highly divisible triangular number  -  IMPO  - perchè radice quadrata? */
		System.out.println(solution.divisibleTriangularNumber() + "\n");

		//print out the exec time
		double endTime   = System.nanoTime();
		double totalTime = endTime - startTime;
		System.out.println(totalTime / 1000000000 + " sec");
	}
}
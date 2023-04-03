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
		//System.out.println("2) " + solution.largestPrimeFactor() + "\n");

		System.out.println(solution.largestPrimeFactor(600851475143L));

		//print out the exec time
		double endTime   = System.nanoTime();
		double totalTime = endTime - startTime;
		System.out.println(totalTime / 1000000000 + " sec");
	}
}

package test_results;

import implementations.Solutions;

public class Main {

	public static void main(String[] args) {
		
		Solutions solution = new Solutions();
	
		//1) Multiples of 3 and 5
		System.out.println("1) " + solution.multiplesOf3And5(1000) + "\n"); 
		
		//2) Even Fibonacci numbers
		System.out.println("2) " + solution.evenFibonacci(1, 0, 0, 0) + "\n"); 
	}

}

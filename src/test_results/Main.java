package test_results;

import implementations.Solutions;

public class Main {

	public static void main(String[] args) {
		
		Solutions solution = new Solutions();
		double startTime = System.nanoTime();
	
		//1) Multiples of 3 and 5
		//System.out.println("1) " + solution.multiplesOf3And5(1000) + "\n"); 
		
		//2) Even Fibonacci numbers
		//System.out.println("2) " + solution.evenFibonacci(1, 0, 0, 0) + "\n"); 
		
		//3) Largest prime factor
		//System.out.println("3) " + solution.largestPrimeFactor(600851475143L) + "\n"); 
		
		//4) Largest palindrome product
		//System.out.println("4) " + solution.largestPalindromeProduct()+ "\n");
		
		//5) Smallest multiple
		//System.out.println("5) " + solution.smallestMultiple()+ "\n");
		
		//6) Sum square difference
		//System.out.println("6) " + solution.sumSquareDifference(100)+ "\n");
		
		//7) 10001th prime
		//System.out.println("7) " + solution.nthPrime(10001));
		
		//8) Largest product in a series
		//System.out.println("8) " + solution.largestInASeries(13));
		
		//9) Special Pythagorean triplet
		//System.out.println("9) " + solution.specialPythagorean());
		
		//10) Summation of primes
		System.out.println("10) " + solution.summationOfPrime(2000000));
		
		//print out the exec time
		double endTime   = System.nanoTime();
		double totalTime = endTime - startTime;
		System.out.println(totalTime / 1000000000);
	}
}

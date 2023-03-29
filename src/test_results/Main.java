package test_results;

import java.io.IOException;

import implementation.Solutions;
import utility.Fraction;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Solutions solution = new Solutions();
		double startTime = System.nanoTime();
	
		//1) Multiples of 3 and 5
		System.out.println("1) " + solution.multiplesOf3And5(1000) + "\n");


		//print out the exec time
		double endTime   = System.nanoTime();
		double totalTime = endTime - startTime;
		System.out.println(totalTime / 1000000000 + " sec");
	}
}

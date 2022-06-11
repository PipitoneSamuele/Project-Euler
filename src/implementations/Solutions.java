package implementations;

public class Solutions {
	
	final int MAXFIBONACCI = 4000000;

	public Solutions() {}
	
	//1)------------------------------------------------------------------------------------------------------------------
	public int multiplesOf3And5(int n) {
		
		int count = 0;
		
		//bruteforce
		for(int i = 3; i < n; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				count += i;
			}
		}
		return count;
	}
	
	//2) ----------------------------------------------------------------------------------------------------------------
	public int evenFibonacci(int fibonacci, int fibonacciPrev, int fibonacciHold, int sum) {
		
		if(fibonacci > MAXFIBONACCI) {
			return sum;
		}
		
		if(fibonacci % 2 == 0) {
			sum += fibonacci;
		}
		
		fibonacciHold = fibonacci;
		
		return evenFibonacci((fibonacci+fibonacciPrev), fibonacciHold, 0, sum);
	}
	
	
}

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
	
	//3) ----------------------------------------------------------------------------------------------------------------
	public boolean isPrime(long n) {
		
		if(n == 1 || n == 2) {
			return true;
		}
		
		for(int i = 3; i < Math.floor(n / 2); i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public long largestPrimeFactor(long max) {
		
		long maxPrime = 0;
		int tooLong = 0;
		
		for(long i = 1; i < Math.floor(max / 2); i++) {
			if(isPrime(i) && max % i == 0 && i > maxPrime) {
				maxPrime = i;
				tooLong = 0;
			} else {
				tooLong++;
			}
			i++;
			//if for 100000 iteration the number stay the same i return it
			if(tooLong > 100000) {
				return maxPrime;
			}
		}
		
		return maxPrime;
	}
	
	//4) ----------------------------------------------------------------------------------------------------------------
	public boolean isPalindrome(int n) {
		String isPalindrome = Integer.toString(n);
		
		for(int i = 0; i < isPalindrome.length(); i++) {
			if(isPalindrome.charAt(i) != isPalindrome.charAt(isPalindrome.length() - 1 - i)) {
				return false;
			}
		}
		
		return true;
	}
	
	public int largestPalindromeProduct() {
		
		int ret = 0;
		int product = 0;
		
		for(int i = 100; i < 999; i++) {
			for(int j = 100; j < 999; j++) {
				product = i*j;
				if(isPalindrome(product) && ret < product) {
					ret = product;
				}
			}
		}
		
		return ret;
	}
	
	//5) ----------------------------------------------------------------------------------------------------------------
	public int smallestMultiple() {
		
		int ret = 1;
		
		//super ugly but works
		while(
				ret % 2 != 0 ||
				ret % 3 != 0 ||
				ret % 4 != 0 ||
				ret % 5 != 0 ||
				ret % 6 != 0 ||
				ret % 7 != 0 ||
				ret % 8 != 0 ||
				ret % 9 != 0 ||
				ret % 10 != 0 ||
				ret % 11 != 0 ||
				ret % 12 != 0 ||
				ret % 13 != 0 ||
				ret % 14 != 0 ||
				ret % 15 != 0 ||
				ret % 16 != 0 ||
				ret % 17 != 0 ||
				ret % 18 != 0 ||
				ret % 19 != 0 ||
				ret % 20 != 0 
				) {
			ret++;
		}
		
		return ret;
	}
	
	//6) ----------------------------------------------------------------------------------------------------------------
	public int sumSquareDifference(int n) {
		
		int sumOfSquare = 0;
		int squareOfSum = 0;
		
		for(int i = 1; i <= n; i++) {
			sumOfSquare += (i*i);
		}
		
		for(int j = 1; j <= n; j++) {
			squareOfSum += j;
		}
		
		squareOfSum = squareOfSum*squareOfSum;

		if(sumOfSquare < squareOfSum) {
			return squareOfSum - sumOfSquare;
		} else {
			return sumOfSquare - squareOfSum;
		}
	}
	
	
	
}

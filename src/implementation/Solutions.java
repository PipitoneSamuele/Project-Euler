package implementation;

public class Solutions {

	/**-----------------------------------------------------------------------------------------------------------------
	 * 1) multiple of 3 or 5
	 * pretty bad but linear time of execution -> O(n)
	 *
	 * @param n: number of iteration
	 * @return count
	 */
	public int multiplesOf3And5(int n) {

		int count = 0;

		for(int i = 0; i < n; i++) {
			if(i % 3 == 0 || i % 5 == 0)
				count = count + i;
		}
		return count;
	}

	/**-----------------------------------------------------------------------------------------------------------------
	 * 2) Even Fibonacci numbers
	 * 	most basic algorithm i came up with, will follow an improved version.
	 * 	time complexity: O(n) ? not sure TODO: improve this
	 *
	 *	@param n number first iteration item
	 *  @param k number second iteration item
	 *  @param MAX number of max value
	 *  @param sum sum of even fibonacci number
	 *	@return return the sum of the even numbers to 4 million
	 */
	public int evenFibonacci(int n, int k, int MAX, int sum) {
		if(n > MAX) {
			return sum;
		} else {
			if((n+k) % 2 == 0) {
				sum = sum + n + k;
			}
			return evenFibonacci(n+k, n, MAX, sum);
		}
	}

	/**-----------------------------------------------------------------------------------------------------------------
	 * 3) Largest prime factor
	 * compute time O(n^2) but i reduced the input length by taking the square root of the
	 * number instead of the whole number.
	 *
	 * @param n the number to compute for the prime factors
	 * @return Return the largest prime factor of n
	 */
	public long largestPrimeFactor(long n) {

		long max = 0;
		for(int i = 3; i < Math.sqrt(n); i += 2) {
			if(isPrime(i)) {
				if(n % i == 0) {
					max = i;
				}
			}
		}
		return max;
	}

	/**
	 * Check if n is prime, i reduced the time complexity by taking the square root of n
	 * instead of the full number
	 * time O(n)
	 *
	 * @param n the number to check
	 * @return true if n is prime, else false
	 */
	public boolean isPrime(int n) {
		int root = (int) Math.sqrt(n) + 1;
		for(int i = 3; i < root; i += 2) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * First it check if the length of the string is odd, in this case i delete
	 * the central character, then cycle through the string and return false at
	 * the first mismatch
	 * time O(n)
	 *
	 * @param n int to check
	 * @return true if s is palindrome, else false
	 */
	public boolean isPalindrome(int n) {
		String s = Integer.toString(n);
		if(s.length() % 2 != 0) {
			s = s.substring(0, (s.length()-1)/2) + s.substring((s.length()+1)/2);
		}
		for(int i = 0; i < s.length()/2; i++) {
			if(s.charAt(i) != s.charAt(s.length()-1-i)) {
				return false;
			}
		}
		return true;
	}

	/**
	 *	Bad implementation but it works so...
	 *
	 * @return minimum number divisible by number from 1 to 20
	 */
	public int smallestMultiple() {
		int solution = 20;
		boolean solutionFound = true;

		while(solutionFound) {
			if(		solution % 7 == 0 &&
					solution % 8 == 0 &&
					solution % 9 == 0 &&
					solution % 11 == 0 &&
					solution % 13 == 0 &&
					solution % 15 == 0 &&
					solution % 16 == 0 &&
					solution % 17 == 0 &&
					solution % 18 == 0 &&
					solution % 19 == 0 &&
					solution % 20 == 0) {
				solutionFound = false;
			} else solution += 1;
		}
		return solution;
	}



}

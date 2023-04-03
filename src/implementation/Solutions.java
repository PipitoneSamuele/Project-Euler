package implementation;


public class Solutions {

	/**-----------------------------------------------------------------------------------------------------------------
	 * 1) multiple of 3 or 5
	 *
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
	 *
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
	 *
	 * compute time O(n^2) but i reduced the n length by take the square root.
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

	public boolean isPrime(int n) {
		int root = (int) Math.sqrt(n) + 1;
		for(int i = 3; i < root; i += 2) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}

}

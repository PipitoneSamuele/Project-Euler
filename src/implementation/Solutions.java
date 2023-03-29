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
	 * 	return the sum of the even numbers to 4 million
	 *
	 * 	most basic algorithm i came up with, will follow an improved version.
	 * 	time complexity: O(2^n)
	 *
	 *	@param n: number first iteration item
	 *  @param k: number second iteration item
	 *  @param MAX: number of max value
	 *  @param sum: sum of even fibonacci number
	 *	@return count
	 */
	public int evenFibonacci(int n, int k, int MAX, int sum) {
		if(n > MAX) {
			return sum;
		} else {
			int pivot = n;
			if((n+k) % 2 == 0) {
				sum = sum + n + k;
			}
			return evenFibonacci(n+k, pivot, MAX, sum);
		}
	}
	
	
	
	
	
	

}

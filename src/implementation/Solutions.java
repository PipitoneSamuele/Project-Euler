package implementation;

import utility.BigString;

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
		if(n < 2) return false;
		if(n == 2 || n == 3) return true;
		if(n % 2 == 0 || n % 3 == 0) return false;

		long root = (long) Math.sqrt(n) + 1;

		for(long i = 6L; i <= root; i += 6) {
			if(n % (i-1) == 0 || n % (i+1) == 0) {
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

	/**
	 * @return difference between sumSquare and squareSum
	 */
	public long sumSquareDifference() {
		long sumSquare100 = sumSquareNumbers(100);
		long squareSumNumbers = squareSumNumbers(100);
		return squareSumNumbers - sumSquare100;
	}

	/**
	 * @param n number of iterations
	 * @return the nth sum square
	 */
	public long sumSquareNumbers(int n) {
		long ret = 0;
		for(int i = 1; i <= n; i++) {
			ret += Math.pow(i, 2);
		}
		return ret;
	}

	/**
	 * @param n number of iterations
	 * @return the nth square sum
	 */
	public long squareSumNumbers(int n) {
		long ret = 0;
		for(int i = 1; i <= n; i++) {
			ret += i;
		}
		return (long) Math.pow(ret, 2);
	}

	/**
	 * @param dimension number of iterations
	 * @return the dimension-th prime
	 */
	public int tenThousOneThPrime(int dimension) {
		int count = 2;
		int currentNumber = 3;

		while(count < dimension) {
			currentNumber += 2;
			if(isPrime(currentNumber)) {
				count += 1;
			}
		}
		return currentNumber;
	}

	/**
	 * i used a double for loop because it is just 1k elements and as a way to reduce
	 * the total number of iterations i skipped everytime i find a 0.
	 *
	 * @return the largest product of 13 elements
	 */
	public long largestProductInSeries() {
		String series = BigString.PRODUCTSERIES;
		long currentTotal13 = 0;
		long max = 0;
		long currentNumber = -1;

		for(int i = 0; i < (series.length()-13); i++) {
			currentTotal13 = 1;
			for(int j = 0; j < 13; j++) {
				currentNumber = Character.getNumericValue(series.charAt(i+j));
				if(currentNumber != 0) {
					currentTotal13 *= currentNumber;
				} else break;
			}
			if(currentTotal13 > max) {
				max = currentTotal13;
			}
		}
		return max;
	}

	/**
	 * ugly code, time complexity O(n^3) but for n=500 is doable
	 * @return the pythagorean triple for a+b+c=1000
	 */
	public int pythagoreanTriplet() {

		for(int a = 0; a < 500; a++) {
			for(int b = 0; b < 500; b++) {
				for(int c = 0; c < 500; c++) {
					if(a+b+c == 1000) {
						if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
							return a*b*c;
						}
					}
				}
			}
		}

		return 0;
	}

	/**
	 * simple implementation, i improved my isPrime function to be a lot more efficient
	 *
	 * @param max number of iterations
	 * @return the sum of the prime elements till max
	 */
	public long sumPrime(int max) {
		int i = 1;
		long sum = 0;

		while(i < max) {
			i += 1;
			if(isPrime(i)) {
				sum += i;
			}
		}
		return sum;
	}

	/**
	 * time complexity O(4n^2) but n = 20 so it's not that bad
	 *
	 * @return the largest product of 4 elements in every direction in the grid
	 */
	public int largestProductInGrid() {
		String grid = BigString.GRID;
		int j = 0;
		int i = 0;
		int number;
		int[][] numberGrid = new int[20][20];

		int currentProduct = 0;
		int maxProduct = 0;

		//Preprocess -> transform the String into a matrix !!!!!!!!
		// NOTA BENE PER FUTURO -> nei casi in cui ti serve un mapping e usi diversi indici cerca se
		// ci sia un modo efficiente per farlo, ogni volta ci sbatti la testa
		for(int s = 0; s < grid.length(); s += 3) {
			number = Integer.parseInt( String.valueOf(grid.charAt(s)) + grid.charAt(s+1));
			numberGrid[i][j] = number;
			j += 1;
			if(j == 20) {
				j = 0;
				i += 1;
			}
		}

		//horizontal
		System.out.println("------HORIZONTAL------");
		for(i = 0; i < 20; i++){
			for(j = 0; j < 17; j++) {
				System.out.println(numberGrid[i][j] +" "+ numberGrid[i][j+1] +" "+ numberGrid[i][j+2] +" "+ numberGrid[i][j+3]);
				currentProduct = numberGrid[i][j] * numberGrid[i][j+1] * numberGrid[i][j+2] * numberGrid[i][j+3];
				if(currentProduct > maxProduct) {
					maxProduct = currentProduct;
				}
			}
		}

		//vertical
		System.out.println("------VERTICAL------");
		for(i = 0; i < 17; i++){
			for(j = 0; j < 20; j++) {
				System.out.println(numberGrid[i][j] +" "+ numberGrid[i+1][j] +" "+ numberGrid[i+2][j] +" "+ numberGrid[i+3][j]);
				currentProduct = numberGrid[i][j] * numberGrid[i+1][j] * numberGrid[i+2][j] * numberGrid[i+3][j];
				if(currentProduct > maxProduct) {
					maxProduct = currentProduct;
				}
			}
		}

		//forward diagonal
		System.out.println("------FORWARD DIAGONAL------");
		for(i = 0; i < 17; i++){
			for(j = 0; j < 17; j++) {
				System.out.println(numberGrid[i][j] +" "+ numberGrid[i+1][j+1] +" "+ numberGrid[i+2][j+2] +" "+ numberGrid[i+3][j+3]);
				currentProduct = numberGrid[i][j] * numberGrid[i+1][j+1] * numberGrid[i+2][j+2] * numberGrid[i+3][j+3];
				if(currentProduct > maxProduct) {
					maxProduct = currentProduct;
				}
			}
		}

		//backward diagonal
		System.out.println("------BACKWARD DIAGONAL------");
		for(i = 0; i < 17; i++){
			for(j = 0; j < 17; j++) {
				System.out.println(numberGrid[i+3][j] +" "+ numberGrid[i+2][j+1] +" "+ numberGrid[i+1][j+2] +" "+ numberGrid[i][j+3]);
				currentProduct = numberGrid[i+3][j] * numberGrid[i+2][j+1] * numberGrid[i+1][j+2] * numberGrid[i][j+3];
				if(currentProduct > maxProduct) {
					maxProduct = currentProduct;
				}
			}
		}

		return maxProduct;
	}

	/**
	 * Perchè radice???
	 */
	public static int divisibleTriangularNumber() {
		int currentDivisors = 0;
		int count = 1;
		int currentNumber = 0;

		while(currentDivisors < 500) {
			currentNumber += count;
			System.out.println("current number: " + currentNumber);
			count += 1;
			currentDivisors = 0;
			for(int i = 1; i <= (int) Math.sqrt(currentNumber); i++) {
				if (currentNumber % i == 0) currentDivisors += 2;
			}
		}
		return currentNumber;
	}

}

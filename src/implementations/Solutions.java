package implementations;

public class Solutions {
	
	final int MAXFIBONACCI = 4000000;
	final String PRODUCTSERIES = 
			  "73167176531330624919225119674426574742355349194934"
			+ "96983520312774506326239578318016984801869478851843"
			+ "85861560789112949495459501737958331952853208805511"
			+ "12540698747158523863050715693290963295227443043557"
			+ "66896648950445244523161731856403098711121722383113"
			+ "62229893423380308135336276614282806444486645238749"
			+ "30358907296290491560440772390713810515859307960866"
			+ "70172427121883998797908792274921901699720888093776"
			+ "65727333001053367881220235421809751254540594752243"
			+ "52584907711670556013604839586446706324415722155397"
			+ "53697817977846174064955149290862569321978468622482"
			+ "83972241375657056057490261407972968652414535100474"
			+ "82166370484403199890008895243450658541227588666881"
			+ "16427171479924442928230863465674813919123162824586"
			+ "17866458359124566529476545682848912883142607690042"
			+ "24219022671055626321111109370544217506941658960408"
			+ "07198403850962455444362981230987879927244284909188"
			+ "84580156166097919133875499200524063689912560717606"
			+ "05886116467109405077541002256983155200055935729725"
			+ "71636269561882670428252483600823257530420752963450";

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
	public boolean isPrime(long n) { //to improve efficency
		
		if(n == 1 || n == 2) {
			return true;
		}
		if( //efficency reasons
			n % 2 == 0 ||
			n % 3 == 0 ||
			n % 4 == 0 ||
			n % 5 == 0 ||
			n % 6 == 0 ||
			n % 7 == 0 ||
			n % 8 == 0 
				) {
			return false;
		}
		
		for(int i = 9; i < Math.sqrt(n); i++) { //supergood -- TODO studia perchè la radice
			if(n % (i-1) == 0 || n % (i+1) == 0) {
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
	
	//7) ----------------------------------------------------------------------------------------------------------------
	public int nthPrime(int n) {
		
		int countPrime = 0;
		int countIteration = 1;
		int nthPrime = 0;
		
		while(countPrime < n) {
			countIteration++;
			if(isPrime(countIteration)) {
				countPrime++;
				nthPrime = countIteration;
			}
		}
		return nthPrime;
	}
	
	//8) ----------------------------------------------------------------------------------------------------------------
	public long largestInASeries(int n) {
		
		long maxProduct = 0;
		long currentProduct = 1;
		
		for(int i = 0; i < (PRODUCTSERIES.length() - 13); i++) {
			currentProduct = 1;
			for(int j = 0; j < n; j++) {
				currentProduct *= Character.getNumericValue(PRODUCTSERIES.charAt(j+i));  
			}
			if(currentProduct > maxProduct) {
				maxProduct = currentProduct;
			}
		}
		return maxProduct;
	}
	
	//9) ----------------------------------------------------------------------------------------------------------------
	public int specialPythagorean() {
		
		//ugly 
		for(int i = 0; i < 333; i++) { //aka a
			for(int j = 0; j < 500; j++) { //aka b
				for(int z = 0; z < 500; z++) { //aka c
					if(isPythagorean(i,j,z)) {
						if(i+j+z == 1000) {
							return i*j*z;
						}
					}
				}
			}
		}
		
		return 0;
	}
	
	public boolean isPythagorean(int a, int b, int c) {
		a = a*a;
		b = b*b;
		c = c*c;
		return (a+b) == c;
	}
	
	//10) ----------------------------------------------------------------------------------------------------------------
	public long summationOfPrime(int n) {
		
		int count = 3;
		long sumOfPrime = 2;
		
		while(count < n) {
			if(isPrime(count)) {
				sumOfPrime += count;
			}
			count += 2;
		}
		return sumOfPrime;
	}
	
}

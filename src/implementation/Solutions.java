package implementation;

import java.math.BigInteger;

import utility.BigString;
import utility.MyStringUtility;

public class Solutions {
	
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
		
		final int MAXFIBONACCI = 4000000;
		
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
		
		//super ugly but more efficent
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
		
		for(int i = 0; i < (BigString.PRODUCTSERIES.length() - 13); i++) {
			currentProduct = 1;
			for(int j = 0; j < n; j++) {
				currentProduct *= Character.getNumericValue(BigString.PRODUCTSERIES.charAt(j+i));  
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
	
	//11) ----------------------------------------------------------------------------------------------------------------
	public int largestInAGrid() {
		
		int[][] gridInt = buildGrid();
		int actualValue = 0;
		int maxValue = 0;
		
		//horizontal check
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 16; j++) {
				actualValue = gridInt[i][j] * gridInt[i][j+1] * gridInt[i][j+2] * gridInt[i][j+3];
				if(actualValue > maxValue) {
					maxValue = actualValue;
				}
			}
		}
		
		//vertical check
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 20; j++) {
				actualValue = gridInt[i][j] * gridInt[i+1][j] * gridInt[i+2][j] * gridInt[i+3][j];
				if(actualValue > maxValue) {
					maxValue = actualValue;
				}
			}
		}
		
		//oblique sx to dx check
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 16; j++) {
				actualValue = gridInt[i][j] * gridInt[i+1][j+1] * gridInt[i+2][j+2] * gridInt[i+3][j+3];
				if(actualValue > maxValue) {
					maxValue = actualValue;
				}
			}
		}
		
		//oblique dx to sx check
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 16; j++) {
				actualValue = 
						gridInt[i][gridInt.length - 1 - j] * 
						gridInt[i+1][gridInt.length - 2 - j] * 
						gridInt[i+2][gridInt.length - 3 - j] * 
						gridInt[i+3][gridInt.length - 4 - j];
				if(actualValue > maxValue) { 
					maxValue = actualValue;
				}
			}
		}
		
		return maxValue;
	}
	
	public int[][] buildGrid(){
		
		int[][] ret = new int[20][20];
		int countStringStart = 0;
		int countStringEnd = 2;
		
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 20; j++) {
				ret[i][j] = Integer.parseInt(BigString.GRID.substring(countStringStart, countStringEnd));
				countStringStart += 3;
				countStringEnd += 3;
			}
			countStringStart--;
			countStringEnd--;
		}
		
		return ret;
	}
	
	//12) ----------------------------------------------------------------------------------------------------------------
	public int highlyDivisibleTriangle(int n) {
		
		int triangle = 1;
		int count = 1;
		int divisors = 0;
		
		while(divisors <= n) {
			count++;
			triangle += count;
			//efficency reasons
			if(triangle % 2 == 0 && triangle % 3 == 0 && triangle % 4 == 0 && triangle % 5 == 0) {
				divisors = numberOfDivisors(triangle);
			}
		}
			
		return triangle;
	}
	
	public int numberOfDivisors(int n) {
		int divisors = 0;
		
		if(n % 2 == 0) {
			divisors++;
		}
		
		for(int i = 1; i < Math.floor(n/2); i++) {
			if(n % i == 0) {
				divisors++;
			}
		}
		return ++divisors;
	}
	
	//13) ----------------------------------------------------------------------------------------------------------------
	public long largeSum() {
		
		String[] largeSum = buildLargeSum();
		String actualString = "";
		long ret = 0;
		
		for(int i = 0; i < 100; i++) {
			actualString = largeSum[i];
			ret += Long.parseLong(actualString.substring(0, 9));
		}
		
		return ret;
	}
	
	public String[] buildLargeSum() {
		
		String[] ret = new String[100];
		String actualString = "";
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 50; j++) {
				actualString += BigString.LARGESUM.charAt((i*50) + j);
			}
			ret[i] = actualString;
			actualString = "";
		}
		return ret;
	}

	//14) ----------------------------------------------------------------------------------------------------------------
	public int longestCollatzSequence(int magnitude) {
		
		long count = 1;
		int n = 1;
		int currentChain = 1;
		int maxChain = 0;
		int maxNumber = 0;
		
		while(n < magnitude) {
			
			count = n;
			
			while(count != 1) {
					
				if(count % 2 == 0) {
					count = count/2;
				} else {
					count = (count*3) + 1;
				}
				
				currentChain++;
			}
			
			if(currentChain > maxChain) {
				maxChain = currentChain;
				maxNumber = n;
			}
			n++;
			currentChain = 1;
		}
		
		return maxNumber;
	}

	//15) ----------------------------------------------------------------------------------------------------------------
	public long latticePath(int rows, int columns) {
		
		long[][] matrix = new long[rows][columns];
		
		//create a matrix with all 0 values
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				matrix[i][j] = 0;
			}
		}
		
		//set value for one step paths
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(j == 0) {
					matrix[i][j] = 1;
				}
				if(i == 0) {
					matrix[i][j] = 1;
				}
			}
		}
		
		//paths logic
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(i != 0 && j != 0) {
					matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
				}
			}
		}
		
		//print matrix
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		return matrix[rows-1][columns-1];
	}
	
	//16) ----------------------------------------------------------------------------------------------------------------
	public int powerDigitSum() {
		
		BigInteger base = new BigInteger("2");
		int exponent = 1000;
		BigInteger hugeNumber = base.pow(exponent);
		String hugeNumberString = hugeNumber.toString();
		
		int ret = 0;
		
		for(int i = 0; i < hugeNumberString.length(); i++) {
			ret += Character.getNumericValue(hugeNumberString.charAt(i)); 
		}
		
		return ret;
	}
	
	//17) ----------------------------------------------------------------------------------------------------------------
	public int numberLetterCount() {
		
		int ret = 0;
		
		for(int i = 0; i < 1001; i++) {
			ret+= MyStringUtility.countLetterInANumber(i);
		} 
		
		return ret;
	}
	
	//18) ----------------------------------------------------------------------------------------------------------------
	public int maximumPathSum() {
		return 0;
	}
	
}

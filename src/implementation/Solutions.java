package implementation;


public class Solutions {

	/**
	 * 1) multiple of 3 or 5
	 *
	 * pretty bad but linear time of execution -> O(n)
	 *
	 * @param n
	 * @return
	 */
	public int multiplesOf3And5(int n) {

		int count = 0;

		for(int i = 0; i < n; i++) {
			if(i % 3 == 0 || i % 5 == 0)
				count = count + i;
		}
		return count;
	}
	

	
	
	
	
	
	
	

}

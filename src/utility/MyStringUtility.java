package utility;

public class MyStringUtility {
	
	//max number countable is 1000
	public static int countLetterInANumber(int n) {
		
		String number = Integer.toString(n);
		
		if(number == null || number.length() == 0) {
			return 0;
		}
		
		if(number.length() == 1) {
			switch(number) {
			case "1": return 3;
			case "2": return 3;
			case "3": return 5;
			case "4": return 4;
			case "5": return 4;
			case "6": return 3;
			case "7": return 5;
			case "8": return 5;
			case "9": return 4;
			default: return 0;
			}
		}
		
		if(number.length() == 2) {
			switch(number) {
			case "10": return 3;
			case "11": return 6;
			case "12": return 6;
			case "13": return 8;
			case "14": return 8;
			case "15": return 7;
			case "16": return 7;
			case "17": return 9;
			case "18": return 8;
			case "19": return 8;
			case "20": return 6;
			case "30": return 6;
			case "40": return 5;
			case "50": return 5;
			case "60": return 5;
			case "70": return 7;
			case "80": return 6;
			case "90": return 6;
			default: {
				switch(number.charAt(0)) { 
				case '2': return countLetterInANumber(20) + countLetterInANumber(Integer.parseInt(number.substring(1)));
				case '3': return countLetterInANumber(30) + countLetterInANumber(Integer.parseInt(number.substring(1)));
				case '4': return countLetterInANumber(40) + countLetterInANumber(Integer.parseInt(number.substring(1)));
				case '5': return countLetterInANumber(50) + countLetterInANumber(Integer.parseInt(number.substring(1)));
				case '6': return countLetterInANumber(60) + countLetterInANumber(Integer.parseInt(number.substring(1)));
				case '7': return countLetterInANumber(70) + countLetterInANumber(Integer.parseInt(number.substring(1)));
				case '8': return countLetterInANumber(80) + countLetterInANumber(Integer.parseInt(number.substring(1)));
				case '9': return countLetterInANumber(90) + countLetterInANumber(Integer.parseInt(number.substring(1)));
				}
			};
			}
		}
		
		//it counts "and" so it is plus 3 length
		if(number.length() == 3) {
			
			final int houndredLength = 10;
			
			switch(number.charAt(0)) {
			case '1': return countLetterInANumber(1) + houndredLength + countLetterInANumber(Integer.parseInt(number.substring(1)));
			case '2': return countLetterInANumber(2) + houndredLength + countLetterInANumber(Integer.parseInt(number.substring(1)));
			case '3': return countLetterInANumber(3) + houndredLength + countLetterInANumber(Integer.parseInt(number.substring(1)));
			case '4': return countLetterInANumber(4) + houndredLength + countLetterInANumber(Integer.parseInt(number.substring(1)));
			case '5': return countLetterInANumber(5) + houndredLength + countLetterInANumber(Integer.parseInt(number.substring(1)));
			case '6': return countLetterInANumber(6) + houndredLength + countLetterInANumber(Integer.parseInt(number.substring(1)));
			case '7': return countLetterInANumber(7) + houndredLength + countLetterInANumber(Integer.parseInt(number.substring(1)));
			case '8': return countLetterInANumber(8) + houndredLength + countLetterInANumber(Integer.parseInt(number.substring(1)));
			case '9': return countLetterInANumber(9) + houndredLength + countLetterInANumber(Integer.parseInt(number.substring(1)));
			}
		}
		
		if(number.length() == 4) {
			return 11;
		}

		return 0;
	} 

}

package utility;

public class Fraction {

	private String numerator;
	private String denominator;
	
	public Fraction(String denominator) {
		this.numerator = "1";
		
		if(!denominator.equalsIgnoreCase("0")) {
			this.denominator = denominator;
		} else {
			throw new IllegalArgumentException("Cannot divide by zero");
		}
	}
	
	public String getDecimalForm(int precision) {
		
		int denominatorInt = Integer.parseInt(denominator); //sempre fisso
		int zeroReturn = Integer.parseInt(denominator); //sempre fisso
		String floatingPoint = ""; //stringa di ritorno aggiornata passo passo
		int currentValue = 0; //risultato della frazione
		int carry= 0; //resto della divisione
		
		if(precision <= 0) {
			throw new IllegalArgumentException("Precision must be greater than 0");
		}
		
		//first iteration always the same - TODO maybe fix precision
		this.numerator = this.numerator + "0"; // cambia ogni iterazione
		int numeratorInt = Integer.parseInt(numerator);
		
		//TODO: tagli via gli zeri con numeri > 10, perchè?	
		for(int i = 0; i < precision; i++) {
		
			numeratorInt = Integer.parseInt(numerator);
			
			if(numeratorInt < denominatorInt) {
				this.numerator = this.numerator + "0";
			} else {
				currentValue = numeratorInt/denominatorInt;
				floatingPoint = floatingPoint + String.valueOf(currentValue);
				carry = numeratorInt % denominatorInt;
				this.numerator = String.valueOf(carry);
				i--;
			}
			
		}
		
		if(zeroReturn > 100) {
			return "0.00" + floatingPoint;
		} else if(zeroReturn > 10) {
			return  "0.0" + floatingPoint;
		} else {
			return "0." + floatingPoint;
		}
		
	}
	
	public String getNumerator() {
		return numerator;
	}

	public String getDenominator() {
		return denominator;
	}

	public void setDenominator(String denominator) {
		this.denominator = denominator;
	}
	
}

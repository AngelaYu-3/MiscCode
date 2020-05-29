import java.util.Scanner;

public class fractionCalculator {
	
	Scanner input = new Scanner(System.in);
	
	public fractionCalculator() {
	    System.out.println("This program is a fraction calculator");
	    System.out.println("It will add, subtract, multiply and divide fractions until you type q to quit.");
	    System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
	    System.out.println("----------------------------------------------------------------------------------");
	    
	    //getOperation(input);
	    //getFraction(input);
	    //System.out.print("Please enter an operation (+, - , /, = or q to quit)");
	    
	    
	}
	
	private String getOperation(Scanner input) {
		System.out.print("Please enter an operation (+, - , /, = or q to quit): ");
	    String op = input.next();
	    
	    do {
	    	if(op.equals("+") || op.equals("-") || op.equals("/") || op.equals("=") || op.equals("*")) {
	    		//System.out.println("hello");
	    		break;
		    
		    } 
	    	else if(op.equals("q") || op.equals("Q")) {
	    		System.out.printf("\nProcess finished with exit code 0");
	    		System.exit(0);
	    		return null;
	    	}
	    	else {
		    	System.out.print("Invalid input (+, -, /, *, = or q to quit): ");
		    }
	    	op = input.next();
	    	
	    }while(true);
	    
	    return op;
	}
	
	private fraction checkAndReturnFraction(String in) {
		int i = 0;
		int strLength = in.length();
		int signInt = 1;
		String n = "";
		String d = "";

		// Check 1st character 
		char c = in.charAt(0);
		
		if(c >= '0' && c <= '9') {
		    n += c;   
		}
		else if(c == '-'){
		    signInt = -1;	
		}
		else {
			return null;
		}		
		
		// Check rest of characters for numerator
		for(i = 1; i < strLength; i++) { 
				
			if((in.charAt(i) >= '0') && (in.charAt(i) <= '9')){
			        n += in.charAt(i);	
			    }
			    
			    else if(in.charAt(i) == '/') {
			    	break;
			    }
			    
			    else {
			    	return null;
			    }
		    }
	    
		if ((in.charAt(0) == '0')) {
			fraction f1 = new fraction();
		    return f1;   
			
		}
		//first index of numerator can't be 0
		if (n.charAt(0) == '0') {
			return null;
		}
		
		//last value cannot be '/'
		if(in.charAt(in.length() - 1) == '/') {
			return null;
		}
		
		//check rest of characters for denominator
		for(int j = i+1; j < in.length(); j++) {
			    
		    if((in.charAt(j) >= '0') && (in.charAt(j) <= '9')){
			        d += in.charAt(j);	
			}
			    
			else {
			    return null;
			}
	    }
		
		if(d.length() > 0) {
			if (d.charAt(0) == '0') {
			    return null;
			}	
		}
		
			
			
		// If comes to here, it is a valid fraction
		//newFraction = new Fraction (signInt * n.toInteger(), d.toInteger);
		if(d.length() > 0) {
			fraction f1 = new fraction((signInt * Integer.parseInt(n)), Integer.parseInt(d));
			return f1;
		}
		else {
			fraction f1 = new fraction(signInt * Integer.parseInt(n));
			return f1;
		}
			  
	}
	
	private fraction execute(Scanner input) {
		
		String op = getOperation(input);
	    System.out.print("Please enter a fraction (a/b); or integer (a): ");
	    String fraction1 = input.next();
	    fraction f1, f2;
	    
	    do {
	    	f1 = checkAndReturnFraction(fraction1);
	        if(f1 == null) {
	        	System.out.print("Invalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not 0: ");
	        	fraction1 = input.next();
	        }
	        
	        else {
	        	break;
	        }
	    }while(true);
	    
	    
	    System.out.print("Please enter a fraction (a/b); or integer (a): ");
	    String fraction2 = input.next();
	    
	    
	    do {
	    	f2 = checkAndReturnFraction(fraction2);
	        if(f2 == null) {
	        	System.out.print("Invalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not 0: ");
	        	fraction2 = input.next();
	        }
	        
	        else { 	
	        	break;
	        }
	    }while(true);
	    
	    fraction f3;
	    fraction f4;
	    
	    if(op.contentEquals("+")) {
	    	f3 = f1.add(f2);
	    	System.out.println(f3);
	    	return f3;
	    }
	    else if(op.contentEquals("-")) {
	    	f3 = f1.subtract(f2);
	    	System.out.println(f3);
	    	return f3;
	    }
	    else if(op.contentEquals("*")) {
	        f3 = f1.multiply(f2);
	        System.out.println(f3);
	        return f3;
	    }
	    else if(op.contentEquals("/")) {
	        f3 = f1.divide(f2);
	        System.out.println(f3);
	        return f3;
	    }
	    else if(op.contentEquals("=")) {
	        boolean f = f1.equals(f2);
	        System.out.println(f);
	        return null;
	    }
	    return null;			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		fractionCalculator calc = new fractionCalculator();
		
		do {
			calc.execute(input);	
			System.out.println("----------------------------------------------------------------------------------");
		}while(true);    
    }
}

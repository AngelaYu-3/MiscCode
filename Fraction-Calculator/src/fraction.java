
import java.util.Scanner;

public class fraction {
    private int n;
    private int d;
    
//fraction constructor 
    public fraction(int n, int d) {
    	this.n = n;
    	this.d = d;
    	
        if(d == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero"); 
        }
        else if(d < 0 && n > 0) {
        	this.n = -n; 
        }
        else if(d < 0 && n < 0){
        	this.n = Math.abs(n);
        	this.d = Math.abs(d);
        }
    }
    
    public fraction(int n) {
    	this(n,1);
    }
    
    public fraction() {
    	this(0,1);
    }
    
    public int getNumerator() {
        return n;
    }
    
    public int getDenominator() {
        return d;
    }
    
    public String toString() {
    	return n + "/" + d;
    }
    
    public double toDouble() {
    	return n/d;
    }
    
    public fraction add(fraction other) {
    	int a = ((this.n * other.d) + (this.d * other.n));
    	int b = this.d * other.d;
    	fraction f1 = new fraction (a,b);
    	f1 = f1.toLowestTerms(a,b);
    	return f1;
    }
    
    public fraction subtract(fraction other) {
    	int a = ((this.n * other.d) - (this.d * other.n));
    	int b = this.d * other.d;
    	fraction f1 = new fraction (a,b);
    	f1 = f1.toLowestTerms(a,b);
    	return f1;
    }
    
    public fraction multiply(fraction other) {
    	int a = this.n * other.n;
    	int b = this.d * other.d;
    	fraction f1 = new fraction(a,b);
    	f1 = f1.toLowestTerms(a, b);
    	return f1;
    }
    
    public fraction divide(fraction other) {
    	int a = this.n * other.d;
    	int b = this.d * other.n;
    	fraction f1 = new fraction(a,b);
    	f1 = f1.toLowestTerms(a, b);
    	return f1;
    }
    
    public boolean equals(fraction other) {
    	fraction tmp = new fraction(other.n, other.d);
    	fraction f1 = new fraction(this.n, this.d);
    	f1 = f1.toLowestTerms(this.n, this.d);
    	tmp = tmp.toLowestTerms(other.n, other.d);
    	if((tmp.getNumerator() == f1.getNumerator()) && (tmp.getDenominator() == f1.getDenominator())) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public fraction toLowestTerms(int a, int b) {
    	int x = gcd(a,b);
    	a = a / x;
    	b = b / x;
    	fraction f1 = new fraction(a,b);
    	return f1;
    }
    
    public static int gcd(int n, int d) {
    	int gcd = 1;
    	
    	for(int i = 1; i <= n && i <= d; i++) {
    		
    		if(n%i == 0 && d%i == 0) {
    			gcd = i;
    		}
    	}
    	
    	return gcd;
    }
    /*private void getValues() {
    	System.out.print("Enter a fraction: ");
        fraction = in.nextLine();
        Scanner sc = new Scanner(fraction);
        sc.useDelimiter("/");
    
        n = sc.nextInt();
        d = sc.nextInt();     
    }*/
}
   




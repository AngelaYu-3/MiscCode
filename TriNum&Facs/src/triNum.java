/**
 * TriNum&Facs
 * This program uses recursion to find both the triangular number
 * and factorial of a passed-in integer. It prints out the recursion process
 * for both operations.
 * 
 * @date June 11, 2020
 */

import java.util.Scanner;

public class triNum {	
	static int value;
	
	public triNum() {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter in a positive integer: ");
		value = input.nextInt();
	}
	
	public int add(int x) {
		int temp;
		System.out.println("Method " + x);
		
		if(x == 1) {
			System.out.println("Returned: 1");
			return 1;
		}
		else {
			temp = x + add(x - 1);
			System.out.print("Returned: " + temp);
			System.out.println(x + " + add(" + x + "- 1)");
			return temp;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		triNum test = new triNum();		
		System.out.println("\nTRIANGULAR NUMBER: " + test.add(value));
		System.out.println();
		
		factorial test2 = new factorial();
		System.out.println("\nFACTORIAL: " + test2.fact(value));
		
		
	}

}

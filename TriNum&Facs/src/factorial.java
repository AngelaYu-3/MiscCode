
public class factorial {
	
	public int fact(int x) {
		int temp;
		
		System.out.println("Method: " + x);
		
		if(x == 1) {
			System.out.println("Returned: 1");
			return 1;
		}
		else {
			temp = x * fact(x - 1);
			System.out.print("Returned: " + temp);
			System.out.println(x + " * fact(" + x + " - 1)");
			return temp;
		}
	}
}

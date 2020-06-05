
public class test {
	
	
	public int[] pre4(int[] nums) {
		int i = 0;
		
		
		while(nums[i] !=4) {
			i++;
		}
		
		int[] foo = new int[i];
		for(int index = 0; index < i; index++) {
			foo[index] = nums[index];
			System.out.print(foo[index]);
		}
		return foo;
	}
	
	public static void main(String[] args) {
		test op = new test();
		int[] nums = {1, 2, 4, 1};
		op.pre4(nums);
	}

}

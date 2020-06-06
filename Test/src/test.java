
public class test {
	
	
	public void pre4(int[] nums) {
	
		for(int index = 0; index < nums.length; index++) {
			
			if(nums[index] == 4) {
			break;
			}
			System.out.print(nums[index]);
		}
	
	}
	
	public static void main(String[] args) {
		test op = new test();
		int[] nums = {1, 2, 4, 1};
		op.pre4(nums);
	}

}

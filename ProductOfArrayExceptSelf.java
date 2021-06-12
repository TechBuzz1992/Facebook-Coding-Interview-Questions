package coding.questions;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -1, 1, 0, -3, 3 };
		productExceptSelf(nums);
	}

	public static int[] productExceptSelf(int[] nums) {
		// left products
		int[] res = new int[nums.length];
		res[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}
//		System.out.println(Arrays.toString(res));

		// from right
		int right = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			res[i] = res[i] * right;
			right = right * nums[i];
		}
//		System.out.println(Arrays.toString(res));
		return res;
	}

}

package coding.questions;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,12,5,5};
		System.out.println(canPartition(nums));
	}
	
	public static boolean canPartition(int[] nums) {
		if(nums == null || nums.length<=1) {
			return true;
		}
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		int leftSum = nums[left];
		int rightSum = nums[right];
		while(left<right) {
			if(leftSum<rightSum) {
				leftSum += nums[++left];
			} else if(rightSum<leftSum){
				rightSum += nums[--right];
			} else {
				break;
			}
		}
		System.out.println(left + " " + right + " " + leftSum + " " + rightSum);
		if(left <= right && leftSum == rightSum) {
			return true;
		} else {
			return false;
		}
	}

}

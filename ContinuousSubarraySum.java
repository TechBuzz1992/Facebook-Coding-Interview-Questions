package coding.questions;

import java.util.*;

public class ContinuousSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 23, 2, 4, 6, 7 };
		int k = 6;
		System.out.println(checkSubarraySum(nums, k));
	}

	public static boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int runningSum = 0;
		for (int i = 0; i < nums.length; i++) {
			runningSum += nums[i];
			if (k > 0) {
				runningSum %= k;
			}

//			System.out.println(runningSum);

			Integer prev = map.get(runningSum);

			if (prev != null && i - prev > 1) {
//				System.out.println(prev + " " + (i - prev));
				return true;
			} else
				map.putIfAbsent(runningSum, i);
		}
		return false;
	}

}

package coding.questions;

public class MaximumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxSubArray(int[] array) {
		int maxSoFar = array[0], maxEndingHere = array[0];
		for (int i = 0; i < array.length; i++) {
			maxEndingHere = Math.max(maxEndingHere + array[i], maxEndingHere);
			maxSoFar = Math.max(maxEndingHere, maxSoFar);
		}
		return maxSoFar;
	}

}

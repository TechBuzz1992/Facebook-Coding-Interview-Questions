package coding.questions;

public class BinaryTreeMaxPath {
	static class TreeNode {
		TreeNode left, right;
		int val;

		TreeNode(int value) {
			this.val = value;
		}
	}

	public static int maxSum;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxPath(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		maxPathDown(root);
		return maxSum;
	}

	private static int maxPathDown(TreeNode root) {
		if (root == null)
			return 0;
		int left = Math.max(0, maxPathDown(root.left));
		int right = Math.max(0, maxPathDown(root.right));
		maxSum = Math.max(maxSum, root.val + left + right);
		return Math.max(left, right) + root.val;
	}

	public int maxSumHelper(TreeNode root) {

		// base case
		if (root == null)
			return 0;

		// recursing through left and right subtree
		int leftMax = maxSumHelper(root.left);
		int rightMax = maxSumHelper(root.right);

		// finding all the four paths and the maximum between all of them
		int maxRightLeft = Math.max(leftMax, rightMax);
		int maxOneNodeRoot = Math.max(root.val, (root.val + maxRightLeft));
		int maxAll = Math.max(maxOneNodeRoot, leftMax + rightMax + root.val);

		// Storing the result in the maxSum holder
		maxSum = Math.max(maxSum, maxAll);

		// returning the value if root was part of the answer
		return maxOneNodeRoot;

	}

}

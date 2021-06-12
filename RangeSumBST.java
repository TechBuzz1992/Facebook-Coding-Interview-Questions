package coding.questions;

public class RangeSumBST {
	static class TreeNode {
		TreeNode left, right;
		int value;

		TreeNode(int data) {
			this.left = null;
			this.right = null;
			this.value = data;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int rangeSumBST(TreeNode root, int left, int right) {
		if (root == null)
			return 0;
		if (root.value > right)
			return rangeSumBST(root.left, left, right);
		if (root.value < left)
			return rangeSumBST(root.right, left, right);
		return root.value + rangeSumBST(root.left, left, right) + rangeSumBST(root.right, left, right);
	}

}

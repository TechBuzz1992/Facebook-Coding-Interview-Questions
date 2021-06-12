package coding.questions;

public class ClosestBinarySearchTreeValue {

	static class TreeNode {
		TreeNode left, right;
		int data;

		TreeNode(int value) {
			this.data = value;
			this.left = this.right = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int closestValue(TreeNode root, double target) {
		int val = root.data;
		while (root != null) {
			if (Math.abs(target - root.data) < Math.abs(target - val)) {
				val = root.data;
			}
			root = root.data > target ? root.left : root.right;
		}
		return val;
	}

}

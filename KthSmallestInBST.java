package coding.questions;

public class KthSmallestInBST {
	static class TreeNode {
		TreeNode left, right;
		int value;

		TreeNode(int data) {
			this.left = this.right = null;
			this.value = data;
		}
	}

	static int count = 0;
	static int result = Integer.MIN_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		System.out.println(kSmallest(root, 1));

	}

	public static int kSmallest(TreeNode root, int k) {
		traverse(root, k);
		return result;
	}
	
	public static void traverse(TreeNode root, int k) {
		if(root == null) {
			return;
		}
		traverse(root.left, k);
		count++;
		if(count == k) {
			result = root.value;
		}
		traverse(root.right, k);
	}

}

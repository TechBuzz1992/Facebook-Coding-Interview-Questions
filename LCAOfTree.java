package coding.questions;

public class LCAOfTree {
	static class Node {
		Node left, right;
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Node lowestCommonAncestor(Node root, int p, int q) {
		if(root == null || root.data == p || root.data == q) {
			return root;
		}
		Node left = lowestCommonAncestor(root.left, p, q);
		Node right = lowestCommonAncestor(root.right, p, q);
		return left == null ? right : right == null ? left : root;
	}

}

package coding.questions;

import java.util.*;

public class SerializeDeserializeTree {
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

	public static TreeNode deserializeTree(String s) {
		if (s == null || s.equals(""))
			return null;
		Queue<TreeNode> queue = new LinkedList<>();
		String[] strs = s.split(" ");
		TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
		queue.add(root);
		for (int i = 1; i < strs.length; i++) {
			TreeNode parent = queue.poll();
			if (!strs[i].equals("n")) {
				TreeNode left = new TreeNode(Integer.parseInt(strs[i]));
				parent.left = left;
				queue.add(left);
			}
			if (!strs[++i].equals("n")) {
				TreeNode right = new TreeNode(Integer.parseInt(strs[i]));
				parent.right = right;
				queue.add(right);
			}
		}
		return root;
	}

	public static String serializeTree(TreeNode root) {
		if (root == null)
			return "";
		Queue<TreeNode> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				sb.append("n ");
				continue;
			}
			sb.append(node.data + " ");
			queue.add(node.left);
			queue.add(node.right);
		}
		return sb.toString();
	}

}

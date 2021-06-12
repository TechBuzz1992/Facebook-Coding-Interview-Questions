package coding.questions;

import java.util.*;

public class BinaryTreePaths {
	static class TreeNode {
		TreeNode left, right;
		int data;

		TreeNode(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<String> getTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
		if (root == null)
			return result;
		searchBST(root, "", result);
		return result;
	}

	public static void searchBST(TreeNode root, String path, List<String> result) {
		if (root.left == null && root.right == null)
			result.add(path + root.data);
		if (root.left != null)
			searchBST(root.left, path + root.data + "->", result);
		if (root.right != null)
			searchBST(root.right, path + root.data + "->", result);

	}

}

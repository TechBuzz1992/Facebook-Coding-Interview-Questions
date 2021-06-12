package coding.questions;

import java.util.*;

public class SmallestSubTreeWithDeepestNodes {
	static class TreeNode {
		TreeNode left, right;
		int value;

		TreeNode(int data) {
			this.value = data;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static TreeNode getSmallestSubTree(TreeNode root) {
		if (root == null)
			return root;
		Map<TreeNode, TreeNode> map = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		List<TreeNode> lastRow = new ArrayList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			lastRow = new ArrayList<>();
			int count = queue.size();
			for (int i = 0; i < count; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
					map.put(node.left, node);
				}
				if (node.right != null) {
					queue.add(node.right);
					map.put(node.right, node);
				}
				lastRow.add(node);
			}
		}

		if (lastRow.size() == 1)
			return lastRow.get(0);
		TreeNode leftMost = lastRow.get(0);
		TreeNode rightMost = lastRow.get(lastRow.size() - 1);

		while (map.get(leftMost) != map.get(rightMost)) {
			leftMost = map.get(leftMost);
			rightMost = map.get(rightMost);
		}
		return map.get(leftMost);

	}

}

package coding.questions;

import java.util.*;

public class CloneGraph {
	static class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Node cloneGraph(Node root) {
		if (root == null)
			return null;
		Map<Node, Node> map = new HashMap<>();
		map.put(root, new Node(root.val, new ArrayList<Node>()));
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			for (Node n : current.neighbors) {
				if (!map.containsKey(n)) {
					map.put(n, new Node(n.val, new ArrayList<>()));
					queue.offer(n);
				}
				map.get(current).neighbors.add(map.get(n));
			}
		}
		return map.get(root);
	}

}

package coding.questions;

import java.util.*;

public class NumberOfConnectedComponents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int countComponents(int n, int[][] edges) {
		if (n <= 1) {
			return 0;
		}
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}
		for (int[] edge : edges) {
			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);
		}
		Set<Integer> visited = new HashSet<>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (visited.add(i)) {
				dfs(i, map, visited);
				count++;
			}
		}
		return count;
	}

	public static void dfs(int i, Map<Integer, List<Integer>> map, Set<Integer> visited) {
		for (int j : map.get(i)) {
			if (visited.add(j)) {
				dfs(j, map, visited);
			}
		}
	}

}

package coding.questions;

import java.util.*;

public class ShortestBridge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int shortestBridgeFlips(int[][] grid) {
		int m = grid.length; // rows
		int n = grid[0].length; // columns
		boolean[][] visited = new boolean[m][n];
		int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		Queue<int[]> queue = new LinkedList<>();
		boolean found = false;

		// code to find one island
		for (int i = 0; i < m; i++) {
			if (found) {
				break;
			}
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					dfs(grid, visited, queue, i, j, dirs);
					found = true;
					break;
				}
			}
		}

		int steps = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int[] curr = queue.poll();
				for (int[] dir : dirs) {
					int i = curr[0] + dir[0];
					int j = curr[1] + dir[1];
					if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j]) {
						if (grid[i][j] == 1) {
							return steps;
						}
						queue.offer(new int[] { i, j });
						visited[i][j] = true;
					}
				}
			}
			steps++;
		}
		return -1;

	}

	public static void dfs(int[][] A, boolean[][] visited, Queue<int[]> queue, int i, int j, int[][] directions) {
		if (i >= A.length || j >= A[0].length || i < 0 || j < 0 || visited[i][j] || A[i][j] == 0) {
			return;
		}
		visited[i][j] = true;
		queue.offer(new int[] { i, j });
		for (int[] dir : directions) {
			dfs(A, visited, queue, i + dir[0], j + dir[1], directions);
		}

	}

}

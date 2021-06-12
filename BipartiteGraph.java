package coding.questions;

public class BipartiteGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isBipartite(int[][] graph) {
		int N = graph.length;

		// 0 means no color
		// 1 means Red
		// -1 means Blue
		int[] colors = new int[N];

		for (int vertex = 0; vertex < N; vertex++) {
			if (colors[vertex] == 0 && !dfs(graph, vertex, 1, colors)) {
				return false;
			}
		}
		return true;
	}

	private static boolean dfs(int[][] graph, int vertex, int color, int[] colors) {
		if (colors[vertex] != 0) {
			return colors[vertex] == color;
		}

		colors[vertex] = color;
		for (int adjacentVertex : graph[vertex]) {
			if (!dfs(graph, adjacentVertex, -color, colors)) {
				return false;
			}
		}
		return true;

	}

}

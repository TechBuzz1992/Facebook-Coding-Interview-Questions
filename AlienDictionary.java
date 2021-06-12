package coding.questions;

import java.util.*;

public class AlienDictionary {
	public static int N = 26;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "wrt", "wrf", "er", "ett", "rftt" };
		System.out.println("Order : " + alienOrder(words));

		String[] words1 = { "z", "x" };
		System.out.println("Order : " + alienOrder(words1));

		String[] words2 = { "z", "x", "z" };
		System.out.println("Order : " + alienOrder(words2));

	}

	public static String alienOrder(String[] words) {
		if (words == null || words.length == 0)
			return "";
		if (words.length == 1)
			return words[1];

		// dependence matrix based on the words input
		boolean[][] dependence = new boolean[N][N];

		// indegree for every letter
		int[] indegree = new int[N];

		// existence for the letters from a to z
		boolean[] existence = new boolean[N];

		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				existence[words[i].charAt(j) - 'a'] = true;
			}
			if (i >= 1)
				checkTwoStrings(words[i - 1], words[i], dependence, indegree);
		}

		return toplogicalSort(dependence, indegree, existence);

	}

	private static String toplogicalSort(boolean[][] dependence, int[] indegree, boolean[] existence) {
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (indegree[i] == 0 && existence[i])
				queue.add(i);
		}

		while (!queue.isEmpty()) {
			int current = queue.poll();
			sb.append((char) (current + 'a'));
			for (int i = 0; i < N; i++) {
				if (dependence[i][current]) {
					indegree[i]--;
					if (indegree[i] == 0)
						queue.add(i);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			if (indegree[i] != 0)
				return "No Order Found";
		}
		return sb.toString();
	}

	public static void checkTwoStrings(String s1, String s2, boolean[][] dependence, int[] indegree) {
		int len = Math.min(s1.length(), s2.length());
		for (int i = 0; i < len; i++) {
			if (s1.charAt(i) != s2.charAt(i) && dependence[s2.charAt(i) - 'a'][s1.charAt(i) - 'a'] == false) {
				dependence[s2.charAt(i) - 'a'][s1.charAt(i) - 'a'] = true;
				indegree[s2.charAt(i) - 'a']++;
				break;
			}
		}
	}

}

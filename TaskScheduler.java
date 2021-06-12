package coding.questions;

import java.util.*;

public class TaskScheduler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int leastInterval(char[] tasks, int n) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < tasks.length; i++) {
			map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
		}
		PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<Map.Entry<Character, Integer>>(
				(a, b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey());

		queue.addAll(map.entrySet());
		int count = 0;
		while (!queue.isEmpty()) {
			int k = n + 1;
			List<Map.Entry<Character, Integer>> tempList = new ArrayList<>();
			while (k > 0 && !queue.isEmpty()) {
				Map.Entry<Character, Integer> entry = queue.poll();
				entry.setValue(entry.getValue() - 1);
				tempList.add(entry);
				k--;
				count++;
			}
			for (Map.Entry<Character, Integer> entry : tempList) {
				if (entry.getValue() > 0)
					queue.add(entry);
			}

			count = count + k;
		}
		return count;
	}

}

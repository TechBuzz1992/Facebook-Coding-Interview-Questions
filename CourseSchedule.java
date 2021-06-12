package coding.questions;

import java.util.*;

public class CourseSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		int[][] matrix = new int[numCourses][numCourses];
		int[] indegree = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int ready = prerequisites[i][0];
			int prev = prerequisites[i][1];
			if (matrix[prev][ready] == 0) {
				indegree[ready]++;
			}
			matrix[prev][ready] = 1;
		}

		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		while (!queue.isEmpty()) {
			int course = queue.poll();
			count++;
			for (int i = 0; i < numCourses; i++) {
				if (matrix[course][i] != 0) {
					if (--indegree[i] == 0) {
						queue.offer(i);
					}
				}
			}
		}
		return count == numCourses;
	}

}

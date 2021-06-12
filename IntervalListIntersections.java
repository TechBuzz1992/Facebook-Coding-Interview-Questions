package coding.questions;

import java.util.*;

public class IntervalListIntersections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		if (firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0) {
			return new int[][] {};
		}
		List<int[]> list = new ArrayList<>();
		int i = 0, j = 0;
		int startMax, endMin;
		while (i < firstList.length && j < secondList.length) {
			startMax = Math.max(firstList[i][0], secondList[j][0]);
			endMin = Math.min(firstList[i][1], secondList[j][1]);

			if (endMin >= startMax) {
				list.add(new int[] { startMax, endMin });
			}

			if (firstList[i][1] == endMin)
				i++;
			if (secondList[j][1] == endMin)
				j++;
		}

		return list.toArray(new int[list.size()][2]);
	}

}

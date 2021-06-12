package coding.questions;

import java.util.*;
public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[][] merge(int[][] intervals){
		if(intervals.length<=1) {
			return intervals;
		}
		Arrays.sort(intervals, (i1, i2)->Integer.compare(i1[0], i2[0]));
		List<int[]> list = new ArrayList<>();
		int[] newInterval = intervals[0];
		list.add(newInterval);
		for(int[] interval : intervals) {
			if(interval[0]<=newInterval[1]) {
				newInterval[1] = Math.max(interval[1], newInterval[1]);
			}else {
				newInterval = interval;
				list.add(newInterval);
			}
		}
		return list.toArray(new int[list.size()][]);
	}
}

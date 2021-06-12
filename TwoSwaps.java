package coding.questions;

import java.util.*;

public class TwoSwaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "face";
		String b = "ecaf";
		System.out.println(canTwoSwaps(a, b));

	}

	public static boolean canTwoSwaps(String a, String b) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length(); i++) {
			map.putIfAbsent(a.charAt(i), i);
		}

		int count = 0;
		for (int i = 0; i < b.length(); i++) {
			char c = b.charAt(i);
			if (i != map.get(c))
				count++;
			if (count > 2) {
				return false;
			}
		}
		return true;

	}

}

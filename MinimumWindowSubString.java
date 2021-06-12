package coding.questions;

public class MinimumWindowSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String minWindowSubString(String s, String t) {
		int[] mapS = new int[256];
		int[] mapT = new int[256];
		for (char c : t.toCharArray()) {
			mapT[c]++;
		}
		int right = 0;
		int min = Integer.MAX_VALUE;
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			while (right < s.length() && !sContainsT(mapS, mapT)) {
				mapS[s.charAt(right)]++;
				right++;
			}
			if (sContainsT(mapS, mapT) && min > right - i + 1) {
				min = right - min + 1;
				res = s.substring(i, right);
			}
			mapS[s.charAt(i)]--;

		}
		return res;
	}

	private static boolean sContainsT(int[] mapS, int[] mapT) {
		for (int i = 0; i < mapT.length; i++) {
			if (mapS[i] < mapT[i]) {
				return false;
			}
		}
		return true;
	}

}

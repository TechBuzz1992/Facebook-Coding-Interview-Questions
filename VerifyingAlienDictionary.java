package coding.questions;

public class VerifyingAlienDictionary {

	static int mapping[] = new int[26];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"hello","leetcode"};
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		System.out.println(isAlienSorted(words, order));
	}

	public static boolean isAlienSorted(String[] words, String order) {
		for (int i = 0; i < order.length(); i++) {
			mapping[order.charAt(i) - 'a'] = i;
		}
		for (int i = 1; i < words.length; i++) {
			if (isBigger(words[i - 1], words[i])) {
				return false;
			}
		}
		return true;

	}

	public static boolean isBigger(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		for (int i = 0; i < n && i < m; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				return mapping[s1.charAt(i) - 'a'] > mapping[s2.charAt(i) - 'a'];
			}
		}
		return n > m;
	}

}

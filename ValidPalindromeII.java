package coding.questions;

public class ValidPalindromeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abca";
		System.out.println(validPalindrome(s));
	}

	public static boolean validPalindrome(String s) {
		int left = -1;
		int right = s.length();
		while (++left < --right) {
			if (s.charAt(left) != s.charAt(right)) {
				return isPalindromic(s, left + 1, right) || isPalindromic(s, left, right - 1);
			}
		}
		return true;
	}

	public static boolean isPalindromic(String s, int left, int right) {
		while (++left < --right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
		}
		return true;
	}

}

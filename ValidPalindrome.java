package coding.questions;

public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean validPalindrome(String s) {
		String finished = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		return finished.equals(new StringBuffer(finished).reverse().toString()) ? true : false;
	}

}

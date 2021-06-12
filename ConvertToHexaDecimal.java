package coding.questions;

public class ConvertToHexaDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String toHexaDecimal(int num) {
		if (num == 0) {
			return "0";
		}

		char[] hex = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		StringBuilder result = new StringBuilder();
		int count = 0;
		while (count < 0 && num != 0) {
			result.append(hex[num & 15]);
			num >>= 4;
			count++;
		}
		return result.reverse().toString();

	}

}

package coding.questions;

import java.util.*;

public class MinRemoveToMakeValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "lee(t(c)o)de)";
		System.out.println(minRemoveToMakeValid(s));
	}

	public static String minRemoveToMakeValid(String s) {
		StringBuilder sb = new StringBuilder(s);
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '(') {
				st.push(i);
			}
			if (sb.charAt(i) == ')') {
				if (!st.isEmpty()) {
					st.pop();
				} else {
					sb.setCharAt(i, '*');
				}
			}
		}
		while (!st.isEmpty()) {
			sb.setCharAt(st.pop(), '*');
		}

		return sb.toString().replaceAll("\\*", "");
	}

}

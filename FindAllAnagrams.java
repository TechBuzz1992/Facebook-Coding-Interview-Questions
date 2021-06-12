package coding.questions;

import java.util.*;
public class FindAllAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbaebabacd", p = "abc";
		System.out.println(findAllAnagrams(s, p));
	}
	
	public static List<Integer> findAllAnagrams(String s, String p){
		List<Integer> result = new ArrayList<Integer>();
		if(s == null || s.length() == 0 || p == null || p.length() == 0) {
			return result;
		}
		int[] hash = new int[256];
		for(Character c : p.toCharArray()) {
			hash[c]++;
		}
		int left = 0, right = 0, count = p.length();
		while(right<s.length()) {
			if(hash[s.charAt(right++)]-- >= 1) {
				count--;
			}
			if(count == 0) {
				result.add(left);
			}
			if(right-left == p.length() && hash[s.charAt(left++)]++ >= 0) {
				count++;
			}
		}
		return result;
	}

}

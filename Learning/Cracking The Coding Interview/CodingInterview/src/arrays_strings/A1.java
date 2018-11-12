package arrays_strings;

import java.util.HashSet;
import java.util.Set;

/*
 * Implement an algorithm to determine if a String has all unique characters.
 * What if you can not use additional data structures?
 */
public class A1 {
	public static void main(String[] args) {
		String input = "Namae";
		System.out.println(isAllUniqueChars(input));
	}
	private static boolean isAllUniqueChars(String input) {
		boolean flag = true;
		Set<Character> set = new HashSet<>();
		for(char c : input.toCharArray()) {
			flag = set.add(c);
			if(!flag) {
				return flag;
			}
		}
		
		return flag;
	}

}

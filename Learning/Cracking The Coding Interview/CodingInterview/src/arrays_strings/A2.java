package arrays_strings;

import java.util.Arrays;

public class A2 {
	public static void main(String[] args) {
		String input1 = "Amit";
		String input2 =  "mitA";
		System.out.println("Is permutation :"+isPermutation(input1, input2));
	}
	private static boolean isPermutation(String input1,String input2){
		boolean flag = true;
		char [] char1 = input1.toCharArray();
		char [] char2 = input2.toCharArray();
		Arrays.sort(char1);
		Arrays.sort(char2);
		if(char1.length != char2.length) return false;
		for(int i = 0; i < char1.length;i++) {
			if(char1[i] != char2[i]) {
				return false;
			}
		}
		return flag;
	}
}

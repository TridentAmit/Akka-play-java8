package edu.learn.recursion;

/*
 * Find sum of first n positive numbers.
 * 
 */
public class Code1_3 {
	private static int sum(int n) {
		return (n == 0) ? 0 : (n == 1) ? 1 : (n+sum(n-1));
	}
	public static void main(String[] args) {
		System.out.println(sum(10));
	}

}

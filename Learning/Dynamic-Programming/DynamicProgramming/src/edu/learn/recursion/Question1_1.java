package edu.learn.recursion;
/*
 * Find factorial of a positive integer
 * 
 */
public class Question1_1 {
	private static int facotial(int n) {
		return (n== 0 || n == 1 ) ? 1 : n*facotial(n-1);
	}
	public static void main(String[] args) {
		System.out.println(facotial(5));
	}
}

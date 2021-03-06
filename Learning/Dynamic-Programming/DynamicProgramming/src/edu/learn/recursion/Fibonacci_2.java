package edu.learn.recursion;
/*
 * Storing result of fibonacci and using it.
 */
public class Fibonacci_2 {
	static int fib[] ;
	static int fib(int n) {
		if(fib[n] == 0) {
			if(n <= 0 || n == 1 || n==2 ) {
				fib[n] = 1;
			}else {
				fib[n] = fib(n-2)+fib(n-1);
			}
		}
		return fib[n];
	}
	public static void main(String[] args) {
		int n = 117;
		fib = new int[n];
		System.out.println("Fib of :"+fib(n-1));
	}
}

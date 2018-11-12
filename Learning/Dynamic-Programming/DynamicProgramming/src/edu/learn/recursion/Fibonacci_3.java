package edu.learn.recursion;
/*
 * Fibonacci calculation in log(n)
 */
public class Fibonacci_3 {

	static int fib[] ;
	static int fib(int n) {
		if(fib[n] == 0) {
			if(n <= 0 || n == 1 || n==2 ) {
				fib[n] = 1;
			}else {
				if(n % 2 == 0) {
					int k = n/2;
					fib[n] = (2*fib(k-1)+fib(k))*fib(k);
				}else {
					int k = (n+1)/2;
					fib[n] = (fib(k)*fib(k)) + (fib(k-1)*fib(k-1));
				}
				
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

package arrays_strings;

public class A3 {
	public static void main(String[] args) {
		printer("Mr John Smith");
	}
	private static void printer(String input) {
		input = input.replaceAll(" ", "%20");
		System.out.println(input);
	}
}

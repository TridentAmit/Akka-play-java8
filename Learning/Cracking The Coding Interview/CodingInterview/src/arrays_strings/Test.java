package arrays_strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		System.out.println("Enter input..");
		Scanner sc = new Scanner(System.in);
		int numberOfOpression = sc.nextInt();
		//System.out.println(numberOfOpression);
		//String[]opressions = new String[numberOfOpression];
		List<String> opressions = new ArrayList<>();
		for(int i = 0;i<numberOfOpression;i++) {
			opressions.add(sc.next());
		}
		System.out.println(opressions);
		int numberOfInput = sc.nextInt();
		//int[]numbers = new int[numberOfInput];
		List<Integer> numbers = new ArrayList<>();
		for(int i = 0;i<numberOfInput;i++) {
			numbers.add(sc.nextInt());
		}
		System.out.println(numbers);
		System.out.println(getOutPut(opressions, numbers));
	}
	private static List<Integer> getOutPut(List<String> ops,List<Integer> nums) {
		List<Integer> list = new ArrayList<>();
		Stack<Integer> s = new Stack<>();
		List<Integer> list1 = new ArrayList<>();
		int count = 0;
		for(String op:ops) {
			if(op.equalsIgnoreCase("push")) {
				list1.add(nums.get(count));
				int max = list1.stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax();
				int min = list1.stream().collect(Collectors.summarizingInt(Integer::intValue)).getMin();
				list.add(max*min);
			}else {
				list1.remove(nums.get(count));
				int max = list1.stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax();
				int min = list1.stream().collect(Collectors.summarizingInt(Integer::intValue)).getMin();
				list.add(max*min);
			}
			count++;
		}
		
		
		
		return list;
	}

}

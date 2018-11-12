package arrays_strings;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A {
	public static void main(String[] args) {

	      Scanner in = new Scanner(System.in);
	      int[] proportions = Arrays.stream(in.nextLine().split(", ")).mapToInt(Integer::valueOf).toArray();
	      int[] availableGrams = Arrays.stream(in.nextLine().split(", ")).mapToInt(Integer::valueOf).toArray();
	      in.close();
	      int[] remainder = calculateRemainders(proportions,availableGrams) ;
	      
	      System.out.println(Arrays.stream(remainder)
	                         .mapToObj(String::valueOf)
	                         .collect(Collectors.joining(", ")));
	}
	public static int[] calculateRemainders(int[] proportions, int[] availableGrams) {
		int[] remaining_grams = new int[proportions.length];
	    for(int i=0;i<proportions.length;i++) {
		remaining_grams[i] = availableGrams[i]/proportions[i];
	    }
	    int min = Arrays.stream(remaining_grams).min().getAsInt();
	    for(int i=0;i<proportions.length;i++) {
		remaining_grams[i] = availableGrams[i]-min*proportions[i];
	    }
	    return remaining_grams;
	}
}

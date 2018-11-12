package workStream;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class Main {
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1,2,3);
		List<Integer> list2 = Arrays.asList(3,4);
		list1.stream().flatMap(i-> list2.stream().filter(j -> (i+j) % 3 == 0).map(j -> new Integer[] {i,j})).collect(toList());
		list1.stream().flatMap(i-> list2.stream().filter(j -> (i+j) % 3 == 0).map(j -> new Integer[] {i,j})).forEach(x -> System.out.println(Arrays.toString(x)));
		list1.stream().reduce(Integer::max).ifPresent(System.out::print);
		//.ifPresent(System.out::println);;
	}

}

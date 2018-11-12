package startStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

import model.Dish;
import util.LoadData;

public class Main {
	public static void main(String[] args) {
		LoadData.loadDishData().stream().collect(Collectors.groupingBy(Dish::getType)).forEach((key,value)->System.out.println(key+"__"+value));
		System.out.println("=============");
		LoadData.loadDishData().stream().filter((dish)->dish.getCalories()>100).limit(3).forEach(System.out::println);
		System.out.println("Map..................");
		List<String> words = Arrays.asList("Hello","Bello");
		List<Integer> wordCount = words.stream().map(String::length).collect(toList());
		System.out.println(wordCount);
		System.out.println("flatMap...............");
		String s = "Abc";
		s.toCharArray();
		s.split("");
		words.stream().map(w -> w.split(""))
		.map((String[] x) -> {
			return Arrays.stream(x);
		}).flatMap(y -> y).forEach(System.out::println);
	}

}

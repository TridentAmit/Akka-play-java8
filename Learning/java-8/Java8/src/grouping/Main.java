package grouping;

import util.LoadData;
import static java.util.stream.Collectors.groupingBy;

import model.Dish;

public class Main {
	public static void main(String[] args) {
		LoadData.loadDishData().stream()
		.collect(groupingBy(Dish::getType
							,groupingBy((Dish dish) ->{
								if(dish.getCalories()<=400) return "DIET";
								else return "FAT";
		})))
		.forEach((key,value) ->System.out.println("Key is :"+key+"sValue is :"+value));
		System.out.println("Partitioning..........");
		LoadData.loadDishData().stream()
			.collect(groupingBy(Dish::isVeg)).forEach((key,value) ->System.out.println("Key is :"+key+"sValue is :"+value));
	}

}

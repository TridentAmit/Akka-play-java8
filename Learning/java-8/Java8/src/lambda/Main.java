package lambda;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import model.Apple;
import model.Mango;
import util.LoadData;

import static java.util.Comparator.comparing;


public class Main {
	
	public static void main(String[] args) {
		
		showApplesOnDemand(LoadData.loadAppleData(),appleOptional -> appleOptional.flatMap(apple -> apple.getColor()).filter(color -> color.equalsIgnoreCase("Red")).ifPresent(System.out::println));
		showApplesOnDemand(LoadData.loadAppleData(),appleOptional -> appleOptional.flatMap(apple -> apple.getColor()).filter(color -> color.equalsIgnoreCase("Green")).ifPresent(System.out::println));
		showApplesOnDemand(LoadData.loadAppleData(),appleOptional -> appleOptional.flatMap(apple -> apple.getWt()).filter(wt -> wt>=150).ifPresent(System.out::println));
		System.out.println("Mango sorted by Wt...");
		LoadData.loadMangoData().stream().sorted(comparing(Mango::getWt)).forEach(System.out::println);
		System.out.println("Mango Sorted by name....");
		LoadData.loadMangoData().stream().sorted(comparing(Mango::getName)).forEach(System.out::println);
	}
	private static void showApplesOnDemand(List<Optional<Apple>> appleList,Consumer<Optional<Apple>> consumer) {
		appleList.stream().forEach(consumer);
	}
}

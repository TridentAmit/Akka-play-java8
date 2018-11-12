package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import model.Apple;
import model.Dish;
import model.Mango;
import startStream.Type;

public class LoadData {
	public static List<Optional<Apple>>loadAppleData() {
		Optional<Apple> apple1 = Optional.ofNullable(new Apple(100,"Green"));
		Optional<Apple> apple2 = Optional.ofNullable(new Apple(150,"Green"));
		Optional<Apple> apple3 = Optional.ofNullable(new Apple(100,"Red"));
		Optional<Apple> apple4 = Optional.ofNullable(new Apple(200,"Red"));
		Optional<Apple> apple5 = Optional.ofNullable(new Apple());
		List<Optional<Apple>> appleList = new ArrayList<>();
		appleList.add(apple1);
		appleList.add(apple2);
		appleList.add(apple3);
		appleList.add(apple4);
		appleList.add(apple5);
		return appleList;
	}
	public static List<Mango>loadMangoData() {
		Mango mango1 = new Mango(120,"Dashari");
		Mango mango2 = new Mango(140,"Maldah");
		Mango mango3 = new Mango(100,"Sukul");
		Mango mango4 = new Mango(130,"Bambaiya");
		Mango mango5 = new Mango(120,"Dudhiya maldah");
		List<Mango> mangoList = new ArrayList<>();
		mangoList.add(mango1);
		mangoList.add(mango2);
		mangoList.add(mango3);
		mangoList.add(mango4);
		mangoList.add(mango5);
		return mangoList;
	}
	public static List<Dish> loadDishData(){
		
		return Arrays.asList(new Dish("Pork",false,800,Type.MEAT)
				,new Dish("Beef",false,700,Type.MEAT)
				,new Dish("Chicken",false,400,Type.MEAT)
				,new Dish("French fries",true,530,Type.OTHER)
				,new Dish("Rice",true,350,Type.OTHER)
				,new Dish("Friut",true,120,Type.OTHER)
				,new Dish("Pizza",true,550,Type.OTHER)
				,new Dish("Prawns",false,300,Type.FISH)
				,new Dish("Salmon",false,450,Type.FISH));
	}

}

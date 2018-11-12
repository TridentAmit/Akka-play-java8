package model;

import startStream.Type;

public class Dish {
	private final String name;
	private final boolean isVeg;
	private final int calories;
	private final Type type;
	public Dish(String name, boolean isVeg, int calories, Type type) {
		super();
		this.name = name;
		this.isVeg = isVeg;
		this.calories = calories;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public boolean isVeg() {
		return isVeg;
	}
	public int getCalories() {
		return calories;
	}
	public Type getType() {
		return type;
	}
	@Override
	public String toString() {
		return "Dish [name=" + name + ", isVeg=" + isVeg + ", calories=" + calories + "]";
	}
	
}

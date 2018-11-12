package model;

import java.util.Optional;

public class Apple {
	private Optional<Integer> wt = Optional.empty();
	private Optional<String> color = Optional.empty();
	public Apple(int wt,String color) {
		super();
		this.wt = Optional.ofNullable(wt);
		this.color = Optional.ofNullable(color);
	}
	public Apple() {
	}
	public Optional<Integer> getWt() {
		return wt;
	}
	public void setWt(int wt) {
		this.wt = Optional.ofNullable(wt);
	}
	public Optional<String> getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = Optional.ofNullable(color);
	}
	@Override
	public String toString() {
		return "Apple [wt=" + wt + ", color=" + color + "]";
	}
	

}

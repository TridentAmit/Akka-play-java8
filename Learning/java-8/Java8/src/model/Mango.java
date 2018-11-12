package model;

public class Mango {
	
	private String name;
	private int wt;
	public Mango(int wt,String name) {
		super();
		this.name = name;
		this.wt = wt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWt() {
		return wt;
	}
	public void setWt(int wt) {
		this.wt = wt;
	}
	@Override
	public String toString() {
		return "Mango [name=" + name + ", wt=" + wt + "]";
	}
}

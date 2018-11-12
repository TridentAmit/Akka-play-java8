package compStage;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.Dish;
import util.LoadData;

public class Main {
	public static void main(String[] args) throws Exception{
		//ExecutorService pool = Executors.newFixedThreadPool(5);
		getDishList().thenAcceptAsync(op -> 
			op.orElse(new ArrayList<Dish>()).forEach(l -> System.out.println(Thread.currentThread() +" Data :"+l)));
		
		//c
		
		new Thread(()->{
			while(true) {
				System.out.println(Thread.currentThread() +"In side thread");
				break;
			}
		}).start();
		
		System.out.println(Thread.currentThread()+"After");
		//Thread.sleep(10);
		
	}
	
	
	
	static CompletionStage<Optional<List<Dish>>> getDishList(){
		return CompletableFuture.supplyAsync(()->Optional.ofNullable(LoadData.loadDishData()));
				
	}
	static  CompletionStage<Optional<List<Dish>>> gethighestCalorieDishes(Optional<List<Dish>> dishList) {
		return CompletableFuture.supplyAsync(()->Optional.ofNullable( dishList.map(list -> list.stream().filter((Dish dish) -> dish.getCalories()>= 500))
				.get().collect(toList())));
	}
	static CompletionStage<Optional<List<Dish>>> getMeatTypeDishe(Optional<List<Dish>> dishList) {
		return CompletableFuture.supplyAsync(()->Optional.ofNullable( dishList.map(list -> list.stream().filter((Dish dish) -> dish.isVeg()))
				.get().collect(toList())));
	}

}

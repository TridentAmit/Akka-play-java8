import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;

/*
 * Problem statement: Use of invokeAll
 */
public class Listing517 {

	static ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	static Function<Integer,Boolean> isEven = (Integer i) ->{
		boolean flag = false;
		if(i % 2 == 0) flag = true;
		return flag;
	};
	
	public static void main(String[] args) throws InterruptedException,ExecutionException{
		List<Task> task = new ArrayList<>();
		for(int i=1;i<=1000;i++) {
			task.add(new Task(i));
		}
		List<Future<Boolean>> results = exec.invokeAll(task);
		for(Future<Boolean> future: results) {
			boolean flag = future.get();
			System.out.println(flag);
		}
		exec.shutdown();
		
	}
}
class Task implements Callable<Boolean> {
	private int num;
	public Task(int num) {
		this.num = num;
	}
	public Boolean call() {
		return Listing517.isEven.apply(num*num);
	}
}

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BiFunction;
import java.util.function.Function;

/*
 * Problem statement :
 * Calculate and return all prime numbers between given number
 * with the help of executor framework.
 */
public class Listing515 {
	static ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	int num;
	Listing515(int i) {
		this.num = i;
	}
	
	static Function<Integer,Boolean> isPrimeFunc = (Integer i) ->{
		boolean flag = true;
		for(int n = 2; n <= i/2 ; n++) {
			if(i % n == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	};
	
	static BiFunction<Integer,Function<Integer, Boolean>,List<Integer>> getPrimeFunc = (Integer i, Function<Integer,Boolean> isPrime) ->{
		List<Integer> primeNumbers = new ArrayList<>();
		for(int n=i ;n < (i+100); n++) {
			if(isPrime.apply(n)) {
				primeNumbers.add(n);
			}
		}
		return primeNumbers;
	};
	
	Callable<List<Integer>> call = () ->{
		return getPrimeFunc.apply(num, isPrimeFunc);
	};
	public static void main(String[] args) throws InterruptedException,ExecutionException {
		int n1 = 1;
		int n2 = 400;
		ExecutorCompletionService<List<Integer>> completionService = new ExecutorCompletionService<>(service);
		List<Future<List<Integer>>> futures = new ArrayList<>();
		for(int j = n1 ; j<= n2 ; ) {
			futures.add(completionService.submit(new Listing515(j).call));
			j = j+100;
		}
		for(Future<List<Integer>> future : futures) {
			System.out.println("Prime Numbers are :"+future.get());
		}
		
		/*for(int k=1 ;k<=(n2-n1)/100; k++) {
			Future<List<Integer>> future1 = completionService.take();
			System.out.println("Prime Numbers are :"+future1.get());
		}*/
		service.shutdown();
		
	}
	

}

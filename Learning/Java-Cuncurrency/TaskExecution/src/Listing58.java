import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Listing58 {
	private static ExecutorService exec1 = Executors.newFixedThreadPool(5);
	private static ExecutorService exec2 = Executors.newFixedThreadPool(5);
	public static void main(String[] args) throws Exception{
		exec1.execute(()->{
			while(true) {
				System.out.println("Running11....");
			}
		});
		
		exec1.shutdownNow();
		exec2.shutdown();
		exec2.execute(()->{
			while(true) {
				System.out.println("Running22....");
			}
		});
		
		
		exec2.shutdownNow();
		
	}

}
/*
 * Conclusion : shutDown()/shutDownNow() methods doesn't give the guarantee to
 * stop the execution.
 * shutDown() -> No new task will be accepted but previously submitted tasks are allowed to complete.
 * shutdownNow() -> No new task will be accepted and it initiates an abrupt shut down.
 */

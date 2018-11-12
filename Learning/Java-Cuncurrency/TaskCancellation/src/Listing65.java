
public class Listing65 {

	public static void main(String[] args) {
		T1 t1 = new T1();
		T2 t2 = new T2(t1);
		t1.start();
		t2.start();
	}
}
class T1 extends Thread {
	
	int count = 0;
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			System.out.println("Thread T1 running :"+count);
			count++;
		}
	}
}

class T2 extends Thread {
	T1 t1;
	public T2(T1 t1) {
		this.t1 = t1;
	}
	public void run() {
		int count = 0;
		while(!Thread.currentThread().isInterrupted()) {
			System.out.println("Thread T2 running :"+count);
			count++;
			if(count == 1000) {
				t1.interrupt();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

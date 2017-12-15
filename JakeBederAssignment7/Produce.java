import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Produce implements Runnable {
	public Produce(LinkedBlockingQueue<String> LinkedBlock) {
		linkedBlock = LinkedBlock;
	}
	private final LinkedBlockingQueue<String> linkedBlock;
	
	
	public static int total = 0;
	@Override
	public void run() {
		

		String bigString = "";
		for (int i = 1; i <= 1000; i++) {
			total +=1;
			Double Rand = Math.random();
			bigString = Rand.toString();
			if (i % 100 == 0) System.out.println("Producer produced: " + i + " events");
			try {
				linkedBlock.put(bigString);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Did not work.");
				e.printStackTrace();
			}
	}
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Allows consumers to finish consumer before the summary prints
		System.out.println("Summary:");
		System.out.println("Producer produces: " + total + " events");
		LinkedBlock.trueFalse = true;
}
	
}

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Consume implements Runnable{
	public Consume(LinkedBlockingQueue<String> LinkedBlock, String name) {
		linkedBlock = LinkedBlock;
		_name = name;
	}
	private final LinkedBlockingQueue<String> linkedBlock;
	//private static final Object mutex = new Object();
	
	private String _name = "";
	int total = 0;
	
	
	
	private static Random rand= new Random();
	//Used CodeJava to help as a template for Producer and Consumer
	//http://www.codejava.net/java-core/collections/java-producer-consumer-examples-using-blockingqueue
	@Override
	public void run() {
	
		
		while(!LinkedBlock.trueFalse || linkedBlock.size() !=0) {
			try {
				
				Thread.sleep(rand.nextInt(10));
				if(linkedBlock.poll() != null) {
					
						total += 1;
						
						
					
				}
				
				if (total % 100 == 0) { 
					System.out.println("Consumer " + _name + ": " + total + " events consumed");
				}
				
			
			}catch(InterruptedException e){
				
			}
		
	}
		
		
		
		System.out.println("Consumer " + _name + " consumes: " + total + " events");
		
	}

}
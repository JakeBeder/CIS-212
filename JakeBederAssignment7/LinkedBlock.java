import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
public class LinkedBlock {
	public static LinkedBlock linkedBlock;
	public static boolean trueFalse = false;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		LinkedBlockingQueue<String> linkedBlock = new LinkedBlockingQueue<String>(100);
		
		Produce Produce1 = new Produce(linkedBlock);
		Consume Consume1 = new Consume(linkedBlock, "Consumer 1");
		Consume Consume2 = new Consume(linkedBlock, "Consumer 2");
		Consume Consume3 = new Consume(linkedBlock, "Consumer 3");
		Consume Consume4 = new Consume(linkedBlock, "Consumer 4");
		
		ExecutorService e = Executors.newCachedThreadPool();
		e.execute(Produce1);
		Thread.sleep(4);
		//GTF helped with .sleep method to make sure consumers don't get executed too early.
		e.execute(Consume1);
		e.execute(Consume2);
		e.execute(Consume3);
		e.execute(Consume4);
		
		
		
		e.shutdown();
		
}}
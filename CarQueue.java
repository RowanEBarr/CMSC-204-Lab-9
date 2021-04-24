import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CarQueue {
	
	 Queue<Integer> carQueue= new LinkedList<>();
	 Random rand = new Random();
	
	public CarQueue ()
	{
		carQueue.add(rand.nextInt(4));
		carQueue.add(rand.nextInt(4));
		carQueue.add(rand.nextInt(4));
		carQueue.add(rand.nextInt(4));
		carQueue.add(rand.nextInt(4));
		carQueue.add(rand.nextInt(4));
	}

	public void addToQueue ()
	{
		class runCar implements Runnable {
			
			
			public void run() {
				
				try 
				{
					carQueue.add(rand.nextInt(4));
					Thread.sleep(100);
				} 
				catch (InterruptedException e) 
				{
				
				}
			}

		}
		Runnable r = new runCar();
	    Thread t = new Thread(r);
	    t.start();
		
	}
	
	public int deleteQueue ()
	{
		return carQueue.remove();
	}
}



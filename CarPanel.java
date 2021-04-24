import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
*/
public class CarPanel extends JComponent
{  
	private Car car1;
	private int x,y, delay;
	private CarQueue carQueue;
	private int direction;
	
	CarPanel(int x1, int y1, int d, CarQueue queue)
	{
		delay = d;
        x=x1;
        y=y1;
        car1 = new Car(x, y, this);
        carQueue = queue;
	}
	public void startAnimation()
	   {
	      class AnimationRunnable implements Runnable
	      {
	         public void run()
	         {
	            try
	            {
	               for(int i=0;i<10;i++)
	               {
	            	   carQueue.addToQueue();
	            	   direction = carQueue.deleteQueue();
	            	   if (x <= 0)
	            	   {
	            		   x += 30;
	            		   if (y <= 0)
		            	   {
		            		   y += 30;
		            	   }
	            		   if (y >= 400)
		            	   {
		            		   y -= 30;
		            	   }
	            	   }
	            	   
	            	   else if (x >= 300)
	            	   {
	            		   x += 30;
	            		   if (y <= 0)
		            	   {
		            		   y += 30;
		            	   }
	            		   if (y >= 400)
		            	   {
		            		   y -= 30;
		            	   }
	            	   }
	            	   
	            	   else if (y <= 0)
	            	   {
	            		   y += 30;
	            	   }
	            	   else if (y >= 400)
	            	   {
	            		   y -= 30;
	            	   }
	            	   
	            	   else 
	            	   {
	            		   if (direction == 0)
		            	   {
		            		   y = y + 30;
		            	   }
		            	   else if (direction == 1)
		            	   {
		            		   y = y + 30;
		            	   }
		            	   else if (direction == 2)
		            	   {
		            		   x = x + 30;
		            	   }
		            	   else
		            	   {
		            		   x = x - 30;
		            	   }
	            	   }	  
	        
	            	   repaint();
	            	   Thread.sleep(delay*1000);   
	               }
	            }
	            catch (InterruptedException exception)
	            {
	            	
	            }
	            finally
	            {
	            	
	            }
	         }
	      }
	      
	      Runnable r = new AnimationRunnable();
	      Thread t = new Thread(r);
	      t.start();
	   }
	
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;

      car1.draw(g2,x,y);    
   }
}

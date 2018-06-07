
import java.util.concurrent.*;


public class MarketNewsCallable implements Callable<Integer> {
            

    public Integer call() throws Exception {
             for (int i=0; i<10;i++){
              Thread.sleep (1000);  // sleep for 1 second
              System.out.println("The market is improving " + i);
             }
              // Just return some number to illustrate return
              return 12345;
	}

}
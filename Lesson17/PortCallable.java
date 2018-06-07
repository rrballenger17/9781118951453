

import java.util.concurrent.*;


public class PortCallable implements Callable<Integer> {
            

    public Integer call() throws Exception {

		for (int i=0; i<10;i++){
			Thread.sleep (700);    // Sleep for 700 milliseconds
			System.out.println("You have " +  (500 + i) + " shares of IBM");
		}

		return 10;
	}


}
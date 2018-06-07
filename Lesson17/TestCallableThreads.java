
import java.util.concurrent.*;
import java.util.*;

public class TestCallableThreads {
    
    public static void main(String[] args)
                        throws InterruptedException, ExecutionException {

          Callable<Integer> mn = new MarketNewsCallable();
          Callable<Integer> port = new PortCallable();


          // Future<Integer> - sort of the output/end of the thread
		 List<Future<Integer>> futures =
  			new ArrayList<Future<Integer>>();
 
 		// A placeholder for results returned by threads
 		List<Integer> results = new ArrayList<Integer>();

 		// executor service - thread pool 
		final ExecutorService service = Executors.newFixedThreadPool(2);

		// future.get() and store int result
		try {
  			futures.add(service.submit(port));
  			futures.add(service.submit(mn));
  			for (Future<Integer> future : futures) {
   				results.add(future.get());
			}
		} finally {
			// executor service shutdown
   			service.shutdown();
		}

		for (Integer res: results){
   			System.out.println("\nGot the result: " + res);
		} 
	}
}


import java.util.*;
import java.util.function.Supplier;
import java.time.*;
import java.util.stream.Stream;

public class BeerDemo {
        // Populate beer collection
        static List<Beer> loadCellar(){
          List<Beer> beerStock = new ArrayList<>();
          beerStock.add(new Beer("Stella", "Belgium", 7.75f));
          beerStock.add(new Beer("Sam Adams", "USA", 7.00f));
          beerStock.add(new Beer("Obolon", "Ukraine", 4.00f));
          beerStock.add(new Beer("Bud Light", "USA", 5.00f));
          beerStock.add(new Beer("Yuengling", "USA", 5.50f));
          beerStock.add(new Beer("Leffe Blonde", "Belgium", 8.75f));
          beerStock.add(new Beer("Chimay Blue", "Belgium", 10.00f));
          beerStock.add(new Beer("Brooklyn Lager", "USA", 8.25f));
          return beerStock;
        }



	public static void main(String[] args) {
		List<Beer> beers = loadCellar();

        System.out.println("");
		System.out.println("For the following beers (by county and price): ");

		beers.stream()
		.sorted(Comparator.comparing((Beer b) -> b.country)
		.thenComparing(b -> b.price))
		.forEach(System.out::println);
        
        OptionalDouble avg = beers.stream()
        .filter(beer -> "USA".equals(beer.country))
        .mapToDouble(beer -> beer.price)
        .average();

        System.out.println("");
        System.out.println("Average USA Beer price: " + avg.toString());


        System.out.println("");
        System.out.println("Now printing the current time ten times...");
 			// Implementing a Supplier interface
		Supplier<LocalDateTime> myStopWatch = () -> {
			try{
				Thread.sleep(1000);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			
			return LocalDateTime.now(); // get the current time
		};

		Stream<LocalDateTime> timeStream = Stream.generate(myStopWatch).limit(10);

		timeStream.forEach(System.out::println);

    }
}










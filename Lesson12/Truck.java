import java.util.*;

public class Truck<T> {

	private List<T> products = new ArrayList<>();
    
    // load the product on the truck
	public void add (T t){
		products.add(t);
	}
           
    // Return products loaded on the truck
	public List<T> getProducts(){
		return products;
	}

}

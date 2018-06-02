import java.util.*;

public class TestGenericType {

	public static void main(String[] args) {
		Truck<Product> shipment = new Truck<>();
		Bike bike = new Bike();
		Wheel wheel = new Wheel();
		
		shipment.add(bike);
		shipment.add(wheel);


		int count = 0;
		for(Product p: shipment.getProducts()){

			System.out.println("ID: " + ++count + ", Type: " + p.getTypeName());
		}
		// shipment.add(person); // Compiler error
	} 

}





public class Contractor extends Person implements Payable{


	public Contractor(String name){
		super(name);
	}

	public boolean increasePay(int percent){

		if(percent > Payable.INCREASE_CAP){

			String message = "Sorry, can't increase hourly rate by more than 20%. " + getName();
			System.out.println(message);
			return false;
		}else{
			System.out.println("Increasing salary by " + percent + "%. "+ getName());
		}


		return true;
	}

}
 import java.io.*;

	class Deserialize {
		
		public static void main(String args[]){


			Employee bestEmp = null;

			// file input stream opens file
			// object input stream - takes previous
			// oIn read object 
 			try ( FileInputStream fIn =
                            new  FileInputStream("BestEmployee.ser");
                   ObjectInputStream oIn = new ObjectInputStream(fIn);
               	){
							
					bestEmp=(Employee)oIn.readObject();

             }catch (ClassNotFoundException cnf){
                 cnf.printStackTrace();
             } catch (IOException ioe){
               ioe.printStackTrace();
			}

			if(bestEmp != null){

             	System.out.println(
                             "The Employee  object has been deserialized.");
             	System.out.println("First: " + bestEmp.fName + ", Last: " + bestEmp.lName + ", Salary: " + bestEmp.salary);
             }
	}
 }

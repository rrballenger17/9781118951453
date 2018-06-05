import java.io.*;

class Serialize {
            public static void main(String args[]){
              Employee emp = new Employee();
              emp.fName = "John";
              emp.lName = "Smith";
              emp.salary = 50000;

              // file output stream - creates file
              // object output stream - the previous
              //    oOut.writeObject
              try (FileOutputStream fOut =
                                 new FileOutputStream("BestEmployee.ser");
                   ObjectOutputStream oOut =
                                          new ObjectOutputStream(fOut);
                  ){
                
                oOut.writeObject(emp);  //serializing employee
             
             } catch (IOException ioe){
                
                ioe.printStackTrace();

             }
             System.out.println("Employee object has been serialized into BestEmployee.ser");

          } 

}
class TestTax{
     public static void main(String[] args){
            SmallerTax   t = new SmallerTax(70000, "Massachusetts", 0); // creating an instance
                             
            double yourTax = t.calcTax(); //calculating tax 
                            
           // Printing the result 
           System.out.println("Your tax is " + yourTax);
     } 
 }

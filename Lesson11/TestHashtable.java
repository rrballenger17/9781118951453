import java.util.*;

public class TestHashtable {


  

  public static void main(String[] args) {
    Map<String,String> passengerList = new Hashtable<String,String>();
    passengerList.put("305729", "Alex Smith");
    passengerList.put("027593","Mary Lou");
    passengerList.put("298385","Sim Monk");
    Iterator<String> iterator = passengerList.keySet().iterator();

    while(iterator.hasNext()){
      String id = iterator.next();
      System.out.println("ID: " +id +", Name: " + passengerList.get(id));
    } 

  }

}
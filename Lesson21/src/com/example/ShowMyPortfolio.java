package com.example;

public class ShowMyPortfolio {

	
    public static void main(String[] args) {
        
    	Runnable port = new Portfolio();
        Thread p = new Thread(port, "Portfolio Data");
        p.start();
        
        try{
        	   p.join();
        }catch (InterruptedException e){
        	   e.printStackTrace();
        }
    
    }

}
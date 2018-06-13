package com.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class StockServerImpl extends UnicastRemoteObject
implements StockServer {
	private String price=null;
	private ArrayList<String> nasdaqSymbols = new ArrayList<>();
	
	public StockServerImpl() throws RemoteException {
		super();
		// Define some hard-coded NASDAQ symbols
		nasdaqSymbols.add("AAPL");
		nasdaqSymbols.add("MSFT");
		nasdaqSymbols.add("YHOO");
		nasdaqSymbols.add("AMZN");
	}
	
	public String getQuote(String symbol)
            throws RemoteException {
		if(nasdaqSymbols.indexOf(symbol.toUpperCase()) != -1) {
			// Generate a random price for valid symbols
			price = (new Double(Math.random()*100)).toString();
			

		}
		
		System.out.println("Got the price quote request for " +
                symbol);
		
		return price;
	}
	public ArrayList<String> getNasdaqSymbols()
                     throws RemoteException {
		return nasdaqSymbols;
	}
}

	
	
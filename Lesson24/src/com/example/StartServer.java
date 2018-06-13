package com.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class StartServer {
	public static void main (String args[]) {
		try {
			// Create the registry on port 1099
			LocateRegistry.createRegistry(1098);
			// Instantiate the StockServerInmpl and bind it
			// to the registry under the name QuoteService
			StockServerImpl ssi = new StockServerImpl();
			Naming.rebind("rmi://localhost:1098/QuoteService",ssi);
		}catch (MalformedURLException e1){
           System.out.println(e1.getMessage());
		}catch(RemoteException ex) {
            ex.printStackTrace();
		}
	} 
}

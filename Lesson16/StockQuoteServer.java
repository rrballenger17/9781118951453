import java.io.*;
import java.net.*;

public class StockQuoteServer {
	

	public static void main(java.lang.String[] args) {
        // sockets
        ServerSocket serverSocket = null;
        Socket client = null;

        // reader
        BufferedReader inbound = null;

        // output stream (writer)
        OutputStream outbound = null;
        try {
        	
        	// server socket
        	serverSocket = new ServerSocket(3000);
         	System.out.println("Waiting for a quote request...");

         	while (true) {

         		// wait and accept connection 
         		// socket type for the connection
                client = serverSocket.accept();

                // get input stream from connection
                // input stream reader and buffered reader
                inbound = new BufferedReader(new InputStreamReader( client.getInputStream() ));

                // output stram to connection 
                outbound = client.getOutputStream();

                // read line for stock symbol 
                String symbol = inbound.readLine();

                //Generate a random stock price
                String price = (new Double(Math.random() * 100)).toString();

                // send response as bytes
                outbound.write(("\n The price of " + symbol +
                 " is " + price + "\n").getBytes());

                // print to console that message was sent
                System.out.println("Request for " + symbol +
                 " has been processed - the price of " + symbol +
                 " is " + price + "\n");

                // write End to the output
                outbound.write("End\n".getBytes());
        	}

        } catch (IOException ioe) {
        	System.out.println("Error in Server: " + ioe);
        
        } finally {
         	try {
                inbound.close();
                outbound.close();
         	} catch (Exception e) {
                System.out.println(
                 "StockQuoteServer: can't close streams" + e.getMessage());
         	}
        }
 	}


}
        
// Wait for a        request
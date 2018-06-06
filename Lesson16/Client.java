
import java.io.*;
import java.net.*;

public class Client {

    public static void main(java.lang.String[] args) {
        if (args.length==0){
            System.out.println("Usage: java Client Symbol");
            System.exit(-1);
        }

        // socket for connection
        Socket clientSocket = null;
    
        try{
              // open connection to domain name and port
            clientSocket = new Socket("localhost", 3000);
            System.out.println("Client: " + clientSocket);

        }catch (UnknownHostException uhe){
            System.out.println("UnknownHostException: " + uhe);
        } catch (IOException ioe){
            System.err.println("IOException: " + ioe);
        }

        // output stream
        // get input stream from connection, input stream reader, buffered reader
        try (OutputStream outbound = clientSocket.getOutputStream();
            BufferedReader inbound = new  BufferedReader(new
                InputStreamReader(clientSocket.getInputStream()));  
            ){
            
                // write the stock symbol to output
                outbound.write((args[0]+"\n").getBytes());
                
                // read response with quote
                // print to the console 
                // stop when End is read
                String quote;
                while (true){
                    quote = inbound.readLine();
                    if (quote.length() == 0) continue;
                    if (quote.equals("End")){
                        break;
                    }
                    System.out.println("Got the quote for " + args[0]+":" + quote);
                }

        }catch (IOException ioe){
                ioe.printStackTrace();
        }

    } 

}
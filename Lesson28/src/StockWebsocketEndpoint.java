import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import java.util.*;

@ServerEndpoint(value = "/stockprice")
public class StockWebsocketEndpoint {
	
	// for scheduling the update every 5 seconds
	static ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
	DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	StockPriceGenerator spg = new StockPriceGenerator();
	Map<Session, String> symbols = new HashMap<Session, String>();
	
	/** Generates price with StockPriceGenerator, returns price, and starts timer */
	@OnMessage
	public String getPriceQuote(String symbol, Session session){
		
		Stock stock = new Stock();
		stock.setSymbol(symbol);
		
		String price = spg.getQuote(stock);
		
		symbols.put(session, symbol);
	
		return symbol + ": " + price;
	}
	

	@OnOpen
	public void startTimer(Session session){
		timer.scheduleAtFixedRate(() -> sendPriceUpdate(session), 5, 5, TimeUnit.SECONDS);
	}
	
	
	/** Generates the price. Sends the price with session.getBasicRemote().sendText() */
	private void sendPriceUpdate(Session session){
		
		if(!symbols.containsKey(session)){
			return;
		}
		String symbol = symbols.get(session);
		Stock stock = new Stock();
		stock.setSymbol(symbol);
		String price = spg.getQuote(stock);
		
		try{
			session.getBasicRemote().sendText(symbol + ": " + price);
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
	
}
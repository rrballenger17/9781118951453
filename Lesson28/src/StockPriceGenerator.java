

import java.util.ArrayList;

public class StockPriceGenerator {
private String price=null;
private ArrayList<String> nasdaqSymbols = new ArrayList<>();

public StockPriceGenerator()  {
super();
// Define some hard-coded NASDAQ symbols
nasdaqSymbols.add("AAPL");
nasdaqSymbols.add("MSFT");
nasdaqSymbols.add("YHOO");
nasdaqSymbols.add("AMZN");
// extra comment
}


public String getQuote(Stock stock) {
if(nasdaqSymbols.indexOf(stock.getSymbol().toUpperCase()) != -1) {
// Generate a random price for valid symbols
price = (new Double(Math.random()*100)).toString();
}
return price;
}

public ArrayList<String> getNasdaqSymbols(){
return nasdaqSymbols;
}
}
import javax.jms.ConnectionFactory;

import javax.jms.*;
import javax.naming.*;

import com.sun.messaging.AdministeredObject;
import com.sun.messaging.ConnectionConfiguration;


public class DirectMessageSender{
        public static void main(String[] args){
          // Vendor-specific factory implementation
          ConnectionFactory factory=



                          new com.sun.messaging.ConnectionFactory();
             try(JMSContext context=factory.createContext("admin","admin")){
                ((AdministeredObject) factory).setProperty(ConnectionConfiguration.imqAddressList,
                                "mq://127.0.0.1:7676,mq://127.0.0.1:7676");
                Destination ordersQueue =
                                  context.createQueue("TradingOrdersQueue");
                JMSProducer producer = context.createProducer();
                // Send msg to buy 200 shares of IBM at market price
                producer.send(ordersQueue,"IBM 200 Mkt");
                System.out.println("Placed an order to purchase 200 shares of IBM to TradingOrdersQueue");
               } catch (JMSException e){
                         System.out.println("Error: " + e.getMessage());
				} 
		}
}
package java_reactive_demo.flux.hotcold.excercise;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import reactor.core.publisher.Flux;

public class RevenueService {
	
	// we create in memory database 
	
	private Map<String, Double> db = new HashMap<String, Double>();
	
	public RevenueService() {
		db.put("Kids", 0.0);
		db.put("Clothing", 0.0);
	}
	
	// we use this method for subscriber 
	public Consumer<PurchaseOrder> consumeOrderStreaming(){
		
		// we check in the producte category 
		
		return p -> {
			//System.out.println("Order-----" +p);
			db.computeIfPresent(p.getCategory(), (k,v)-> v + p.getPrice());
		};
	}
	
	
	//every 2 second we see the update from our db 
	public Flux<String> getRevenueDb(){
		return Flux.interval(Duration.ofSeconds(2))
		.map(x -> db.toString());
	}

}

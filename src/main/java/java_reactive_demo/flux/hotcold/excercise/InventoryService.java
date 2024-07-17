package java_reactive_demo.flux.hotcold.excercise;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import reactor.core.publisher.Flux;

public class InventoryService {
	
	// we create in memory database 
	
	private Map<String, Integer> db = new HashMap<>();
	
	public InventoryService() {
		
		// we supose iteam have 100 pcs
		db.put("Kids", 100);
		db.put("Clothing", 100);
	}
	
	// we use this method for subscriber 
	public Consumer<PurchaseOrder> consumeOrderStreaming(){
		
		// we check in the producte category 
		
		return p -> db.computeIfPresent(p.getCategory(), (k,v)-> v - p.getQty());
	}
	
	public Flux<String> getInventoryDb(){
		return Flux.interval(Duration.ofSeconds(2))
			.map(x -> db.toString());
	}

}

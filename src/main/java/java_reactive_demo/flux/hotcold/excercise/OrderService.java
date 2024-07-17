package java_reactive_demo.flux.hotcold.excercise;

import java.time.Duration;
import java.util.Objects;

import reactor.core.publisher.Flux;

public class OrderService {
	
	// We need streaming only one data 
	
	private Flux<PurchaseOrder> flux;
	
	public Flux<PurchaseOrder> getSteamingOrder(){
		if(Objects.isNull(flux)) {
			// it have someone order then it will call the getOrders() Method 
			// have anoth order this will use Method again 
			flux=getOrders();
		}
		// at the end it will return the same streaming Flux
		return flux;
	}
	
	
	// this method alway new flux but we don't want that 
	// we need only one flux that can remember history of order 
	private Flux<PurchaseOrder> getOrders(){
		return Flux.interval(Duration.ofMillis(100))
				// 1 minli second have some one order product
				.map(x -> new PurchaseOrder())
				.share();
	}
}

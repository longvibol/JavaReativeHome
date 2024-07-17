package java_reactive_demo.flux.batching.util;

import java.time.Duration;

import reactor.core.publisher.Flux;

public class OrderService {
	
	public Flux<PurchaseOrder> orderFlux(){
		return Flux.interval(Duration.ofMillis(1))
			.map(x -> new PurchaseOrder());
	}

}

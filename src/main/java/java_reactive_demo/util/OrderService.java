package java_reactive_demo.util;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

public class OrderService {

	// 1 user have 1 list of order:
	private static Map<Integer, List<Order>> db = new HashMap<>();
	
	// create static block 
	
	static {
		// user 1 have order list 1
		List<Order> list1 = List.of(
					new Order(1),
					new Order(1),
					new Order(1)
				);
		
		// user 2 have order list 2
		List<Order> list2 = List.of(
				new Order(2),
				new Order(2)	
			);
		db.put(1, list1);
		db.put(2, list2);
		
	}
	
	/*
	public Flux<Object> getOrder(int userId){
		return Flux.create(fluxSink ->{
			//db.get(userId).forEach(x -> fluxSink.next(x));
			
			db.get(userId).forEach(fluxSink::next);
			fluxSink.complete();
		})
				.delayElements(Duration.ofSeconds(1))
				;
	}
	
	*/
	
	public Flux<Order> getOrder(int userId){
		return Flux.create((FluxSink<Order>fluxSink) ->{
			//db.get(userId).forEach(x -> fluxSink.next(x));
			
			db.get(userId).forEach(fluxSink::next);
			fluxSink.complete();
		})
				.delayElements(Duration.ofSeconds(1))
				;
	}
	
	
}

package java_reactive_demo.flux.batching;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import java_reactive_demo.flux.batching.util.OrderProcess;
import java_reactive_demo.flux.batching.util.OrderService;
import java_reactive_demo.flux.batching.util.PurchaseOrder;
import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class PurchaseOrderAssignment {

	public static void main(String[] args) {

		/*
		for(int i =1; i<50; i++) {
			String category = Util.faker().commerce().department();
			System.out.println(category);
		}
		
		// Sports, Kids
		 
		 */
		
		OrderProcess orderProcess = new OrderProcess();
		
		// we want to group by category Kid and Sports and need to put our business logic : call our function
		Map<String, Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>>> map = Map.of(
				"Kids" , orderProcess.kidsProcessing(),
				"Sports" , orderProcess.sportsProcessing()
				);
		
		//Set<String> set = Set.of("Kids","Sports");
		
		Set<String> set = map.keySet();  //To get the key String from the Map
		
		OrderService orderService = new OrderService();
		
		Flux<PurchaseOrder> productDiscount = orderService		
			.orderFlux()
			.filter(p ->set.contains(p.getCategory()))
			.groupBy(p ->p.getCategory())
			.flatMap(gf -> map.get(gf.key()).apply(gf)); // 1. Function(we call apply function ; 2. map to the key then Flatmap to get publiser
			
//			.subscribe(Util.subcriber());		
		
		productDiscount
			.filter(p ->p.getCategory().equals("Sports"))
			.map(p -> p.getPrice()/0.5 + " - " + p.getCategory())	
			.subscribe(Util.subcriber());
		
		
		Util.sleep(10);		
		
	}


}

package java_reactive_demo.flux;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class Flux5FromRang {

	public static void main(String[] args) {
		
//		Flux<Integer> flux = Flux.range(1, 10);		
//		flux.subscribe(x -> System.out.println(x));				
		
		// rang = for loop
		Flux.range(1,10)
			.map(x -> x + " : "+ Util.faker().country().name())			
			.subscribe(x -> System.out.println("Country " +x));		
	}

}

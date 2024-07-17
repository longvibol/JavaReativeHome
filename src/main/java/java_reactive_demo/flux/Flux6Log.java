package java_reactive_demo.flux;

import java.util.List;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class Flux6Log {

	private static List<Integer> of;

	public static void main(String[] args) {
		
		Flux<Integer> flux = Flux.range(5, 10);				
		flux
			.log()
			.map(x -> Util.faker().country().name())
			.log()
			.subscribe(x -> System.out.println(x));		
		
	}

}

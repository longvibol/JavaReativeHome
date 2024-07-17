package java_reactive_demo.flux.operator;

import java.time.Duration;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class O7DefaultifEmpty {
	


	public static void main(String[] args) {
		
		// if the publicer does not produce any iteam we set the default value to the subcriber 
		
		getNumbers()
			.filter(x -> x>10)
			.defaultIfEmpty(100)
			.subscribe(Util.subcriber());

	}
	
	private static Flux<Integer> getNumbers(){
		return Flux.range(1, 10);
		
	}	

}

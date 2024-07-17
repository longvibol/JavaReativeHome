package java_reactive_demo.sinks;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.Many;

public class S4Unicast {

	public static void main(String[] args) {

		// sink = publisher
		Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer(); //unicast : one Sub and one Pub 
		
		// flux = subcirber 
		Flux<Object> flux = sink.asFlux();
		
		sink.tryEmitNext("Hello");
		sink.tryEmitNext("How are you !");
		
		flux.subscribe(Util.subcriber("Dara"));
		flux.subscribe(Util.subcriber("Thida")); // have two sub is error 
	}

}

package java_reactive_demo.sinks;

import java.time.Duration;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.Many;

public class S8BestEffort {

	public static void main(String[] args) {

		// sink = publisher
		Many<Object> sink = Sinks.many().multicast().directBestEffort();
		
		// flux = subcirber 
		Flux<Object> flux = sink.asFlux();
		
		
		flux.subscribe(Util.subcriber("Dara"));
		flux.delayElements(Duration.ofMillis(100)).subscribe(Util.subcriber("Rith"));  
		
		
		for (int i =0; i<100; i++) {
			sink.tryEmitNext(i);
		}
		
		Util.sleep(10);
	}

}










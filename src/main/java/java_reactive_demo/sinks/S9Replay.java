package java_reactive_demo.sinks;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.Many;

public class S9Replay {

	public static void main(String[] args) {

		// sink = publisher
		Many<Object> sink = Sinks.many().replay().all();
		
		// flux = subcirber 
		Flux<Object> flux = sink.asFlux();
		
		sink.tryEmitNext("Hello-1");
		sink.tryEmitNext("How are you ! - 2");
		
		flux.subscribe(Util.subcriber("1 Dara"));
		flux.subscribe(Util.subcriber("2 Rith"));  
		
		sink.tryEmitNext("? - 3");
		flux.subscribe(Util.subcriber("3 Thida")); 
		
		sink.tryEmitNext("for first sub - 4");
	}

}










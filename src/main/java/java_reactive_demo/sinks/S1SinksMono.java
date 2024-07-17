package java_reactive_demo.sinks;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.One;

public class S1SinksMono {

	public static void main(String[] args) {

		One<Object> sink = Sinks.one(); // sink handle with publisher or working with as publiser 
		Mono<Object> mono = sink.asMono(); // mono handle with subscirber 
		
		mono.subscribe(Util.subcriber("Dara"));
		
		sink.tryEmitEmpty();
	}

}

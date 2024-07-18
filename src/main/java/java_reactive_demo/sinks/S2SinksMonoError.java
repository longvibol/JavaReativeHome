package java_reactive_demo.sinks;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.One;

public class S2SinksMonoError {

	public static void main(String[] args) {

		One<Object> sink = Sinks.one(); // sink handle with publisher or working with as publiser 
		Mono<Object> mono = sink.asMono(); // mono handle with subscirber 
		
		mono.subscribe(Util.subcriber("Dara"));
		//mono.subscribe(Util.subcriber("Thida"));
		
		//sink.tryEmitValue("Hello world"); // Hello world emit to the subscriber so if have subscirber the subcriber will get this message
		//sink.tryEmitValue("How are you doing !"); // becaue it is mono so it have email only one time 

		sink.tryEmitError(new RuntimeException("Error from sink: ...!"));
		
	}

}

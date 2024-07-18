package java_reactive_demo.sinks;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.One;

public class S3EmitFailureHandle {

	public static void main(String[] args) {

		One<Object> sink = Sinks.one(); 
		Mono<Object> mono = sink.asMono(); 
		
		mono.subscribe(Util.subcriber("Dara"));
		
		sink.tryEmitValue("Hey");
		
		// emil Failure handler : when have probem then it will working 
		sink.emitValue("Hello Sunday", (signlType, emitResult) ->{		
			System.out.println(signlType.name());
			System.out.println(emitResult.name());
			return false;
		});
		
		
	}

}

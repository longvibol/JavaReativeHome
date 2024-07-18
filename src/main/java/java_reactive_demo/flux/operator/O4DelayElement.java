package java_reactive_demo.flux.operator;

import java.time.Duration;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.util.concurrent.Queues;

public class O4DelayElement {

	public static void main(String[] args) {
		
		System.setProperty("reactor.bufferSize.x", "10");		
		Flux.create(sink -> {			
			
			for(int i=1; i<=1000; i++) {
				sink.next(i);
			}
		})
		.log()
		.delayElements(Duration.ofSeconds(1))
		.subscribe(Util.subcriber());
		
		Util.sleep(60);
		
		//Util.sleep = we block the thread :[ INFO] (parallel-7) request(8)
		// Limite rate we set to 10 in the system.setProperty (75% of 10 is 8) then 8 it will request again 
		// Queues class in Java

		
	}


}

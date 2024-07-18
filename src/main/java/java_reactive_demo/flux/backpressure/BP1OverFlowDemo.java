package java_reactive_demo.flux.backpressure;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class BP1OverFlowDemo {

	public static void main(String[] args) {

		Flux.create(sink->{
			for(int i=0; i<501; i++) {
				System.out.println("Pushed: "+i);
				sink.next(i);
			}
			sink.complete();

		})
		
		.publishOn(Schedulers.boundedElastic())
		//we want to create senario when we save to Database then it take 10s to save 
		.doOnNext( x ->{
			Util.sleepMili(10);
		})
		.subscribe(Util.subcriber());
		
		Util.sleep(60);
		
	}

}

package java_reactive_demo.flux.backpressure;

import java.util.ArrayList;
import java.util.List;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.util.concurrent.Queues;

public class BP4OverflowCaptureDropValue {

	public static void main(String[] args) {
		
		System.setProperty("reactor.bufferSize.small", "16");
		
		List<Object> list = new ArrayList<>();

		Flux.create(sink->{
			for(int i=1; i<501; i++) {
				System.out.println("Pushed: "+i);
				sink.next(i);
				Util.sleepMili(1);
			}
			sink.complete();

		})
//		.onBackpressureDrop(valueDropped ->{
//			list.add(valueDropped);
//		})

		.onBackpressureDrop(list::add)  // Method reference 
		.publishOn(Schedulers.boundedElastic())
		.doOnNext( x ->{
			Util.sleepMili(10);
		})
		.subscribe(Util.subcriber());
		
		Util.sleep(5);
		
		System.out.println(list);
		
	}

}
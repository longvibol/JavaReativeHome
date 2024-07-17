package java_reactive_demo.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Consumer;

import reactor.core.publisher.FluxSink;

public class ColorProducer implements Consumer<FluxSink<String>>{

	private FluxSink<String> flusSink;
	
	
	//the same as constructor 
	@Override
	public void accept(FluxSink<String> t) {
		// TODO Auto-generated method stub
		this.flusSink = t;
		
	}
	
	public void produce() {
		String threadName = Thread.currentThread().getName();
	
		flusSink.next(LocalDateTime.now()+" - "+threadName + " - " + Util.faker().color().name());
	}

}

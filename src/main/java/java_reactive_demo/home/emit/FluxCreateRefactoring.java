package java_reactive_demo.home.emit;

import java_reactive_demo.home.helper.NameProducer;
import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class FluxCreateRefactoring {

	public static void main(String[] args) {

		NameProducer nameProducer = new NameProducer();
		
		Flux.create(nameProducer).subscribe(Util.subcriber());		
		nameProducer.produce();		
		// we call the : nameProducer at outside; we can serpeate the method and custome at outside 
		
		// Runnable runnable = () -> nameProducer.produce(); 
		
		Runnable runnable = nameProducer::produce;
		
		for(int i = 0; i <10; i++) {
			new Thread(runnable).start();
		}
		
	}

}

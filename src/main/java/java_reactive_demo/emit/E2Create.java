package java_reactive_demo.emit;

import java_reactive_demo.util.ColorProducer;
import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class E2Create {

	public static void main(String[] args) {

		/*
		 * //Emit function Flux.create(fluxSink ->{ fluxSink.next(1); fluxSink.next(3);
		 * }).subscribe(Util.subcriber());
		 */

		/*
		 * Flux.create(fluxSink ->{ String color = Util.faker().color().name();
		 * fluxSink.next(color);
		 * 
		 * 
		 * color = Util.faker().color().name(); fluxSink.next(color);
		 * 
		 * fluxSink.complete();
		 * 
		 * }).subscribe(Util.subcriber());
		 */

		/*
		 * Flux.create(fluxSink ->{ String color;
		 * 
		 * do { color = Util.faker().color().name(); fluxSink.next(color);
		 * 
		 * }while(!color.equals("yellow"));
		 * 
		 * fluxSink.complete();
		 * 
		 * }).subscribe(Util.subcriber());
		 * 
		 * 
		 * 
		 * 
		 * 
		 * Flux.create(colorProducer) .subscribe(Util.subcriber());
		 * 
		 * // We need to subsriber first then we can have service // It call Observable
		 * code
		 * 
		 * 
		 * 
		 * for(int i =0; i <=5;i++) { colorProducer.produce(); }
		 * 
		 */
		
		ColorProducer colorProducer = new ColorProducer();		
		Flux<String> flux = Flux.create(colorProducer);

		//Register subcriber firt 
		flux.subscribe(Util.subcriber("s1"));
		
		//then to show the result of our subcriber 
		
		colorProducer.produce();
		colorProducer.produce();
		colorProducer.produce();
		
		// FluxSink is the thread safe so we ca

	}

}





















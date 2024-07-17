package java_reactive_demo.emit;

import java_reactive_demo.util.DefaultSubcriber;
import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class E1CustomSubcriber {

	public static void main(String[] args) {

		Flux.range(0, 10)
			.map(x -> x+1)
			.map(x -> x + " : "+ Util.faker().country().name())			
			//.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
			.subscribe(new DefaultSubcriber());	
		
		Flux<Integer> flux = Flux.range(0, 10);
		
		flux.subscribe(Util.subcriber("S1"));
		flux.subscribe(Util.subcriber("S2"));
	}

}

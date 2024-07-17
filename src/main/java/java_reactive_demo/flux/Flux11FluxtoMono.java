package java_reactive_demo.flux;

import reactor.core.publisher.Flux;

public class Flux11FluxtoMono {

	public static void main(String[] args) {
		
		
		Flux<Integer> flux = Flux.just(2,4,5,6);
		
		flux
			.filter(x->x>3)
			.next() // where we conver from flux to mono
			.subscribe(x ->System.out.println(x));
			

	}


}

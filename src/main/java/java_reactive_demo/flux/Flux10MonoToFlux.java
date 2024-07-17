package java_reactive_demo.flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Flux10MonoToFlux {

	public static void main(String[] args) {
		
		Mono<Integer> mono = Mono.just(1);
		Flux<Integer> flux = Flux.just(1,2,3);
		
		
		//convert from mono to Flux 
		flux = flux.from(mono);		
		getName(flux);

	}

	public static void getName(Flux<Integer> flux) {

	}

}

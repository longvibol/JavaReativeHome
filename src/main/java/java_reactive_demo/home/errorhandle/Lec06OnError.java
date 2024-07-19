package java_reactive_demo.home.errorhandle;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec06OnError {

	public static void main(String[] args) {
		/*
		Flux.range(1, 10)
			.filter(i -> i>10)
//			.map(i -> 10/(5-i))
//			.onErrorReturn(20)
//			.onErrorResume(e ->fallBack())		
			.defaultIfEmpty(100)
			.subscribe(Util.subcriber());		
		*/
		
			
			Flux.range(1, 10)
			.filter(i -> i>10)
			.switchIfEmpty(fallBack())
			.subscribe(Util.subcriber());	

	}
	
	
		
		
		
	private static Mono<Integer> fallBack(){
		return Mono.fromSupplier(()->Util.faker().random().nextInt(100, 200));
	}

}

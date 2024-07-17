package java_reactive_demo.flux.operator;

import javax.management.RuntimeErrorException;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class O5OnError {
	
	//resilient : when meet error how the system handle it 
	

	public static void main(String[] args) {
		
		/*
		Flux.range(1, 10)
			.map(x -> (20/(6-x)))
//			.onErrorReturn(-1) : call back value set 
			.subscribe(Util.subcriber());
		*/
		
		/*
		Flux.range(1, 10)
		.map(x -> (20/(6-x)))
		.onErrorResume(e -> getFallback())
		.subscribe(Util.subcriber());
		*/
		
		Flux.range(1, 10)
		.map(x -> (20/(6-x)))
		.onErrorContinue((e,obj)->{
			System.out.println("Error No. : " + obj + " Root cause: "+e.getMessage());
		})
		.subscribe(Util.subcriber());
	}
	
	public static Mono<Integer> getFallback() {
		return Mono.fromSupplier(() -> Util.faker().random().nextInt(100, 200));
	}
}



















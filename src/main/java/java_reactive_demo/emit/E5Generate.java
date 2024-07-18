package java_reactive_demo.emit;

import java.util.function.BiFunction;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class E5Generate {
	public static void main(String[] args) {

		/*
		Flux.create(fluxSink ->{
			fluxSink.next(23);
			fluxSink.next(45);
			fluxSink.next(24);			
		}).subscribe(Util.subcriber());
		*/		
		
		/*
//		Method Generate : synchronousSink it Emit the same thing non stop 		
		Flux.generate(synchronousSink ->{		
			
			String name = Util.faker().country().name();			
			
			if(name.toLowerCase().equals("romania")) {
				System.out.println("Emitting: " +  name);
				synchronousSink.complete();				
			}else {
				synchronousSink.next(name);
			}			
			//synchronousSink.next("Vibol");
			//Util.sleep(1);			
			//synchronousSink.complete();
			//synchronousSink.error(new RuntimeException("Something wrong !! "));			
		})
		//.take(10)
		.subscribe(Util.subcriber());
		*/
		
		Flux.generate(() -> 1, (count, sink) ->{
			String name = Util.faker().country().name();	
			
			sink.next(count + " : "+name);
			
			if(count ==10) {
				sink.complete();
			}
			
			return count+1;
		}).subscribe(Util.subcriber());
		
		//consumer :receive 1 parameter(input) then consume
		//Callable : no parameter /no input 
		
	}
}

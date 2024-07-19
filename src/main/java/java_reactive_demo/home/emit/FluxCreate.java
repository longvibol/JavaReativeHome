package java_reactive_demo.home.emit;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class FluxCreate {

	public static void main(String[] args) {	
		
		/*
		Flux.create(fluxSink -> {
			String country;			
			do {				
				country = Util.faker().country().name();
				fluxSink.next(country);
				
			} while (!country.toLowerCase().equals("cambodia") && !fluxSink.isCancelled());			
		})
		.take(3)		
		.subscribe(Util.subcriber());
	}
	
		
		Flux.generate(fluxSink ->{
			
			String country;	
			country = Util.faker().country().name();	
			System.out.println("emitting "+country);
			fluxSink.next(country);
			
			if (country.toLowerCase().equals("canada"))
				fluxSink.complete();
			
		})		
		
		.subscribe(Util.subcriber());
		
		*/
		
		Flux.generate(
			() -> 1, 	
			
			(count, fluxSink) -> {					
				String country;	
				country = Util.faker().country().name();
				
				fluxSink.next("Country Name: " +count +" = "+country);
				
				if (country.toLowerCase().equals("canada") || count >=10)
					fluxSink.complete();
				
			return count +1;
			
		})
		.subscribe(Util.subcriber());
		;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

package java_reactive_demo.flux.operator;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class O1Handle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//handle = filter (condition) + map (trnsform)
		// filter is produce=create not consume 
		
		/*
		Flux.range(1, 20)
			.handle((number,sink)->{
				if(number % 2 ==0) {
					sink.next(number);
				}else {
					sink.next(number+"-bb");
				}
			})
			.subscribe(Util.subcriber());
		*/
		
		Flux.generate(sink ->{
			String name = Util.faker().country().name();
			sink.next(name);			
		})
		// we want to convert from object type to String then we use .map
		//.map(x->x.toString())
		.map(Object::toString)
		.handle((countryName, sink)->{
			if(countryName.toLowerCase().equals("kuwait")) {
				System.out.println("Emitting: "+countryName);
				sink.complete();
			}else {
				sink.next(countryName);
			}
		})
		.subscribe(Util.subcriber());
		
		
	}

}
















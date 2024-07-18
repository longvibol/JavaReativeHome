package java_reactive_demo.flux;

import reactor.core.publisher.Flux;

public class Flux2MultipleSubscriber {

	public static void main(String[] args) {
		
		//public Iteam 1,2,3,4 
		
		Flux<Integer> flux = Flux.just(1,2,3,4);
		
		flux.subscribe(x->System.out.println("Sub A: "+x));
		
		System.out.println("------------");
		
		flux
			.filter(x ->x%2 ==0)
			.subscribe(x->System.out.println("Sub B: "+x));
		
		
	
	}

}

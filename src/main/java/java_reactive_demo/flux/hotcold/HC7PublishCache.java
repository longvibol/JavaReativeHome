package java_reactive_demo.flux.hotcold;

import java.time.Duration;
import java.util.stream.Stream;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class HC7PublishCache {

	public static void main(String[] args) {
		
		Flux<String> flux = Flux.fromStream(() ->getMovies())
				.delayElements(Duration.ofSeconds(1))			
				.cache(2);	
		
		Util.sleep(1);
		flux.subscribe(Util.subcriber("Dara"));
		
		Util.sleep(10);
		System.out.println("Thida is about to join ....");
		flux.subscribe(Util.subcriber("Thida"));
		
		Util.sleep(60);
		
	}
	
	private static Stream<String> getMovies(){
		System.out.println("Request streaming video...");
		return Stream.of("scene 1","scene 2","scene 3","scene 4","scene 5","scene 6");
	}

}

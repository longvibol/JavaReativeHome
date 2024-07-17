package java_reactive_demo.flux.combinepublisher;

import java_reactive_demo.flux.combinepublisher.util.AirAsia;
import java_reactive_demo.flux.combinepublisher.util.AngkorAirline;
import java_reactive_demo.flux.combinepublisher.util.BangkokAir;
import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class CP3Merge {

	public static void main(String[] args) {
		
	// we search flight from every company airline 
		
		Flux.merge(
				AirAsia.getFlight(),
				BangkokAir.getFlight(),
				AngkorAirline.getFlight()
				
				)
			.subscribe(Util.subcriber())
		;
		
		Util.sleep(10);

	}
}

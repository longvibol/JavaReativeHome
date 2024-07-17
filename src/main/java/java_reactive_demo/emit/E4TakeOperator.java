package java_reactive_demo.emit;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class E4TakeOperator {

	public static void main(String[] args) {

		/*
		 * Flux.range(1, 10) .log() .take(3) .log() .subscribe(Util.subcriber());
		 */

		Flux.create(fluxSink -> {
			String color;

			do {
				color = Util.faker().color().name();
				System.out.println("Emitting: " + color);

				fluxSink.next(color);

			} while (!color.equals("yellow") && !fluxSink.isCancelled());
			fluxSink.complete();

		})
			.take(3)
			.subscribe(Util.subcriber());

	}
	
	// we add: !fluxSink.isCancelled() in the case we want to use only take(3)- take 3 is only emit three time then it will cancel

}

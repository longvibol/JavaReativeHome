package java_reactive_demo.flux.combinepublisher.util;

import java.util.ArrayList;
import java.util.List;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class StringGenerator {

	List<String> list = new ArrayList<String>(List.of("Vicheka","Raksar"));

	public Flux<String> getName() {
		return Flux.generate(sink -> {

			String name = Util.faker().name().lastName();
			System.out.println("===> Fresh Generated name: " + name);
			list.add(name);
			//Util.sleep(1);
			sink.next(name);

		})
		.cast(String.class) // convert from Object to String 
		.startWith(getFromCache()); //it take the iteam from getfromCached first then it will create new:  startWith (is the publisher)
	}

	public Flux<String> getFromCache() {
		return Flux.fromIterable(list);
	}

}

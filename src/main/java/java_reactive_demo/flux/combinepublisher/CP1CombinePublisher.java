package java_reactive_demo.flux.combinepublisher;

import java_reactive_demo.flux.combinepublisher.util.StringGenerator;
import java_reactive_demo.util.Util;

public class CP1CombinePublisher {

	public static void main(String[] args) {

		StringGenerator generator = new StringGenerator();
		
		generator.getName()
			.take(2)
			.subscribe(Util.subcriber("Dara"));		
		generator.getName()
		.take(4)
		.subscribe(Util.subcriber("Thida"));		
		
		generator.getName()
		.filter(name -> name.startsWith("T"))
		.take(2)
		.subscribe(Util.subcriber("Veasna"));
		
	}
}

package java_reactive_demo.home.operator;

import java.util.function.Function;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class SwitchOnFirst {
	
	public static void main(String[] args) {
		
		getPerson()
			.subscribe(Util.subcriber());

	}

	public static Flux<Person> getPerson() {
		return Flux.range(1, 10).map(i -> new Person());
	}

	public static Function<Flux<Person>, Flux<Person>> applyFilterMap() {
		return flux -> flux.filter(p -> p.getAge() > 10).doOnNext(t -> t.setName(t.getName().toUpperCase()))
				.doOnDiscard(Person.class, p -> System.out.println(" Not allowing : " + p));

	}

}

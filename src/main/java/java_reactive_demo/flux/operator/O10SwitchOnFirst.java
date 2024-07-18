package java_reactive_demo.flux.operator;

import java.util.function.Function;

import java_reactive_demo.util.Student;
import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class O10SwitchOnFirst {	
	// SwitchOnfirst : we make decision by the first element 
	
	public static void main(String[] args) {	
		//getStudents is the publicer
		getStudents()
			.switchOnFirst((signal, flux)->{
				//if the first student > 15 then it will switch to publicer that have Big letter 
				// switch publicer
				if(signal.isOnNext() && signal.get().getAge() >15) {
					return myCustom().apply(flux);
				}				
				return flux;
			})
			.subscribe(Util.subcriber());		
	}	
	private static Flux<Student> getStudents(){
		return Flux.range(1, 10)
					.map(x -> new Student());
	}
	
	private static Function<Flux<Student>, Flux<Student>> myCustom(){
		return flux -> flux.filter(x -> x.getAge()>15)
				.doOnNext(x -> x.setName(x.getName().toUpperCase()))
				.doOnDiscard(Student.class, x -> System.out.println("Not allowed student: " +x));										
	}
	
	private static Function<Flux<Student>, Flux<Student>> myCustom3(){
		return flux -> flux.filter(x -> x.getAge()>15).doOnNext(x -> x.setName(x.getName().toUpperCase()));						
	}
	
	private static Function<Flux<Student>, Flux<Student>> myCustom2(){
		return flux -> flux.filter(x -> x.getAge()>15)
						.map(x ->{
							x.setName(x.getName().toUpperCase());							
							return x;
						});
	}
	
}

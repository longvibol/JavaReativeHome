package java_reactive_demo.home.assignment;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.function.LongConsumer;

import javax.management.RuntimeErrorException;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Mono;

public class Lec09FileReaderServiceAssignment {

	public static void main(String[] args) {
		
		FileReaderService readerService = new FileReaderService();
		
		Path path = Paths.get("src/main/resources/file04.txt");
		
		readerService.read(path)
			.map(s ->{
				Integer integer = Util.faker().random().nextInt(0, 10);
				if (integer > 8) {
					throw new RuntimeException("oops!!");
				}
				
				return s;
				
			})
			.take(20)
			.doFirst(() -> System.out.println("Do first"))
			.doOnSubscribe(t -> System.out.println("doOnSubscriber : " +t))
			.doOnRequest(l ->System.out.println("request : " +l))
			.doOnDiscard(Object.class, t -> System.out.println("request : " +t))
			.doFinally(t -> System.out.println("do oncancel : " +t))
			.limitRate(0)
			.delayElements(Duration.ofSeconds(3))
			.subscribe(Util.subcriber());
		
		

	}
	
	


}

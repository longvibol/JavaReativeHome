package java_reactive_demo.flux.operator;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class O2DoHook {	
	
	//DoHook is the live Cycle
	
	public static void main(String[] args) {

		Flux.range(1, 20)
			.doOnCancel(()->System.out.println("doOnCancel"))
			.doOnComplete(()->System.out.println("doOnComplete"))
			.doFirst(()->System.out.println("doFirst 1"))
			.doOnDiscard(Object.class, x -> System.out.println("doOnDiscard" + x))
			.doOnError(e ->System.out.println("doOnError:"+ e.getMessage()))
			.doOnNext(x -> System.out.println("doOnNext:" +x))
			.doOnSubscribe(s ->System.out.println("doOnSubscribe 1 "+s))
			.doFirst(()->System.out.println("doFirst 2"))
			.doFinally(signal ->System.out.println("doFinally" +signal))
			.doOnRequest(l -> System.out.println("doOnRequest"+l))
			.doOnSubscribe(s ->System.out.println("doOnSubscribe 2 "+s))
			.doFirst(()->System.out.println("doFirst 3"))
			.take(3)
			.doOnTerminate(()->System.out.println("doOnTerminate"))			
			.subscribe(Util.subcriber());
	}
}

















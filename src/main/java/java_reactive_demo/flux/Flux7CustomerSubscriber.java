package java_reactive_demo.flux;

import java.util.concurrent.atomic.AtomicReference;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class Flux7CustomerSubscriber {

	public static void main(String[] args) {
		
		Flux<Integer> flux = Flux.range(1, 30);	
		
		AtomicReference<Subscription> atomicReference = new AtomicReference<Subscription>();
		
		
		flux.subscribeWith(new Subscriber<Integer>() {

			@Override
			public void onSubscribe(Subscription s) {
				System.out.println("My Subscriptiion: ");
				atomicReference.set(s);
			}

			@Override
			public void onNext(Integer t) {
				System.out.println("My OnNext: " +t);				
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("My OnError: " +t.getMessage());
				
			}

			@Override
			public void onComplete() {
				System.out.println("my on Completed Done ");				
			}
		});
		
		atomicReference.get().request(8);
		Util.sleep(3);
		atomicReference.get().request(5);
		Util.sleep(2);
		atomicReference.get().request(20);
//		atomicReference.get().cancel();
//		Util.sleep(3);
//		atomicReference.get().request(5);
		
	}

}

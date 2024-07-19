package java_reactive_demo.home.demo;

import java.util.concurrent.atomic.AtomicReference;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class Lec06Subscription {

	public static void main(String[] args) {
		
		AtomicReference<Subscription> atomicReference = new AtomicReference<>();
		
		
		Flux.range(1, 20)
			.log()
			.subscribeWith(new Subscriber<Integer>() {

				@Override
				public void onSubscribe(Subscription s) {
					System.out.println("Received Sub :"+s);
					atomicReference.set(s);
				}

				@Override
				public void onNext(Integer t) {

					System.out.println("OnNext: " +t);
				}

				@Override
				public void onError(Throwable t) {
					
					System.out.println("OnError" + t.getMessage());
				}

				@Override
				public void onComplete() {

					System.out.println("onCompleted");
				}
			});
		
		Util.sleep(2);
		atomicReference.get().request(3);
		Util.sleep(3);
		atomicReference.get().request(4);
		atomicReference.get().cancel();
		Util.sleep(3);
		atomicReference.get().request(4);
	}
}

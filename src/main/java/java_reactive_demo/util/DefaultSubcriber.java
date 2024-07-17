package java_reactive_demo.util;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubcriber implements Subscriber<Object>{
	
	private String name="";

	public DefaultSubcriber(String name) {
		super();
		this.name = name + " - ";
	}
	
	public DefaultSubcriber() {
	}

	@Override
	public void onSubscribe(Subscription s) {

		s.request(Long.MAX_VALUE);
		
	}

	@Override
	public void onNext(Object t) {

		System.out.println(name + "Recieved: "+t);
	}

	@Override
	public void onError(Throwable t) {
		System.out.println("onError: "+t.getMessage());		
	}

	@Override
	public void onComplete() {
		System.out.println("Completed");		
	}

}

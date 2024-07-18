package java_reactive_demo.emit;

import java_reactive_demo.util.ColorProducer;
import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class E3SharingMultipleThread {

	public static void main(String[] args) {
		
		ColorProducer colorProducer = new ColorProducer();		
		
		Flux.create(colorProducer).subscribe(Util.subcriber("S1"));
		
		colorProducer.produce();
		
		Runnable runable = () -> colorProducer.produce();
		
		for(int i=0; i <=10; i++) {
			Thread thread = new Thread(runable);
			thread.start();
		}		

	}

}





















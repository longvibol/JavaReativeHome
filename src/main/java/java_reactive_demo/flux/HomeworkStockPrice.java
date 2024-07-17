package java_reactive_demo.flux;

import java.util.concurrent.CountDownLatch;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java_reactive_demo.util.StockPriceGenerator;
import java_reactive_demo.util.Util;

public class HomeworkStockPrice {

	public static void main(String[] args) throws InterruptedException {

		StockPriceGenerator priceGenerator = new StockPriceGenerator();
		
		CountDownLatch countDownLatch = new CountDownLatch(1);
		
		priceGenerator.getPrice()
			.subscribe(new Subscriber<Integer>() {
				
				private Subscription subscription;

				@Override
				public void onSubscribe(Subscription s) {
					this.subscription=s;
					s.request(Long.MAX_VALUE);
				}

				@Override
				public void onNext(Integer t) {
					System.out.println("Recieved: " +t);
					
					if(t > 105 || t < 95) {
						this.subscription.cancel();
					}
					
				}

				@Override
				public void onError(Throwable t) {
					System.out.println("Error: " + t.getMessage());
					countDownLatch.countDown();
				}

				@Override
				public void onComplete() {
					System.out.println("Complete.");
					countDownLatch.countDown();
				}
			});

		countDownLatch.await();
	}
}

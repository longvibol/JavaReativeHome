package java_reactive_demo.flux.batching;

import java.time.Duration;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class B3Assignment {

	private static double nextDouble;

	public static void main(String[] args) {
		
		/*
		for(int i =0 ;i<50;i++) {
			String category = Util.faker().book().genre();
			System.out.println(category);
		}
		*/
		Set<String> categories = Set.of("Fantasy","Essay","Textbook");
		
		flux()
			.filter(book -> categories.contains(book.getCategory()))// filter to our search 
			.buffer(2) // every 2 second we do the report upate 
			.map(books -> calculateRevenue(books)) // convert from list to report revenuse 			
			.subscribe(Util.subcriber());
		
		Util.sleep(10);
	}
	
	private static RevenueReport calculateRevenue(List<BookOrder> books) {
		
		Map<String, Double> map = books.stream()
			.collect(Collectors.groupingBy(
				BookOrder::getCategory,
				Collectors.summingDouble(BookOrder::getPrice)
				));
		
		return new RevenueReport(map);		
	}	
	
	//function generate bookOrder 
	private static Flux<BookOrder> flux(){
		return Flux.interval(Duration.ofMillis(10))				
				.map(x -> new BookOrder());
	}
	
}

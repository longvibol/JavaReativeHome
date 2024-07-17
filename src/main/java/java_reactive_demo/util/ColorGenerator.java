package java_reactive_demo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import reactor.core.publisher.Flux;

public class ColorGenerator {
	
	public List<String> getColor(int number){
		List<String> colors = new ArrayList<String>();
		
		for(int i =0;i<=number;i++) {
			colors.add(getColor());
		}
		
		// when finishes then return
		return colors;
	}
	
	
	public Flux<String> getColorV2(int number){
		return Flux.range(1, number)
			.map(x -> getColor());
		//return one by one 
	}
	
	
	private String getColor() {
		Util.sleep(1);
		return Util.faker().color().name();
	}

}

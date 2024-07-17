package java_reactive_demo.flux.batching;

import java.time.LocalDate;
import java.util.Map;

import lombok.Data;

@Data
public class RevenueReport {
	
	private LocalDate dateTime;
	private Map<String, Double> map;
	
	public RevenueReport(Map<String, Double> map) {
		this.map = map;
		this.dateTime = LocalDate.now();
	}

}

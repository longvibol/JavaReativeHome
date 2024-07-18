package java_reactive_demo.emit;

import java.nio.file.Path;
import java.nio.file.Paths;

import java_reactive_demo.exercise.FileService;
import java_reactive_demo.util.FileReaderService;
import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class E6Exercise {

	public static void main(String[] args) {
		
		Path path = Paths.get("src/main/resources/fileFlux.txt");
		FileReaderService fileReaderService = new FileReaderService();
		
		fileReaderService.readFile(path)
			//.take(2)
			.map(x ->{
				Integer number = Util.faker().random().nextInt(0, 10);
				
				if(number > 7) {
					throw new RuntimeException("Somthing error !!!");
				}
				
				return number;
			})
			.subscribe(Util.subcriber());

	}
}

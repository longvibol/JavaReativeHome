package java_reactive_demo.home;

import java_reactive_demo.util.Util;

public class Lec09AssignmentDemoFileService {

	public static void main(String[] args) {
		
		
		
		FileServiceHome.read("file02.txt")
			.subscribe(Util.onNext(),Util.onError(),Util.onComplete());
		
		
		FileServiceHome.write("file03.txt", "This is the file 02 :hello")
			.subscribe(t -> System.out.println("File was created: " + t));
		
		
		
		
		FileServiceHome.delete("file02.txt")
			.subscribe(t -> System.out.println("Complete delete : " +t));	
	
		


	}

}

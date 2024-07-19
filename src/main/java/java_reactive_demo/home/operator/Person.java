package java_reactive_demo.home.operator;

import java_reactive_demo.util.Util;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Person {
	
	private String name;
	private int age;
	
	public Person() {
		this.name = Util.faker().name().firstName();
		this.age = Util.faker().random().nextInt(1,20);
	}
	

}

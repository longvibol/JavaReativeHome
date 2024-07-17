package java_reactive_demo.flux.operator;

import java_reactive_demo.util.OrderService;
import java_reactive_demo.util.UserService;
import java_reactive_demo.util.Util;

public class O11FlatMap {

	public static void main(String[] args) {
		
		// Flux<interge> have 10 item
		// each iteam have Flux of 5 Object 
		//Flux<Flux<object>> it mean Flux inside the flux
		
		// We want : flux<Object> have 50 iteam 
		
		
		// user(id, name) -> order(userId, productName,price) 
		// we want to know this user : how many order he has order 
		
		OrderService orderService = new OrderService();
		UserService userService = new UserService();
		
		
		userService.getUser()
//			.map(user -> orderService.getOrder(user.getId())) : it return Flux back and we don't want it we want Flux<order>
			.flatMap(user -> orderService.getOrder(user.getId()))
			.subscribe(Util.subcriber());
		
		Util.sleep(60);
	}

}

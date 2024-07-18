package java_reactive_demo.flux.hotcold;

import java_reactive_demo.flux.hotcold.excercise.InventoryService;
import java_reactive_demo.flux.hotcold.excercise.OrderService;
import java_reactive_demo.flux.hotcold.excercise.RevenueService;
import java_reactive_demo.util.Util;

public class HC8Excercise {

	public static void main(String[] args) {
		OrderService orderService = new OrderService();
		
		RevenueService revenueService = new RevenueService();
		InventoryService inventoryService = new InventoryService();
		
		orderService.getSteamingOrder()
			.subscribe(revenueService.consumeOrderStreaming());
		
		orderService.getSteamingOrder()
		.subscribe(inventoryService.consumeOrderStreaming());
		
		
		revenueService.getRevenueDb()
			.subscribe(Util.subcriber("Revenue"));
		
		inventoryService.getInventoryDb()
			.subscribe(Util.subcriber("Inventory"));
		
		Util.sleep(60);
	}
}

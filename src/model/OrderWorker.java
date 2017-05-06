package model;

import java.util.ArrayList;
import java.util.List;

public class OrderWorker implements IWork {

	private int id;
	private List<Order> orders = new ArrayList<Order>();
	private List<Order> finishedOrders = new ArrayList<Order>();
	private List<MenuItem> availableMenuItems = new ArrayList<MenuItem>();
	
	@Override
	public void work(MenuItem item) {
		if(orders.size()==0)return;
		for(Order order : orders)
		if(order.needMenuItem(item)>0){
			tryFinish(order);
		}
		
	}

	private void tryFinish(Order order) {
		List<MenuItem> itemsNeeded = new ArrayList<MenuItem>();
		for(MenuItem item: order.getItems()){
			if(availableMenuItemsHas(item))
				{
					itemsNeeded.add(item);
					availableMenuItems.remove(item);
				}
			else {
				availableMenuItems.addAll(itemsNeeded);
				return;
			
			}
		}
		
		if(itemsNeeded.size()==order.getItems().size()){
			orders.remove(order);
			finishedOrders.add(order);
		}
	}

	private boolean availableMenuItemsHas(MenuItem item) {
		for(MenuItem menuItem : availableMenuItems){
			if(menuItem.getName().equalsIgnoreCase(item.getName()))
				return true;
		}
		return false;
	}

	@Override
	public void check(Order order) {
		this.orders.add(order);
	}

}

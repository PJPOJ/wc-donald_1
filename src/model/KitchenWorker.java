package model;

import java.util.ArrayList;
import java.util.List;

public class KitchenWorker implements IWork{

	public static final String chips = "frytki";
	public static final String beverage = "napoj";
	public static final String hamburger = "hamburger";
	
	private int id;
	
	private String menuItemType;
	private List<MenuItem> items = new ArrayList<MenuItem>();
	//MenuItemsQueue
	
	@Override
	public void work(MenuItem item) {
		
		if(!item.getName().equalsIgnoreCase(this.menuItemType))
			return;
		doWork();
		
	}

	private void doWork() {
		System.out.println("robię " + this.menuItemType);
		putOnQueue(new MenuItem(this.menuItemType));
	}

	private void putOnQueue(MenuItem menuItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void check(Order order) {
		int itemsNeeded = order.needMenuItem(new MenuItem(this.menuItemType));
		if(itemsNeeded==0)
			return;
		for(int i = 0; i<itemsNeeded;i++){
			items.add(new MenuItem(this.menuItemType));
		}
		
	}

}

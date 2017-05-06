package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private int id;
	
	private List<MenuItem> items = new ArrayList<MenuItem>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<MenuItem> getItems() {
		return items;
	}

	public void setItems(List<MenuItem> items) {
		this.items = items;
	}

	public int needMenuItem(MenuItem item) {
		int count = 0;
		for(MenuItem menuItem: this.items)
		{
			if(menuItem.getName().equalsIgnoreCase(item.getName()))
				count++;
		}
		return count;
	}
	
	
}

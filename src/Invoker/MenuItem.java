package Invoker;

public class MenuItem {
	private int itemNum;
	private String itemDesc;
	private double price;
	private MenuItemType type;
	private String servedAt;

	public MenuItem(int itemNum, String itemDesc, double price, MenuItemType type, String servedAt) {
		this.itemNum = itemNum;
		this.itemDesc = itemDesc;
		this.price = price;
		this.type = type;
		this.servedAt = servedAt;
	}

	public int getItemNum() {
		return itemNum;
	}

	public double getPrice() {
		return price;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public MenuItemType getType() {
		return type;
	}

	public String getServedAt() {
		return servedAt;
	}

	public String toString() {
		return "#" + itemNum + " - " + "Item: " + itemDesc + " ---------- " + "$" + price + "\n";
	}
}
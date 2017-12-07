package Aggregations;

public class MenuItem {
	private  int id;
	private  String description;
	private double price;
	private MenuItemType type;
	private  String servedAt;

	public MenuItem(int id, String description, double price, MenuItemType type, String servedAt) {
		this.id = id;
		this.description = description;
		this.price = price;
		this.type = type;
		this.servedAt = servedAt;
	}

	public MenuItem() {

	}

	public int getItemId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	public MenuItemType getType() {
		return type;
	}

	public String getServedAt() {
		return servedAt;
	}

	public String toString() {
		return "#" + id + " - " + description + "  [" + type + "]" + " ---------- " + "$" + price + "\n";
	}
}
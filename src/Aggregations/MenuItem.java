package Aggregations;

public class MenuItem {
	private final int id;
	private final String description;
	private final double price;
	private final MenuItemType type;
	private final String servedAt;

	public MenuItem(int id, String description, double price, MenuItemType type, String servedAt) {
		this.id = id;
		this.description = description;
		this.price = price;
		this.type = type;
		this.servedAt = servedAt;
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
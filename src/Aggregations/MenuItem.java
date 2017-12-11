package Aggregations;

public class MenuItem {
	private  int id;
	private  String description;
	private double price;
	private  String servedAt;

	public MenuItem(int id, String description, double price, String servedAt) {
		this.id = id;
		this.description = description;
		this.price = price;
		this.servedAt = servedAt;
	}

	public int getItemId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	public String getServedAt() {
		return servedAt;
	}

	public String toString() {
		return "#" + id + " - " + description + " ---------- " + "$" + price + "\n";
	}
}
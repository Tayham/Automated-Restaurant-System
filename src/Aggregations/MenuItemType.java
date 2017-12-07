package Aggregations;

public enum MenuItemType {
	ENTREE("Entree"), SIDE("Side"), DRINK("Drink");

	private final String type;

	MenuItemType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.type;
	}
}
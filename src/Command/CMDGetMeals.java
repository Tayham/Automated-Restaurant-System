package Command;

import Aggregations.Aggregator;
import Builder.Meals;

public class CMDGetMeals implements Command {

	private final Aggregator aggregator;

	public CMDGetMeals(Aggregator aggregator) {
		this.aggregator = aggregator;
	}

	public Meals execute() {
		return aggregator.getMeals();
	}
}

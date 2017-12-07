package Command;

import Builder.Meals;

public class CMDGetMeals implements Command {

	private Aggregator agg;

	public CMDGetMeals(Aggregator agg) {
		this.agg = agg;
	}

	public Meals execute() {
		return agg.getMeals();
	}
}

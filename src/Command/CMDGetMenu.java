package Command;

import Invoker.Menu;

public class CMDGetMenu implements Command {

	private Aggregator agg;

	public CMDGetMenu(Aggregator agg) {
		this.agg = agg;
	}

	public Menu execute() {
		return agg.getMenu();
	}
}

package State;

public class StateContext{
		private State state;
		public StateContext(State state) {
			this.state = state;
		}

	public State getState() {
			return state;
		}
		public void setState(State state) {
			this.state = state;
		}
}


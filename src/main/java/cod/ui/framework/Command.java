package cod.ui.framework;

import java.util.List;

public abstract class Command<T> {

	abstract public String identifier();
	abstract public void execute();
	abstract public String describe();

	public boolean shouldContinue() { return true; }  // default implementation
	public void loadArgs() {  }  // default implementation


	protected T system;
	protected List<String> args;

	public void withSystem(T system)                    { this.system = system;   }
	public void withParameters(List<String> parameters) { this.args = parameters; }

	public boolean process() {
		try { loadArgs(); }
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
		execute();
		return shouldContinue();
	}

	@Override
	public String toString() {
		return identifier() + "(" + args.toString().replace("[","").replace("]","") + ")";
	}
}

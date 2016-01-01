package cod.ui.framework;

public abstract class Command<T> {

	abstract public String identifier();
	abstract public void execute();
	abstract public String describe();

	public boolean shouldContinue() { return true; }  // default implementation

	protected T system;
	protected String[] args;

	public void withSystem(T system)                { this.system = system;   }
	public void withParameters(String[] parameters) { this.args = parameters; }

	public boolean process() {
		execute();
		return shouldContinue();
	}

}

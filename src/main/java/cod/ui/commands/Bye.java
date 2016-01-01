package cod.ui.commands;

import cod.CookieOnDemand;
import cod.ui.framework.Command;

public class Bye extends Command<CookieOnDemand> {

	@Override
	public String identifier() { return "bye"; }

	@Override
	public void execute() { }

	@Override
	public String describe() {
		return "Exit Cookie on Demand";
	}

	@Override
	public boolean shouldContinue() { return false; }

}

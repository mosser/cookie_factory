package cod.ui.commands;

import cod.CookieOnDemand;
import cod.tcf.*;
import cod.ProductCatalogue;
import cod.ui.framework.Command;

public class ListPreMadeCookies extends Command<CookieOnDemand> {

	@Override
	public String identifier() { return  "recipes"; }

	@Override
	public void execute() {
		ProductCatalogue catalogue = system.getCatalogue();
		for(Cookie c: catalogue.getPreMade()) {
			System.out.println("  - " + c.toString());
		}

	}

	@Override
	public String describe() {
		return "List the contents of the pre-made cookie catalogue";
	}

}

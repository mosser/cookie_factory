package cod.ui;

import cod.CookieOnDemand;
import cod.ui.commands.*;
import cod.ui.framework.Shell;

/**
 * An Interactive shell that interacts with a Cookie on Demand instance
 */
public class InteractiveCoD extends Shell<CookieOnDemand> {

	public InteractiveCoD() {

		this.system  = CookieOnDemand.build();
		this.invite  = "CoD";

		// Registering the command available for the user
		register(
				Bye.class,
				ListPreMadeCookies.class,
				CreateCustomer.class,
				OrderCookie.class,
				ShowCart.class,
				RemoveCookie.class,
				ProcessCart.class
		);

	}

}

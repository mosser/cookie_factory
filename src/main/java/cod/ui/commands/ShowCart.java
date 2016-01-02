package cod.ui.commands;

import cod.CookieOnDemand;
import cod.ShoppingCart;
import cod.tcf.Customer;
import cod.ui.framework.Command;

import java.util.List;

public class ShowCart extends Command<CookieOnDemand> {

	private Customer customer;

	@Override
	public String identifier() { return "cart"; }

	@Override
	public void execute() {
		ShoppingCart cart = system.getShoppingCart(customer);
		if (cart.contents().isEmpty()){
			System.out.println("  Empty cart");
		} else {
			System.out.println("  " + cart.contents());
		}
	}

	@Override
	public void load(List<String> args) {
		customer = system.getCustomers().findByFirstName(args.get(0)).get();
	}

	@Override
	public String describe() {
		return "show the cart contents for a given customer (cart CUSTOMER)";
	}
}

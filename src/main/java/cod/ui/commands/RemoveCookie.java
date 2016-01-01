package cod.ui.commands;

import cod.ShoppingCart;
import cod.tcf.Item;

public class RemoveCookie extends OrderCookie {

	@Override
	public String identifier() { return "remove"; }

	@Override
	public void execute() {
		ShoppingCart cart = system.getShoppingCart(customer);
		cart.remove(new Item(cookie,quantity));
	}

	@Override
	public String describe() {
		return "Remove some cookies for a given customer (remove CUSTOMER QUANTITY RECIPE)";
	}
}

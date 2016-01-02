package cod.ui.commands;

import cod.CookieOnDemand;
import cod.ShoppingCart;
import cod.tcf.Cookie;
import cod.tcf.Customer;
import cod.tcf.Item;
import cod.tcf.Recipes;
import cod.ui.framework.Command;

import java.util.List;

public class OrderCookie extends Command<CookieOnDemand> {

	protected Customer customer;
	protected int quantity;
	protected Cookie cookie;

	@Override
	public String identifier() { return "order"; }

	@Override
	public void load(List<String> args) {
		customer = system.getCustomers().findByFirstName(args.get(0)).get();
		quantity = Integer.parseInt(args.get(1));
		cookie   = Recipes.valueOf(args.get(2));
	}

	@Override
	public void execute() {
		ShoppingCart cart = system.getShoppingCart(customer);
		cart.add(new Item(cookie,quantity));
	}

	@Override
	public String describe() {
		return "Order some cookies for a given customer (order CUSTOMER QUANTITY RECIPE)";
	}
}

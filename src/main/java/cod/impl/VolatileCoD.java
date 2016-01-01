package cod.impl;

import cod.*;
import cod.tcf.Customer;
import cod.tcf.Item;
import cod.tcf.Voucher;

import java.util.HashMap;
import java.util.Optional;

public class VolatileCoD implements CookieOnDemand {

	CustomerDatabase customers;
	ProductCatalogue products;
	HashMap<Customer, ShoppingCart> carts;


	public VolatileCoD() {
		customers = new VolatileCustomerDatabase();
		products  = new VolatileProductCatalogue();
		carts = new HashMap<>();
	}

	@Override
	public CustomerDatabase getCustomers() {
		return customers;
	}

	@Override
	public ProductCatalogue getCatalogue() { return products; }

	@Override
	public ShoppingCart getShoppingCart(Customer customer) {
		if(carts.containsKey(customer))
			return carts.get(customer);
		ShoppingCart cart = new VolatileShoppingCart();
		carts.put(customer, cart);
		return cart;
	}

	@Override
	public void process(Customer c) {
		ShoppingCart cart = getShoppingCart(c);
		Voucher v = new Voucher();
		for(Item i: cart.contents()) {
			v.getContents().add(i);
			cart.remove(i);
		}
		c.setVoucher(Optional.of(v));
	}

}

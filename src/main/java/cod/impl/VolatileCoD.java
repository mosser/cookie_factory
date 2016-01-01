package cod.impl;

import cod.*;
import cod.business.Customer;
import cod.business.Item;
import cod.business.Voucher;

import java.util.HashMap;
import java.util.Optional;

public class VolatileCoD implements CookieOnDemand {

	CustomerDatabase customers;
	ProductCatalogue products;
	HashMap<Customer,OrderShoppingCart> carts;


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
	public OrderShoppingCart getShoppingCart(Customer customer) {
		if(carts.containsKey(customer))
			return carts.get(customer);
		OrderShoppingCart cart = new VolatileOrderShoppingCart();
		carts.put(customer, cart);
		return cart;
	}

	@Override
	public void process(Customer c) {
		OrderShoppingCart cart = getShoppingCart(c);
		Voucher v = new Voucher();
		for(Item i: cart.contents()) {
			v.getContents().add(i);
			cart.remove(i);
		}
		c.setVoucher(Optional.of(v));
	}

}

package cod;

import cod.tcf.Customer;
import cod.impl.VolatileCoD;

/**
 * Interface of the Cookie on Demand (CoD) system
 */
public interface CookieOnDemand {

	/**
	 * This method provide an indirection to the concrete implementation of the system
	 * @return the concrete CoD System to be used
	 */
	static CookieOnDemand build () { return new VolatileCoD(); }

	/**
	 * Provides an access to the database that contains our customers
	 * @return a concrete CustomerDatabase
	 */
	CustomerDatabase getCustomers();

	/**
	 * Provides an access to the product catalogue availabe in CoD
	 * @return a concrete ProductCatalogue
	 */
	ProductCatalogue getCatalogue();

	/**
	 * Retrieve the shopping cart associated to a given custoemr
	 * @param customer the customer associated to the expected cart
	 * @return a concrete ShoppingCart
	 */
	ShoppingCart getShoppingCart(Customer customer);

	/**
	 * For a given customer, send the contents of the associated cart to the bakery and create a voucher as a
	 * side effect, linked to the customer.
	 * @param c the customer to handle
	 */
	void process(Customer c);

}

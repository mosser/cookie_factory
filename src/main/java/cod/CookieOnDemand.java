package cod;

import cod.tcf.Customer;
import cod.impl.VolatileCoD;

public interface CookieOnDemand {

	static CookieOnDemand build () { return new VolatileCoD(); }

	CustomerDatabase getCustomers();

	ProductCatalogue getCatalogue();

	ShoppingCart getShoppingCart(Customer customer);

	void process(Customer c);

}

package cod;

import cod.business.Customer;
import cod.impl.VolatileCoD;

public interface CookieOnDemand {

	static CookieOnDemand build () { return new VolatileCoD(); }

	CustomerDatabase getCustomers();

	ProductCatalogue getCatalogue();

	OrderShoppingCart getShoppingCart(Customer customer);

	void process(Customer c);

}

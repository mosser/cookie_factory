package cod;

import cod.business.Customer;
import java.util.Optional;

public interface CustomerDatabase {

	// structural operations
	void add(Customer c);

	// search operations
	Optional<Customer> findByFirstName(String firstName);

}

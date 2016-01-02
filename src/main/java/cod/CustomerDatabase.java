package cod;

import cod.tcf.Customer;
import java.util.Optional;

/**
 * The Customer database allows one to access to TCF's customers.
 */
public interface CustomerDatabase {

	/**
	 * Add a given customer in the database
	 * @param c the customer to be added
	 */
	void add(Customer c);

	/**
	 * Looks for a Customer based on a given first name
	 * @param firstName the key used for user retrieval search in the database
	 * @return An optional that contains the customer if found, Empty is no one was found.
	 */
	Optional<Customer> findByFirstName(String firstName);

}

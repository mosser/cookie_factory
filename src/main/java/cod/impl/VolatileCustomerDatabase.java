package cod.impl;

import cod.CustomerDatabase;
import cod.tcf.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class VolatileCustomerDatabase implements CustomerDatabase {

	private Set<Customer> customers = new HashSet<>();

	@Override
	public void add(Customer c) { customers.add(c); }

	@Override
	public Optional<Customer> findByFirstName(String firstName) {
		return customers
				.stream()
				.filter(c -> c.getFirstName().equals(firstName))
				.findFirst();
	}

}

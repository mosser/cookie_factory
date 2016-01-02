package cod.tcf;

import java.util.Optional;

/**
 * A customer is modeled like in our bakery, using a first name as identifier (it might not scale...)
 */
public class Customer {

	// Customer's first name
	private String firstName;

	// The voucher associated to the latest order, if any,
	private Optional<Voucher> voucher;

	public Customer(String firstName) {
		this.firstName = firstName;
		this.voucher = Optional.empty();
	}

	public String getFirstName() { return firstName; }

	public Optional<Voucher> getVoucher() { return voucher; }
	public void setVoucher(Optional<Voucher> voucher) { this.voucher = voucher; }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Customer)) return false;
		Customer customer = (Customer) o;
		return getFirstName().equals(customer.getFirstName());
	}

	@Override
	public int hashCode() {
		return getFirstName().hashCode();
	}

	@Override
	public String toString() {
		return "Customer { " +
				"firstName: '" + firstName + '\'' +
				" }";
	}
}


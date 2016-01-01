package cod.tcf;

import java.util.Optional;

public class Customer {

	private String firstName;
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


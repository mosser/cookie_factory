package cod.ui.commands;

import cod.CookieOnDemand;
import cod.CustomerDatabase;
import cod.tcf.Customer;
import cod.ui.framework.Command;

import java.util.List;


public class CreateCustomer extends Command<CookieOnDemand> {

	private String customerName;

	@Override
	public String identifier() { return "create"; }

	@Override
	public String describe() { return "create a new customer in the system (create CUSTOMER)"; }

	@Override
	public void load(List<String> args) { customerName = args.get(0); }

	@Override
	public void execute() {
		CustomerDatabase db = system.getCustomers();
		Customer c = new Customer(customerName);
		db.add(c);
	}

}
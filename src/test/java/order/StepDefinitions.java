package order;

import cod.*;
import cod.tcf.*;

import cucumber.api.java.en.*;
import java.util.Optional;
import static org.junit.Assert.*;

/**
 * These step definitions set refers to the "Order" feature (under test/resources/order.feature)
 *
 * Regular expressions used in this step definition class:
 *   - (.*)  => any string
 *   - (\d+) => integer value
 */
public class StepDefinitions {

	CookieOnDemand cod = CookieOnDemand.build();

	/**
	 * Contexts
	 */

	@Given("^a customer named (.*) who want to buy a cookie$")
	public void initializeCustomer(String customerName) {
		Customer aCustomer = new Customer(customerName);
		CustomerDatabase db = cod.getCustomers();
		db.add(aCustomer);
	}

	/**
	 * Helpers
	 */
	private Customer getCustomer(String customerName) {
		Optional<Customer> customer = cod.getCustomers().findByFirstName(customerName);
		assertTrue(customer.isPresent());
		return customer.get();
	}

	private ShoppingCart getOrderShoppingCart(String customerName) {
		return cod.getShoppingCart(getCustomer(customerName));
	}

	private Voucher getVoucherForCustomer(String customerName) {
		Optional<Voucher> res = getCustomer(customerName).getVoucher();
		assertTrue(res.isPresent());
		return res.get();
	}


	/**
	 * Actions
	 */

	@When("^(.*) selects to buy (\\d+) pieces? of (.*)")
	public void selectItem(String customerName, int quantity, String productName) {
		ShoppingCart cart = getOrderShoppingCart(customerName);
		Item it = new Item(Recipes.valueOf(productName), quantity);
		cart.add(it);
	}

	@When("^(.*) selects to remove (\\d+) pieces? of (.*)$")
	public void removeItem(String customerName, int quantity, String productName) {
		ShoppingCart cart = getOrderShoppingCart(customerName);
		Item it = new Item(Recipes.valueOf(productName), quantity);
		cart.remove(it);
	}

	@When("^(.*) sends his order to CoD$")
	public void processOrder(String customerName) {
		cod.process(getCustomer(customerName));
	}

	/**
	 * Expectations
	 */

	@Then("^(.*) is considered as a regular customer in CoD$")
	public void existingCustomer(String customerName) {
		CustomerDatabase db = cod.getCustomers();
		Optional<Customer> customer = db.findByFirstName(customerName);
		assertTrue(customer.isPresent());
	}

	@Then("^the list of the (\\d+) pre-made recipes is available$")
	public void getPreMadeRecipes(int numberOfRecipes) {
		ProductCatalogue catalogue = cod.getCatalogue();
		assertEquals(numberOfRecipes, catalogue.getPreMade().size());
	}


	@Then("^(.*)'s order contains this very item: (\\d+)x(.*)")
	public void orderContainsItem(String customerName, int quantity, String productName) {
		ShoppingCart cart = getOrderShoppingCart(customerName);
		assertTrue(cart.contains(new Item(Recipes.valueOf(productName),quantity)));
	}

	@Then("^(.*)'s order contains (\\d+) items?$")
	public void orderSize(String customerName, int n) {
		ShoppingCart cart = getOrderShoppingCart(customerName);
		assertEquals(n, cart.size());
	}

	@Then("^(.*) has a voucher stored in his account$")
	public void existsVoucherForCustomer(String customerName) {
		getVoucherForCustomer(customerName);
	}

	@Then("^(.*)'s voucher contains an identifier$")
	public void voucherWithIdentifier(String customerName) {
		Voucher v = getVoucherForCustomer(customerName);
		assertNotNull(v.getUuid());
	}

	@Then("^(.*)'s voucher contains (\\d+) cookies$")
	public void voucherContainsNumberOfCookies(String customerName, int quantity) {
		Voucher v = getVoucherForCustomer(customerName);
		assertEquals(quantity, v.numberOfCookies());
	}

}

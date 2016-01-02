package cod.tcf;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * A voucher should be presented at the bakery to pick up the order.
 */
public class Voucher {

	// An unique identifier for this voucher
	private String uuid;
	// The ordered cookies.
	private List<Item> contents;

	public Voucher() {
		uuid = UUID.randomUUID().toString();
		contents = new LinkedList<>();
	}

	public String getUuid() {
		return uuid;
	}
	public List<Item> getContents() {
		return contents;
	}

	public int numberOfCookies() {
		return contents.stream().map(it -> it.getQuantity()).reduce(0,(acc,n) -> acc + n);
	}

	@Override
	public String toString() {
		return "Voucher for "+ numberOfCookies()+" cookies { " +
				"ref: '" + uuid + '\'' +
				" -> " + contents +
				" }";
	}
}

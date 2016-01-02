package cod.tcf;

/**
 * An item is a pair that binds a given cookie to a quantity, e.g., (2, DARK_TEMPTATION) is an item.
 */
public class Item {

	// The cookie involved in this pair
	private Cookie cookie;
	// The number of cookies in the item
	private int quantity;

	public Item(Cookie cookie, int quantity) {
		this.cookie = cookie;
		this.quantity = quantity;
	}

	public Cookie getCookie() { return cookie; }
	public int getQuantity() { return quantity; }

	@Override
	public String toString() { return quantity + "x" + cookie.describe(); }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Item)) return false;
		Item item = (Item) o;
		if (getQuantity() != item.getQuantity()) return false;
		return getCookie() == item.getCookie();
	}

	@Override
	public int hashCode() {
		int result = getCookie().hashCode();
		result = 31 * result + getQuantity();
		return result;
	}
}



package cod;

import cod.tcf.Item;
import java.util.List;

/**
 * An anonymous shopping cart
 */
public interface ShoppingCart {

	/**
	 * Add an item inside the cart. If an existing cookie is already present in the cart, the two items are merged.
	 * @param i the item to add
	 */
	void add(Item i);

	/**
	 * Remove an item from the cart. If the cart contains (3xCookie), removing (1xCookie) yields ((2xCookie)
	 * @param i the item to remove
	 */
	void remove(Item i);

	/**
	 * Check if the cart contains a given item  exactly
	 * @param i the item to look for
	 * @return tru if found, false elsewhere
	 */
	boolean contains(Item i);

	/**
	 * Compute the size of the shopping cart, i.e., the number of items stored in it
	 * @return the size, as an integer
	 */
	int size();

	/**
	 * Provide an access to the contents of this very cart
	 * @return a list of Items stored in the cart
	 */
	List<Item> contents();

}

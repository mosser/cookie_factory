package cod.impl;

import cod.OrderShoppingCart;
import cod.business.Item;

import java.util.*;

public class VolatileOrderShoppingCart implements OrderShoppingCart {

	private Set<Item> items = new HashSet<>();

	@Override
	public void add(Item i) {
		// handling the case where the same cookie is already on the shopping cart
		Optional<Item> existing = items.stream().filter(e -> e.getCookie().equals(i.getCookie())).findFirst();
		if(existing.isPresent()) {
			items.remove(existing.get());
			Item toAdd = new Item(i.getCookie(), i.getQuantity() + existing.get().getQuantity());
			if(toAdd.getQuantity() > 0) { items.add(toAdd); }
		} else {
			items.add(i);
		}
	}

	@Override
	public void remove(Item i) { add(new Item(i.getCookie(), -i.getQuantity())); }

	@Override
	public boolean contains(Item i) { return items.contains(i); }

	@Override
	public int size() { return items.size(); }

	@Override
	public List<Item> contents() {
		List<Item> result = new LinkedList<>();
		result.addAll(items);
		return result;
	}

}

package cod;


import cod.business.*;

import java.util.List;

public interface OrderShoppingCart {

	void add(Item i);
	void remove(Item i);

	boolean contains(Item i);
	int size();

	List<Item> contents();

}

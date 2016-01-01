package cod;


import cod.tcf.*;

import java.util.List;

public interface ShoppingCart {

	void add(Item i);
	void remove(Item i);

	boolean contains(Item i);
	int size();

	List<Item> contents();

}

package cod.impl;

import cod.ProductCatalogue;
import cod.tcf.Cookie;
import cod.tcf.Recipes;

import java.util.Arrays;
import java.util.List;

public class VolatileProductCatalogue implements ProductCatalogue {

	@Override
	public List<Cookie> getPreMade() { return Arrays.asList(Recipes.values()); }
}

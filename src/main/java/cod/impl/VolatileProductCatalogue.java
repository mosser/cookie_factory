package cod.impl;

import cod.ProductCatalogue;
import cod.business.Cookie;

import java.util.Arrays;
import java.util.List;

public class VolatileProductCatalogue implements ProductCatalogue {


	@Override
	public List<Cookie> getPreMade() { return Arrays.asList(Cookie.values()); }
}

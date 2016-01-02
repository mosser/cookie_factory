package cod;

import cod.tcf.Cookie;
import java.util.List;

/**
 * The product catalogue available in CoD, including PRe-made cookies and customization capabilities
 */
public interface ProductCatalogue {

	/**
	 * Access tot he list of pre-made recipes available in TCF shops
	 * @return a list of cookies.
	 */
	List<Cookie> getPreMade();

}

package cod.business;


import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Voucher {

	private String uuid;
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

}

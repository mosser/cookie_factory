package cod.business;

public enum Cookie {

	CHOCOLALALA("Chocolalala"),
	DARK_TEMPTATION("Dark Temptation"),
	SOO_CHOCOLATE("Soo Chocolate");

	private String name;

	private Cookie(String value) { this.name = value; }

	public String getName() {
		return name;
	}

}

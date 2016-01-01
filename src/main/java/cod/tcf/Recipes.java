package cod.tcf;

public enum Recipes implements Cookie {

	CHOCOLALALA("Chocolalala"),
	DARK_TEMPTATION("Dark Temptation"),
	SOO_CHOCOLATE("Soo Chocolate");

	private String name;

	Recipes(String value) { this.name = value; }

	@Override
	public String describe() {
		return name;
	}

}

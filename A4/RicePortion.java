package a4;

public class RicePortion extends IngredientPortionImpl {
	
	static Ingredient rice = new Rice();
	
	public RicePortion(double amount) {
		super(rice, amount);
		
		if (amount < 0) {
			throw new RuntimeException("amount cannot be less than 0");
		}
	}
}


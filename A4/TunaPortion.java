package a4;

public class TunaPortion extends IngredientPortionImpl {
	
	static Ingredient tuna = new Tuna();
	
	public TunaPortion(double amount) {
		super(tuna, amount);
		
		if (amount < 0) {
			throw new RuntimeException("amount cannot be less than 0");
		}
	}
}
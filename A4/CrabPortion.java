package a4;

public class CrabPortion extends IngredientPortionImpl {
	
	static Ingredient crab = new Crab();
	
	public CrabPortion(double amount) {
		super(crab, amount);
		
		if (amount < 0) {
			throw new RuntimeException("amount cannot be less than 0");
		}
	}
}

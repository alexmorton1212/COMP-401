package a4;

public class EelPortion extends IngredientPortionImpl {
	
	static Ingredient eel = new Eel();
	
	public EelPortion(double amount) {
		super(eel, amount);
		
		if (amount < 0) {
			throw new RuntimeException("amount cannot be less than 0");
		}
	}
}
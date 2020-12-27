package a4;

public class YellowtailPortion extends IngredientPortionImpl {
	
	static Ingredient yellowtail = new Yellowtail();
	
	public YellowtailPortion(double amount) {
		super(yellowtail, amount);
		
		if (amount < 0) {
			throw new RuntimeException("amount cannot be less than 0");
		}
	}
}
package a4;

public class ShrimpPortion extends IngredientPortionImpl {

	private static Ingredient shrimp = new Shrimp();

	public ShrimpPortion(double amount) {
		super(shrimp, amount);

	}
}

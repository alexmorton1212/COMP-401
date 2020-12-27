package a4;

public class SeaweedPortion extends IngredientPortionImpl {

	static Ingredient seaweed = new Seaweed();

	public SeaweedPortion(double amount) {
		super(seaweed, amount);

	}
}
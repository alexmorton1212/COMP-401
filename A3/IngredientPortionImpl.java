package a3;

public class IngredientPortionImpl implements IngredientPortion{

	private Ingredient ing;
	private double amount;
	
	public IngredientPortionImpl(Ingredient ing, double amount) {
		
		if (ing == null) {
			throw new RuntimeException("Ingredient cannot be null");
		}
		
		if (amount < 0) {
			throw new RuntimeException("Ingredient amount must be positive");
		}
		
		this.ing = ing;
		this.amount = amount;
		
	}


	public Ingredient getIngredient() {
		
		return ing;
	}

	public double getAmount() {
		
		return amount;
	}


	public String getName() {

		return ing.getName();
	}

	
	public boolean getIsVegetarian() {

		return ing.getIsVegetarian();
	}


	public double getCalories() {

		return ing.getCaloriesPerOunce() * amount;
	}


	public double getCost() {

		return ing.getPricePerOunce() * amount;
	}

	
	
	public IngredientPortion combine(IngredientPortion other) {

		if (other == null) {
			return this;
		}
		
		if (!other.getIngredient().equals(ing)) {
			throw new RuntimeException("ingredients must be the same");
		}
		
		double sum = other.getAmount() + this.getAmount();
		
		IngredientPortion counterPortion = new IngredientPortionImpl(ing, sum);
		return counterPortion;
	}

}

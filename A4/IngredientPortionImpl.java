package a4;

public class IngredientPortionImpl implements IngredientPortion {

	public Ingredient ingredient;
	public double amount;

	public IngredientPortionImpl(Ingredient ingredient, double amount) {

		if (ingredient == null) {
			throw new RuntimeException("Ingredient cannot be null");
		}

		if (amount < 0) {
			throw new RuntimeException("Ingredient amount must be positive");
		}

		this.ingredient = ingredient;
		this.amount = amount;


	}

	@Override
	public Ingredient getIngredient() {
		return ingredient;
	}

	@Override
	public String getName() {
		return getIngredient().getName();
	}

	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public double getCalories() {
		return getIngredient().getCaloriesPerOunce() * getAmount();
	}

	@Override
	public double getCost() {
		return getIngredient().getPricePerOunce() * getAmount();
	}

	@Override
	public boolean getIsVegetarian() {
		return getIngredient().getIsVegetarian();
	}

	@Override
	public boolean getIsRice() {
		return getIngredient().getIsRice();
	}

	@Override
	public boolean getIsShellfish() {
		return getIngredient().getIsShellfish();
	}

	@Override
	public IngredientPortion combine(IngredientPortion other) {

		if (other == null) {
			return this;
		}

		if (!other.getIngredient().equals(ingredient)) {
			throw new RuntimeException("ingredients must be the same");
		}

		double sum = other.getAmount() + this.getAmount();

		IngredientPortion counterPortion = new IngredientPortionImpl(ingredient, sum);
		return counterPortion;
	}
}



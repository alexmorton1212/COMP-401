package a3;

public class MenuItemImpl implements MenuItem{

	private String name;
	private IngredientPortion[] ingredients;
	
	public MenuItemImpl(String name, IngredientPortion[] ingredients) {
		
		if (name == null) {
			throw new RuntimeException("Name cannot be null");
		}
		if (ingredients == null) {
			throw new RuntimeException("Ingredient array cannot be null");
		}
		if (ingredients.length < 1) {
			throw new RuntimeException("Ingredients array must be greater than 0");
		}
		
		for (int i = 0; i < ingredients.length; i++) {
			if (ingredients[i] == null) {
				throw new RuntimeException("Ingredients cannot be null");
			}
		}
		
		this.name = name;
		this.ingredients = ingredients.clone();
	}

	public String getName() {
		return name;
	}
	
	public IngredientPortion[] getIngredients() {
		return ingredients.clone();
	}
	
	public int getCalories() {
		
		int sum = 0;
		for (int i = 0; i < ingredients.length; i++) {
			sum += ingredients[i].getCalories();
		}
		
		return sum;
	}
	
	public double getCost() {
		
		double sum = 0;
		for (int i = 0; i < ingredients.length; i++) {
			sum += ingredients[i].getCost();
		}
		
		return Math.round(sum * 100.0) / 100.0;
	}
	
	public boolean getIsVegetarian() {
		
		boolean veggie = true;
		
		for (int i = 0; i < ingredients.length; i++) {
			if (ingredients[i].getIsVegetarian() == false) {
				veggie = false;
			}
		}
		
		return veggie;
	}
	
}

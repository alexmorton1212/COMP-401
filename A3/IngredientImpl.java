package a3;


public class IngredientImpl implements Ingredient{
	
	private String name;
	private double price;
	private int calories;
	private boolean isVegetarian;
	
	public IngredientImpl(String name, double price, int calories, boolean isVegetarian) {
		
		if (name == null) {
			throw new RuntimeException("Name cannot be null");
		}
		if (calories < 0 || price < 0) {
			throw new RuntimeException("Numbers must be positive");
		}
		
		this.name = name;
		this.price = price;
		this.calories = calories;
		this.isVegetarian = isVegetarian;
		
	}

	public String getName() {
		
		return name;
	}

	public boolean getIsVegetarian() {
		
		return isVegetarian;
		
	}

	public double getPricePerOunce() {
	
		return price;
	}

	public int getCaloriesPerOunce() {
		
		return calories;
	}

	public double getCaloriesPerDollar() {
		
		return (double) calories/price;
	}
	
	
}
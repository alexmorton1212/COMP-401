package a4;

public class IngredientImpl implements Ingredient {

	public String name;
	public double price;
	public int calories;
	public boolean isRice;
	public boolean isShellfish;
	public boolean isVegetarian;

	public IngredientImpl(String name, double price, int calories, boolean isVegetarian, 
			boolean isRice, boolean isShellfish) {

		if (name == null) {
			throw new RuntimeException("Name cannot be null");
		}
		if (calories < 0 || price < 0) {
			throw new RuntimeException("Numbers must be positive");
		}

		this.name = name;
		this.price = price;
		this.calories = calories;
		this.isRice = isRice;
		this.isVegetarian = isVegetarian;
		this.isShellfish = isShellfish;
	}

	public String getName() {
		
		return name;
	}
	
	public double getCaloriesPerDollar() {
		
		return ( (double) calories/price);
	}
	
	public int getCaloriesPerOunce() {
		
		return calories;
	}
	
	public double getPricePerOunce() {
		
		return price;
	}
	
	public boolean equals(Ingredient other) {
		
		if (name.equals(other.getName()) && 
			calories == other.getCaloriesPerOunce() &&
			isVegetarian == other.getIsVegetarian() &&
			isShellfish == other.getIsRice() &&
			isRice == other.getIsRice() &&
			withinRange(other)) {
			
			return true;
		}
		
		return false;
	}
	
	public boolean getIsVegetarian() {
		
		return isVegetarian;
	}
	
	public boolean getIsRice() {
		
		return isRice;
	}
	
	public boolean getIsShellfish() {
		
		return isShellfish;
	}

	public boolean withinRange(Ingredient other) {
		
		double lowerBound = price - 0.01;
		double upperBound = price + 0.01;
		
		if (other.getPricePerOunce() >= lowerBound && other.getPricePerOunce() <= upperBound) {
			return true;
		}
		
		return false;
	}
	
}
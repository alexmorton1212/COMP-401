package a4;

public class AvocadoPortion extends IngredientPortionImpl {
	
	private static Ingredient avocado = new Avocado();
	
	public AvocadoPortion(double amount) {
		super(avocado, amount);
		
		}
	}

 
package a2;
	
	import java.util.ArrayList;
	import java.util.Scanner;
	
	public class A2Jedi {
	
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
	
			// Your code here.
			int numberIngredients = scan.nextInt();  // Number of ingredients
	
				String[] ingredientName = new String[numberIngredients];
				double[] pricePerOunce = new double[numberIngredients];
				boolean[] isVegetarian = new boolean[numberIngredients];
				double[] caloriesPerOunce = new double[numberIngredients];
	
	
			for (int a = 0; a < numberIngredients; a++) {  
	
				// Assigns each element of the line to an array
	
				ingredientName[a] = scan.next();
				pricePerOunce[a] = scan.nextDouble();
				isVegetarian[a] = scan.nextBoolean();
				caloriesPerOunce[a] = scan.nextDouble();
			}
	
			int numberMenuItems = scan.nextInt();
			String[] menuItemsArray = new String[numberMenuItems];
	
			String[][] ingredientsOfMenuItemAA = new String[numberMenuItems][];
			double[][] ouncesPerMenuItemIngredientAA = new double[numberMenuItems][];
	
			for (int b = 0; b < numberMenuItems; b++) {
	
				String menuItemName = scan.next();
				int ingredientsPerMenuItem = scan.nextInt();
				menuItemsArray[b] = menuItemName;
	
				String[] itemSpecificIngredientArray = new String[ingredientsPerMenuItem];
				double[] ouncesPerIngredientArray = new double[ingredientsPerMenuItem];
	
				for (int c = 0; c < ingredientsPerMenuItem; c++) {
	
					String itemSpecificIngredient = scan.next();
					itemSpecificIngredientArray[c] = itemSpecificIngredient;
					double ouncesPerIngredient = scan.nextDouble();
					ouncesPerIngredientArray[c] = ouncesPerIngredient;
					ingredientsOfMenuItemAA[b] = itemSpecificIngredientArray;
					ouncesPerMenuItemIngredientAA[b] = ouncesPerIngredientArray;
				}
	
			}

			ArrayList<String> orderedItems = new ArrayList<String>();

	
			while(!orderedItems.contains("EndOrder")) {
				orderedItems.add(scan.next());
			}
	
			if(orderedItems.contains("EndOrder")) {
				orderedItems.remove(orderedItems.size() - 1);
			}
	
			double[] ingredientOuncesCounter = new double[numberIngredients];
	
			System.out.println("The order will require:");
	
			for (int d = 0; d < (orderedItems.size()); d++) { // goes through each order (8)
	
				for (int e = 0; e < numberMenuItems; e++) { // goes through the number of menu items (4)
	
					if(orderedItems.get(d).equals(menuItemsArray[e])) { // checks if the item ordered matches a menu item
	
						for (int f = 0; f < numberIngredients; f++) { // goes through the number of different ingredients (6) <-- how many outputs there should be
	
							for (int g = 0; g < ingredientsOfMenuItemAA[e].length; g++) { // goes through how many ingredients are in the specific menu item
	
							if(ingredientsOfMenuItemAA[e][g].equals(ingredientName[f])) {
	
								ingredientOuncesCounter[f] += ouncesPerMenuItemIngredientAA[e][g];
							}
	
						}
	
	
					}
	
				}
	
			}
	
		}
	
			for (int ingr = 0; ingr < numberIngredients; ingr++) {
	
				System.out.println(String.format("%.2f", ingredientOuncesCounter[ingr]) + " ounces of " + ingredientName[ingr]);
	
			}
	
		scan.close();
	
		}
	
		// You can define helper methods here if needed.
	
	}
	
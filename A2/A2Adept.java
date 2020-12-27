package a2;

import java.util.Scanner;

public class A2Adept {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		

		int numberIngredients = scan.nextInt();  // Number of ingredients
		
		String[] ingredientName = new String[numberIngredients];
		double[] pricePerOunce = new double[numberIngredients];
		boolean[] isVegetarian = new boolean[numberIngredients];
		double[] caloriesPerOunce = new double[numberIngredients];
		
		
		
		
		for (int i = 0; i < numberIngredients; i++) {  
			
			// Assigns each element of the line to an array
			
			ingredientName[i] = scan.next();
			pricePerOunce[i] = scan.nextDouble();
			isVegetarian[i] = scan.nextBoolean();
			caloriesPerOunce[i] = scan.nextDouble();
		}
		
		
		int numberMenuItems = scan.nextInt();
		double[] costOfItem = new double[numberMenuItems];
		
		
		for (int j = 0; j < numberMenuItems; j++) {
			
			double priceAdd = 0;
			double calorieCount = 0;
			boolean vegetarianMenu = true;
			
			String menuItemName = scan.next();
			int ingredientsPerMenuItem = scan.nextInt();
			double[] ouncesPerIngredientArray = new double[ingredientsPerMenuItem];
			
			for (int a = 0; a < ingredientsPerMenuItem; a++) {
				
				
				
				String itemSpecificIngredient = scan.next();
				double ouncesPerIngredient = scan.nextDouble();
				
				ouncesPerIngredientArray[a] = ouncesPerIngredient;
				// System.out.println(ouncesPerIngredientArray[a]);
				
				for (int c = 0; c < numberIngredients; c++) {
					
					if(itemSpecificIngredient.equals(ingredientName[c])) {
						
						priceAdd += (pricePerOunce[c]*ouncesPerIngredient);
						calorieCount += (caloriesPerOunce[c]*ouncesPerIngredient);
						
						if(isVegetarian[c] == false) {
							vegetarianMenu = false;
						} else {
							
						}
						
					}
		
				}
		
			}
			
			System.out.println(menuItemName + ":");
			System.out.println((int) (calorieCount + 0.5) + " calories");
			System.out.println("$" + String.format("%.2f", priceAdd));
	
			if(vegetarianMenu == true) {
				System.out.println("Vegetarian");
			} else {
				System.out.println("Non-Vegetarian");
			}
		}
		
		
	// to get the price multiply the pricePerOunce by ouncesPerIngredient
		
	scan.close();
	}
	
	// You can define helper methods here if needed.
	
}
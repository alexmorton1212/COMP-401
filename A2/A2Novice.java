package a2;

import java.util.Scanner;

public class A2Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numberIngredients = scan.nextInt();  // Number of ingredients
		int numberVegetarian = 0;                // Counter for how many ingredients are vegetarian
		
		double highestCalsPerDollar = 0;         // Calculates the highest proportion of calories to dollars
		String highestCalsPerDollarName = "";    // Name of ingredient with highest calories per dollar
		
		double lowestCalsPerDollar = 0;          // Calculates the highest proportion of calories to dollars									
		String lowestCalsPerDollarName = "";     // Name of ingredient with highest calories per dollar
		
		
		String[] ingrediantName = new String[numberIngredients];
		double[] pricePerOunce = new double [numberIngredients];
		boolean[] isVegetarian = new boolean [numberIngredients];
		double[] caloriesPerOunce = new double [numberIngredients];
		
		
		for (int i = 0; i < numberIngredients; i++) {  
			
			// Assigns each element of the line to an array
			
			ingrediantName[i] = scan.next();
			pricePerOunce[i] = scan.nextDouble();
			isVegetarian[i] = scan.nextBoolean();
			caloriesPerOunce[i] = scan.nextDouble();
			
			if(isVegetarian[i]) {
				numberVegetarian += 1;
			}
			
			if(i == 0) {  // Assigns first ingredient to highest and lowest calories per dollar for comparison
				
				highestCalsPerDollar = caloriesPerOunce[i]/pricePerOunce[i];
				highestCalsPerDollarName = ingrediantName[i];
				lowestCalsPerDollar = caloriesPerOunce[i]/pricePerOunce[i];
				lowestCalsPerDollarName = ingrediantName[i];
				
			}
			
			if(highestCalsPerDollar < caloriesPerOunce[i]/pricePerOunce[i]) {  // Finds highest calorie per dollar ingredient

				highestCalsPerDollar = caloriesPerOunce[i]/pricePerOunce[i];
				highestCalsPerDollarName = ingrediantName[i];
			}
			
			if(lowestCalsPerDollar > caloriesPerOunce[i]/pricePerOunce[i]) {  // Finds lowest calorie per item ingredient
				
				lowestCalsPerDollar = caloriesPerOunce[i]/pricePerOunce[i];
				lowestCalsPerDollarName = ingrediantName[i];
			}
			
		}
		
		// Outputs
		
		System.out.println("Number of vegetarian ingredients: " + numberVegetarian);
		System.out.println("Highest cals/$: " + highestCalsPerDollarName);
		System.out.println("Lowest cals/$: " + lowestCalsPerDollarName);
		
		scan.close();
	}
}
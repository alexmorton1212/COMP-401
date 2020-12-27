package a1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A1Jedi {
	@SuppressWarnings("unused")
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		
		int numFoodItems = scan.nextInt();
		
		String[] itemNames = new String[numFoodItems];
		double[] itemPrices = new double[numFoodItems];
		int[] itemCounter = new int[numFoodItems]; // Counts how many of each item is bought
		int[] customerBuys = new int[numFoodItems]; // Counts how many customers purchased the item
		
		List<String> countItem = new ArrayList<String>(); // Used to keep track of item types per customer

		
		// Creates array of products and prices
		/* Stores product names and their prices at same index
		 */
		
		for (int i = 0; i < numFoodItems; i++) {
			
			itemNames[i] = scan.next();
			itemPrices[i] = scan.nextDouble();
		}
		
		int numCustomers = scan.nextInt();

		
		// Iterates through each customer 
		/* Result:
		 * Increments the amount of customers who bought a specific item
		 * and how many times a specific item was bought
		 */

		for (int a = 0; a < numCustomers; a++) {

			String firstName = scan.next(); 
			String lastName = scan.next(); 
			int itemTypesTotal = scan.nextInt();


			// Iterates through how many types of items each customer bought
			
			for (int b = 0; b < itemTypesTotal; b++) { 
				
				int indivItemCount = scan.nextInt();
				String itemName = scan.next();
				
				
				// Iterates through how many of a specific item was purchased
				/* Uses this number to increment item counts
				 * and customer counts (if they bought the item)
				 */

				for (int c = 0; c < numFoodItems; c++) { 
					
					if (itemName.equals(itemNames[c])) {
						
						itemCounter[c] += indivItemCount;

						if (!countItem.contains(itemName)) { // Checks if an item type has already counted for the customer

							customerBuys[c] += 1;
							countItem.add(itemName); // Eliminates possibility item types are counted more than once per customer

						}
					}	
				}
			}	
			
			countItem.clear();	/* Resets the item type list for each customer
			 					 * Otherwise, code would max out at 1 customer per item type
			 					 */
		}


		/* Iterates through the types of foods
		 * Output:
		 * How many customers bought a specific food
		 * and how many of that food item was bought
		 */
		
		for (int a = 0; a < numFoodItems; a++) {

			if (itemCounter[a] == 0) {
				System.out.println("No customers bought " + itemNames[a]);
			} else {
				System.out.println(customerBuys[a] + " customers bought " + itemCounter[a] + " " + itemNames[a]);
			}
		}

		scan.close();
	}

}


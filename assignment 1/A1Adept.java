package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int numFoodItems = scan.nextInt();
		double allCustomersTotal = 0; // Counter for adding all customer purchases
		double max = 0;
		String maxName = null;
		double min = 0;
		String minName = null;


		// Assign item name and price to arrays

		String[] itemNames = new String[numFoodItems];
		double[] itemPrices = new double[numFoodItems];


		// Creates array of products and prices
		/* Stores product names and prices as same index
		 * but in different arrays 
		 */

		for (int i = 0; i < numFoodItems; i++) {
			itemNames[i] = scan.next();
			itemPrices[i] = scan.nextDouble();
		}


		int numCustomers = scan.nextInt();


		// Goes through each customer and gives their purchase total 
		/* Output:
		 * Largest and smallest buyers with amounts
		 * Average of all customer purchases
		 */

		for (int a = 0; a < numCustomers;  a++) {

			double custTotal = 0; // Resets total for each customer

			String firstName = scan.next();
			String lastName = scan.next();
			String custName = firstName + " " + lastName; // Combines customer name into one value


			int itemTypesBought = scan.nextInt(); 


			// Iterates through how many types of items each customer bought

			for (int b = 0; b < itemTypesBought; b++) {

				int indivItemCount = scan.nextInt();
				String itemName = scan.next();

				
				// Iterates through how many of a specific item was purchased

				for (int c = 0; c < indivItemCount; c++) {
					

					// Iterates through number of food items
					/* Customer specific total increases by the price
					 * of the purchased item
					 */
					
					for (int d = 0; d < numFoodItems; d++) {

						if (itemName.equals(itemNames[d])) {
							custTotal += itemPrices[d];
						}		
					}
				}

				
				// Adds customer total to all customers total
				
				if (b == itemTypesBought - 1) {  
					allCustomersTotal += custTotal;
				}
				
			}

			
			// Initializes min and max values to first customer total
			
			if (a == 0) {
				min = custTotal;
				max = custTotal;
			}

			
			/* Checks if current min and max need to
			 * change based on the next customer total
			 */
			
			if (custTotal > max || custTotal == max) {
				max = custTotal;
				maxName = custName;
			}
			
			if (custTotal < min || custTotal == min) {
				min = custTotal;
				minName = custName;
			}
			
			
			// Prints outputs when last customer has been reached

			if (a == numCustomers - 1) {

				System.out.println("Biggest: " + maxName + " (" + String.format("%.2f", max) + ")");
				System.out.println("Smallest: " + minName + " (" + String.format("%.2f", min) + ")");
				System.out.println("Average: " + String.format("%.2f", allCustomersTotal/numCustomers));
			}


		}

		scan.close();
	}

}


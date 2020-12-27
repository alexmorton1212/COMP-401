package a1;

import java.util.Scanner;

public class A1Novice {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);


		int numCustomers = scan.nextInt(); 


		/* Iterates through the number of customers
		 * Output:
		 * Customer first and last name with total
		 */
	
		for (int a = numCustomers; a > 0; a--) {

			double priceTotal = 0; // Resets the total for each customer

			String custFirst = scan.next();
			String custLast = scan.next();
			int numItems = scan.nextInt(); 

			
			// Iterates through each customers number of items
			// Increments total based on item price

			for (int i = numItems; i > 0; i--) {
				
				double itemCount = scan.nextDouble(); 
				String food = scan.next(); 
				double price = scan.nextDouble();
				
				priceTotal = priceTotal + (itemCount * price);
			}
			
			
			// Name and total for each customer

			System.out.println(firstLetter(custFirst) + ". " + custLast + ": " + String.format("%.2f", priceTotal));
		}
		
		scan.close();	

	}

	
	/* Input: some String name
	 * Output: first letter of String name
	 */
	
	public static String firstLetter(String name) {
		return name.substring(0, 1);
	}

}
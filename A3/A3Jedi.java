package a3;

import java.util.Scanner;

public class A3Jedi {


	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int numIngrs = scan.nextInt();
		Ingredient[] ingrsArray = new Ingredient[numIngrs];

		for (int i = 0; i < numIngrs; i++) {

			String name = scan.next();
			double price = scan.nextDouble();
			boolean vege = scan.nextBoolean();
			int calories = scan.nextInt();

			ingrsArray[i] = new IngredientImpl(name, price, calories, vege);
		}


		int numMenu = scan.nextInt();
		MenuItem[] menuItemsArray = new MenuItem[numMenu];



		for (int a = 0; a < numMenu; a++) {

			String menuName = scan.next();

			int ingrsPerMenu = scan.nextInt();


			IngredientPortion[] ingrsPortionArray = new IngredientPortion[ingrsPerMenu];

			for (int b = 0; b < ingrsPerMenu; b++) {

				String ingredientName = scan.next();

				for (int c = 0; c < numIngrs; c++) {

					if (ingredientName.equals(ingrsArray[c].getName())) {

						ingrsPortionArray[b] = new IngredientPortionImpl(ingrsArray[c], scan.nextDouble());

					}
				}
			}

			MenuItem menuItems = new MenuItemImpl(menuName, ingrsPortionArray);
			menuItemsArray[a] = menuItems;

		}


		String sushiName = scan.next();

		double[] amounts = new double[numIngrs];


		while(!sushiName.equals("EndOrder")) {

			MenuItem someMenuItem = findMenuItem(sushiName, menuItemsArray);

			for (int j = 0; j < someMenuItem.getIngredients().length; j++) {

				String nameOfIngr = someMenuItem.getIngredients()[j].getName();
				int someIngredientIndex = findIndex(nameOfIngr, ingrsArray);


				amounts[someIngredientIndex] += someMenuItem.getIngredients()[j].getAmount();
			}

			sushiName = scan.next(); 
		}

		System.out.println("The order will require:");

		for (int k = 0; k < numIngrs; k++) {

			System.out.println(String.format("%.2f", amounts[k]) + " ounces of " + ingrsArray[k].getName());

		}

		scan.close();

	}		


	public static int findIndex(String name, Ingredient[] ingrsArray) {

		for (int i = 0; i < ingrsArray.length; i++) {

			if (name.equals(ingrsArray[i].getName())) {
				return i;
			}
		}
		return 0;
	}	



	public static MenuItem findMenuItem(String name, MenuItem[] menuItemsArray) {

		for (int i = 0; i < menuItemsArray.length; i++) {

			if (name.equals(menuItemsArray[i].getName())) {
				return menuItemsArray[i];
			}
		}
		return menuItemsArray[0];
	}	
}


package sushigame.view;

import javax.swing.*;

import comp401sushi.*;
import sushigame.model.*;

public class PlateViewWidget extends JPanel {
	
	private Belt belt;
	private int position;
	private JLabel plabel;
	private String text;
	private String type;
	private PlayerChefView view;
	
	public PlateViewWidget(Belt belt, int position) {
		
		view = new PlayerChefView(20);
		this.belt = belt;
		this.position = position;
		plabel = new JLabel();
		add(plabel);
		this.text = "No Plate at this Position";
		
	}
	
	public void getPlateInfo(Plate plate) {
		
		String chef = plate.getChef().getName();
		String ingredients = "";
		String name = "";
		int age = belt.getAgeOfPlateAtPosition(position);
		
		
		if (plate.getContents().getName().contains("Roll")) {
			
			for (int i = 0; i < plate.getContents().getIngredients().length; i++) {
				
				IngredientPortion ingrs = plate.getContents().getIngredients()[i];
				ingredients += ingrs.getName() + ": " + (Math.round(ingrs.getAmount() *100.0)/100.0) + "  ";
				
			}
			
		} 
		
		name = plate.getContents().getName().toString();
		type = plate.getContents().getName().toString();
		
		
		if (name.contains("Roll")) {
			
			this.text = "Type of Sushi: " + name + ", " + "Chef Name: " + chef + ", " +  "Age of Plate: " + age + ", " + "Ingredients: " + ingredients;
			
		} else {
			
			this.text = "Type of Sushi: " + name + ", " + "Chef Name: " + chef + ", " + "Age of Plate: " + age;
		}
		
		if (type.contains("sashimi")) {
			
			type = "SASHIMI";
			
		} else if (type.contains("Roll")) {
			
			type = "ROLL";
			
		} else if (type.contains("nigiri")) {
			
			type = "NIGIRI";
		}
		
		
		
	}
	
	public String getInfo() {
		
		return text;
	}
	
	public void clearInfo() {
		
		text = "";
	}
	
	public void clearText() {

		plabel.setText("No Plate");
	}

	public void labelText() {
		
		plabel.setText(type);
	}
	
	public void backgroundText(int a) {
		
		plabel.setText("Position: " + a);
	}

}

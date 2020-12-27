package sushigame.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import comp401sushi.*;
import comp401sushi.CrabPortion;
import comp401sushi.EelPortion;
import comp401sushi.IngredientPortion;
import comp401sushi.Nigiri;
import comp401sushi.Nigiri.NigiriType;
import comp401sushi.Plate;
import comp401sushi.RedPlate;
import comp401sushi.Roll;
import comp401sushi.Sashimi;
import comp401sushi.Sashimi.SashimiType;
import comp401sushi.SeaweedPortion;
import comp401sushi.Sushi;

public class PlayerChefView extends JPanel implements ActionListener {

	private List<ChefViewListener> listeners;

	private int belt_size;
	private int position;
	private NigiriType seaNigiri;
	private SashimiType seaSashimi;

	private JSlider positionSlider;
	private JSlider costSlider;
	private JComboBox<String> colorDropDown;
	private JComboBox<String> seafoodDropDown;
	private JTextField inputRoll;

	private JLabel display;

	private JSlider avocadoSlider;
	private JSlider crabSlider;
	private JSlider eelSlider;
	private JSlider riceSlider;
	private JSlider seaweedSlider;
	private JSlider shrimpSlider;
	private JSlider tunaSlider;
	private JSlider yellowtailSlider;

	private JLabel colorChoice;
	private JLabel seaChoice;
	private JLabel sushiChoice;
	private JLabel positionSet;
	private JLabel space;
	
	private String rollroll;

	public PlayerChefView(int belt_size) {

		this.belt_size = belt_size;
		this.rollroll = "";
		listeners = new ArrayList<ChefViewListener>();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Title Frame

		JPanel frame0 = new JPanel();
		frame0.setLayout(new GridLayout());
		add(frame0);

		display = new JLabel();
		display.setText(makeTitleHTML());
		display.setHorizontalAlignment(JLabel.CENTER);
		frame0.add(display);

		// Dropdown Frame

		JPanel framed1 = new JPanel();
		framed1.setLayout(new GridLayout());
		add(framed1);

		colorChoice = new JLabel();
		colorChoice.setText("   Choose Plate Color");

		framed1.add(colorChoice);

		String[] colorChoices = {"Red","Blue","Green","Gold"};
		colorDropDown = new JComboBox<String>(colorChoices);
		colorDropDown.addActionListener(this);
		add(colorDropDown);

		costSlider = new JSlider(JSlider.HORIZONTAL, 500, 1000, 750);
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(500, new JLabel("5.0") );
		labelTable.put(550, new JLabel("5.5") );
		labelTable.put(600, new JLabel("6.0") );
		labelTable.put(650, new JLabel("6.5") );
		labelTable.put(700, new JLabel("7.0") );
		labelTable.put(750, new JLabel("7.5") );
		labelTable.put(800, new JLabel("8.0") );
		labelTable.put(850, new JLabel("8.5") );
		labelTable.put(900, new JLabel("9.0") );
		labelTable.put(950, new JLabel("9.5") );
		labelTable.put(1000, new JLabel("10.0") );

		JPanel frames1 = new JPanel();
		frames1.setLayout(new GridLayout());
		add(frames1);

		JLabel costLabel = new JLabel("   Choose Plate Price (if making a Gold Plate)");
		costSlider.setLabelTable(labelTable);
		costSlider.setMajorTickSpacing(50);
		costSlider.setPaintTicks(true);
		costSlider.setPaintLabels(true);
		costLabel.setHorizontalAlignment(JLabel.LEFT);
		frames1.add(costLabel);
		add(costSlider);

		JPanel framed2 = new JPanel();
		framed2.setLayout(new GridLayout());
		add(framed2);

		seaChoice = new JLabel();
		seaChoice.setText("   Choose Meat (if making Sashimi or Nigiri)");
		seaChoice.setHorizontalAlignment(JLabel.LEFT);
		framed2.add(seaChoice);

		String[] seafoodChoices = {"Tuna","Yellowtail","Eel","Crab","Shrimp"};
		seafoodDropDown = new JComboBox<String>(seafoodChoices);
		seafoodDropDown.addActionListener(this);
		add(seafoodDropDown);


		// Frame 2

		inputRoll = new JTextField();


		JPanel framing = new JPanel();
		framing.setLayout(new GridLayout());
		add(framing);
		sushiChoice = new JLabel();
		sushiChoice.setText("   Enter Name of Roll and Set Ingredients (if making Roll)");
		sushiChoice.setHorizontalAlignment(JLabel.LEFT);

		framing.add(sushiChoice);
		add(inputRoll);

		JPanel spaceFrame = new JPanel();
		spaceFrame.setLayout(new GridLayout());
		add(spaceFrame);
		
		space = new JLabel();
		space.setText("                             ");
		space.setHorizontalAlignment(JLabel.CENTER);
		spaceFrame.add(space);

		JPanel frame2 = new JPanel();
		frame2.setLayout(new BorderLayout());
		add(frame2);

		JPanel mini2A = new JPanel();
		mini2A.setLayout(new BorderLayout());

		JPanel mini2B = new JPanel();
		mini2B.setLayout(new BorderLayout());

		JLabel avocadoLabel = new JLabel("Avocado Amount (ounces)");
		avocadoSlider = new JSlider(JSlider.HORIZONTAL, 0, 150, 0);
		Hashtable<Integer, JLabel> avocadoTable = new Hashtable<Integer, JLabel>();
		avocadoTable.put(0, new JLabel("0.0") );
		avocadoTable.put(50, new JLabel("0.50") );
		avocadoTable.put(100, new JLabel("1.0") );
		avocadoTable.put(150, new JLabel("1.50") );
		avocadoSlider.setLabelTable(avocadoTable);
		avocadoSlider.setMajorTickSpacing(10);
		avocadoSlider.setPaintTicks(true);
		avocadoSlider.setPaintLabels(true);
		avocadoLabel.setHorizontalAlignment(JLabel.CENTER);
		avocadoLabel.setVerticalAlignment(JLabel.CENTER);

		JLabel crabLabel = new JLabel("Crab Amount (ounces)");
		crabSlider = new JSlider(JSlider.HORIZONTAL, 0, 150, 0);
		Hashtable<Integer, JLabel> crabTable = new Hashtable<Integer, JLabel>();
		crabTable.put(0, new JLabel("0.0") );
		crabTable.put(50, new JLabel("0.50") );
		crabTable.put(100, new JLabel("1.0") );
		crabTable.put(150, new JLabel("1.50") );
		crabSlider.setLabelTable(crabTable);
		crabSlider.setMajorTickSpacing(10);
		crabSlider.setPaintTicks(true);
		crabSlider.setPaintLabels(true);
		crabLabel.setHorizontalAlignment(JLabel.CENTER);
		crabLabel.setVerticalAlignment(JLabel.CENTER);

		frame2.add(mini2A, BorderLayout.WEST);
		mini2A.add(avocadoLabel, BorderLayout.NORTH);
		mini2A.add(avocadoSlider, BorderLayout.CENTER);
		frame2.add(mini2B, BorderLayout.EAST);
		mini2B.add(crabLabel, BorderLayout.NORTH);
		mini2B.add(crabSlider, BorderLayout.CENTER);


		// Frame 3

		JPanel frame3 = new JPanel();
		frame3.setLayout(new BorderLayout());
		add(frame3);

		JPanel mini3A = new JPanel();
		mini3A.setLayout(new BorderLayout());

		JPanel mini3B = new JPanel();
		mini3B.setLayout(new BorderLayout());

		JLabel eelLabel = new JLabel("Eel Amount (ounces)");		
		eelSlider = new JSlider(JSlider.HORIZONTAL, 0, 150, 0);
		Hashtable<Integer, JLabel> eelTable = new Hashtable<Integer, JLabel>();
		eelTable.put(0, new JLabel("0.0") );
		eelTable.put(50, new JLabel("0.50") );
		eelTable.put(100, new JLabel("1.0") );
		eelTable.put(150, new JLabel("1.50") );
		eelSlider.setLabelTable(eelTable);
		eelSlider.setMajorTickSpacing(10);
		eelSlider.setPaintTicks(true);
		eelSlider.setPaintLabels(true);
		eelLabel.setHorizontalAlignment(JLabel.CENTER);
		eelLabel.setVerticalAlignment(JLabel.CENTER);

		JLabel riceLabel = new JLabel("Rice Amount (ounces)");
		riceSlider = new JSlider(JSlider.HORIZONTAL, 0, 150, 0);
		Hashtable<Integer, JLabel> riceTable = new Hashtable<Integer, JLabel>();
		riceTable.put(0, new JLabel("0.0") );
		riceTable.put(50, new JLabel("0.50") );
		riceTable.put(100, new JLabel("1.0") );
		riceTable.put(150, new JLabel("1.50") );
		riceSlider.setLabelTable(riceTable);
		riceSlider.setMajorTickSpacing(10);
		riceSlider.setPaintTicks(true);
		riceSlider.setPaintLabels(true);
		riceLabel.setHorizontalAlignment(JLabel.CENTER);
		riceLabel.setVerticalAlignment(JLabel.CENTER);

		frame3.add(mini3A, BorderLayout.WEST);
		mini3A.add(eelLabel, BorderLayout.NORTH);
		mini3A.add(eelSlider, BorderLayout.CENTER);
		frame3.add(mini3B, BorderLayout.EAST);
		mini3B.add(riceLabel, BorderLayout.NORTH);
		mini3B.add(riceSlider, BorderLayout.CENTER);

		// Frame 4

		JPanel frame4 = new JPanel();
		frame4.setLayout(new BorderLayout());
		add(frame4);

		JPanel mini4A = new JPanel();
		mini4A.setLayout(new BorderLayout());

		JPanel mini4B = new JPanel();
		mini4B.setLayout(new BorderLayout());

		JLabel seaweedLabel = new JLabel("Seaweed Amount (ounces)");		
		seaweedSlider = new JSlider(JSlider.HORIZONTAL, 0, 150, 0);
		Hashtable<Integer, JLabel> seaweedTable = new Hashtable<Integer, JLabel>();
		seaweedTable.put(0, new JLabel("0.0") );
		seaweedTable.put(50, new JLabel("0.50") );
		seaweedTable.put(100, new JLabel("1.0") );
		seaweedTable.put(150, new JLabel("1.50") );
		seaweedSlider.setLabelTable(seaweedTable);
		seaweedSlider.setMajorTickSpacing(10);
		seaweedSlider.setPaintTicks(true);
		seaweedSlider.setPaintLabels(true);
		seaweedLabel.setHorizontalAlignment(JLabel.CENTER);
		seaweedLabel.setVerticalAlignment(JLabel.CENTER);

		JLabel shrimpLabel = new JLabel("Shrimp Amount (ounces)");
		shrimpSlider = new JSlider(JSlider.HORIZONTAL, 0, 150, 0);
		Hashtable<Integer, JLabel> shrimpTable = new Hashtable<Integer, JLabel>();
		shrimpTable.put(0, new JLabel("0.0") );
		shrimpTable.put(50, new JLabel("0.50") );
		shrimpTable.put(100, new JLabel("1.0") );
		shrimpTable.put(150, new JLabel("1.50") );
		shrimpSlider.setLabelTable(shrimpTable);
		shrimpSlider.setMajorTickSpacing(10);
		shrimpSlider.setPaintTicks(true);
		shrimpSlider.setPaintLabels(true);
		shrimpLabel.setHorizontalAlignment(JLabel.CENTER);
		shrimpLabel.setVerticalAlignment(JLabel.CENTER);

		frame4.add(mini4A, BorderLayout.WEST);
		mini4A.add(seaweedLabel, BorderLayout.NORTH);
		mini4A.add(seaweedSlider, BorderLayout.CENTER);
		frame4.add(mini4B, BorderLayout.EAST);
		mini4B.add(shrimpLabel, BorderLayout.NORTH);
		mini4B.add(shrimpSlider, BorderLayout.CENTER);


		// Frame 5

		JPanel frame5 = new JPanel();
		frame5.setLayout(new BorderLayout());
		add(frame5);

		JPanel mini5A = new JPanel();
		mini5A.setLayout(new BorderLayout());

		JPanel mini5B = new JPanel();
		mini5B.setLayout(new BorderLayout());

		JLabel tunaLabel = new JLabel("Tuna Amount (ounces)");		
		tunaSlider = new JSlider(JSlider.HORIZONTAL, 0, 150, 0);
		Hashtable<Integer, JLabel> tunaTable = new Hashtable<Integer, JLabel>();
		tunaTable.put(0, new JLabel("0.0") );
		tunaTable.put(50, new JLabel("0.50") );
		tunaTable.put(100, new JLabel("1.0") );
		tunaTable.put(150, new JLabel("1.50") );
		tunaSlider.setLabelTable(tunaTable);
		tunaSlider.setMajorTickSpacing(10);
		tunaSlider.setPaintTicks(true);
		tunaSlider.setPaintLabels(true);
		tunaLabel.setHorizontalAlignment(JLabel.CENTER);
		tunaLabel.setVerticalAlignment(JLabel.CENTER);

		JLabel yellowtailLabel = new JLabel("Yellowtail Amount (ounces)");
		yellowtailSlider = new JSlider(JSlider.HORIZONTAL, 0, 150, 0);
		Hashtable<Integer, JLabel> yellowtailTable = new Hashtable<Integer, JLabel>();
		yellowtailTable.put(0, new JLabel("0.0") );
		yellowtailTable.put(50, new JLabel("0.50") );
		yellowtailTable.put(100, new JLabel("1.0") );
		yellowtailTable.put(150, new JLabel("1.50") );
		yellowtailSlider.setLabelTable(yellowtailTable);
		yellowtailSlider.setMajorTickSpacing(10);
		yellowtailSlider.setPaintTicks(true);
		yellowtailSlider.setPaintLabels(true);
		yellowtailLabel.setHorizontalAlignment(JLabel.CENTER);
		yellowtailLabel.setVerticalAlignment(JLabel.CENTER);

		frame5.add(mini5A, BorderLayout.WEST);
		mini5A.add(tunaLabel, BorderLayout.NORTH);
		mini5A.add(tunaSlider, BorderLayout.CENTER);
		frame5.add(mini5B, BorderLayout.EAST);
		mini5B.add(yellowtailLabel, BorderLayout.NORTH);
		mini5B.add(yellowtailSlider, BorderLayout.CENTER);



		// Sushi Frame 1




		// Slider that allows user to input a position

		JPanel framedp = new JPanel();
		framedp.setLayout(new GridLayout());
		add(framedp);

		positionSet = new JLabel();
		positionSet.setText("   Choose Position to Set Plate at");
		positionSet.setHorizontalAlignment(JLabel.CENTER);

		framedp.add(positionSet);



		JLabel positionLabel = new JLabel("Choose a Position to Place the Plate");
		positionSlider = new JSlider(0,19,10);
		positionSlider.setMajorTickSpacing(2);
		positionSlider.setPaintTicks(true);
		positionSlider.setPaintLabels(true);
		add(positionSlider);

		JPanel framesus = new JPanel();
		framesus.setLayout(new GridLayout());
		add(framesus);
		sushiChoice = new JLabel();
		sushiChoice.setText("   Choose Sushi Type");
		sushiChoice.setHorizontalAlignment(JLabel.CENTER);
		framesus.add(sushiChoice);


		//		add(Box.createVerticalGlue());

		JPanel frame1 = new JPanel();
		frame1.setLayout(new GridLayout());
		add(frame1);

		JButton sashimi_button = new JButton("Make Sashimi");
		sashimi_button.setActionCommand("make sashimi");
		sashimi_button.addActionListener(this);
		frame1.add(sashimi_button);


		JButton nigiri_button = new JButton("Make Nigiri");
		nigiri_button.setActionCommand("make nigiri");
		nigiri_button.addActionListener(this);
		frame1.add(nigiri_button);


		JButton roll_button = new JButton("Make Roll");
		roll_button.setActionCommand("make roll");
		roll_button.addActionListener(this);
		frame1.add(roll_button);
		roll_button.setMinimumSize(new Dimension(20, 20));
		roll_button.setPreferredSize(new Dimension(20, 20));


	}

	public void registerChefListener(ChefViewListener cl) {
		listeners.add(cl);
	}

	private void makeRedPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleRedPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeGreenPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleGreenPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeBluePlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleBluePlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeGoldPlateRequest(Sushi plate_sushi, int plate_position, double price) {
		for (ChefViewListener l : listeners) {
			l.handleGoldPlateRequest(plate_sushi, plate_position, price);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int position = positionSlider.getValue();
		String color = colorDropDown.getSelectedItem().toString();
		String seafood = seafoodDropDown.getSelectedItem().toString();
		rollroll = inputRoll.getText();
		double goldPrice = Math.round((costSlider.getValue()/100.0)*100.0)/100.0;

		if (seafood.equals("Tuna")) {
			seaNigiri = NigiriType.TUNA;
			seaSashimi = SashimiType.TUNA;
		} else if (seafood.equals("Yellowtail")) {
			seaNigiri = NigiriType.YELLOWTAIL;
			seaSashimi = SashimiType.YELLOWTAIL;
		} else if (seafood.equals("Eel")) {
			seaNigiri = NigiriType.EEL;
			seaSashimi = SashimiType.EEL;
		} else if (seafood.equals("Crab")) {
			seaNigiri = NigiriType.CRAB;
			seaSashimi = SashimiType.CRAB;
		} else if (seafood.equals("Shrimp")) {
			seaNigiri = NigiriType.SHRIMP;
			seaSashimi = SashimiType.SHRIMP;
		}



		switch (e.getActionCommand()) {

		case "make sashimi":

			switch (color) {
			case "Red":
				makeRedPlateRequest(new Sashimi(seaSashimi), position);
				break;
			case "Blue":
				makeBluePlateRequest(new Sashimi(seaSashimi), position);
				break;
			case "Green":
				makeGreenPlateRequest(new Sashimi(seaSashimi), position);
				break;
			case "Gold":
				makeGoldPlateRequest(new Sashimi(seaSashimi), position, goldPrice);
				break;
			}


		case "make nigiri":

			switch (color) {
			case "Red":
				makeRedPlateRequest(new Nigiri(seaNigiri), position);
				break;

			case "Blue":
				makeBluePlateRequest(new Nigiri(seaNigiri), position);
				break;

			case "Green":
				makeGreenPlateRequest(new Nigiri(seaNigiri), position);
				break;

			case "Gold":
				makeGoldPlateRequest(new Nigiri(seaNigiri), position, goldPrice);
				break;
			}

		case "make roll":

			switch (color) {
			case "Red":
				makeRedPlateRequest(new Roll(rollroll + " Roll", getIngr()), position);
				break;

			case "Blue":
				makeBluePlateRequest(new Roll(rollroll + " Roll", getIngr()), position);
				break;

			case "Green":
				makeGreenPlateRequest(new Roll(rollroll + " Roll", getIngr()), position);
				break;

			case "Gold":
				makeGoldPlateRequest(new Roll(rollroll + " Roll", getIngr()), position, goldPrice);
				break;
			}
		}
	}

	public IngredientPortion[] getIngr() {

		List<IngredientPortion> ings = new ArrayList<IngredientPortion>();

		double avo = Math.round((avocadoSlider.getValue()/100.0) * 100.00)/100.00;
		double cra = Math.round((crabSlider.getValue()/100.0) * 100.0)/100.0;
		double ee = Math.round((eelSlider.getValue()/100.0) * 100.0)/100.0;
		double ric = Math.round((riceSlider.getValue()/100.0) * 100.0)/100.0;
		double sea = Math.round((seaweedSlider.getValue()/100.0) * 100.0)/100.0;
		double shr = Math.round((shrimpSlider.getValue()/100.0) * 100.0)/100.0;
		double tun = Math.round((tunaSlider.getValue()/100.0) * 100.0)/100.0;
		double yell = Math.round((yellowtailSlider.getValue()/100.0) * 100.0)/100.0;

		if (avo != 0.0) {
			ings.add(new AvocadoPortion(avo));
		}
		if (cra != 0.0) {
			ings.add(new CrabPortion(cra));
		}
		if (ee != 0.0) {
			ings.add(new EelPortion(ee));
		}
		if (ric != 0.0) {
			ings.add(new RicePortion(ric));
		}
		if (sea != 0.0) {
			ings.add(new SeaweedPortion(sea));
		}
		if (shr != 0.0) {
			ings.add(new ShrimpPortion(shr));
		}
		if (tun != 0.0) {
			ings.add(new TunaPortion(tun));
		}
		if (yell != 0.0) {
			ings.add(new YellowtailPortion(yell));
		}

		IngredientPortion[] send = ings.toArray(new IngredientPortion[ings.size()]);
		return send;

	}

	private String makeTitleHTML() {
		String sb_html = "<html>";
		sb_html += "<h1>Make Sushi</h1>";

		return sb_html;
	}
	
	public String getRollInput() {
		return rollroll;
	}

}

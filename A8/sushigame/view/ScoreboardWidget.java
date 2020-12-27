package sushigame.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;
import sushigame.model.Chef;
import sushigame.model.SushiGameModel;

public class ScoreboardWidget extends JPanel implements BeltObserver, ActionListener {

	private SushiGameModel game_model;
	private JLabel display;
	private String action;
	private Chef[] chefs;
	private Chef[] opponentChefs;
	private JLabel sortLabel;
	private JLabel sortLabe;
	private JComboBox<String> sortDropDown;


	public ScoreboardWidget(SushiGameModel gm) {
		
		
		game_model = gm;
		game_model.getBelt().registerBeltObserver(this);
		action = "";
		
//		frame5.add(mini5A, BorderLayout.WEST);
		
		JPanel frame0 = new JPanel();
		frame0.setLayout(new BorderLayout());
		add(frame0);
		
		display = new JLabel();
		display.setText(makeScoreboardHTML());
		display.setHorizontalAlignment(JLabel.CENTER);
		frame0.add(display, BorderLayout.NORTH);

//		sortLabe = new JLabel();
//		sortLabe.setText("                       ");
////		sortLabel.setHorizontalAlignment(JLabel.CENTER);
//		frame0.add(sortLabe, BorderLayout.SOUTH);
		
		sortLabel = new JLabel();
		sortLabel.setText("  Choose How The Leaderboard Will Be Sorted  ");
//		sortLabel.setHorizontalAlignment(JLabel.CENTER);
		frame0.add(sortLabel, BorderLayout.CENTER);
//		
		sortDropDown = new JComboBox<String>();
		String[] sortChoices = {"Balance","Spoiled","Consumed"};
		sortDropDown = new JComboBox<String>(sortChoices);
		sortDropDown.addActionListener(this);
		frame0.add(sortDropDown, BorderLayout.AFTER_LAST_LINE);

		
		// Dropdown Frame

//		JPanel framed1 = new JPanel();
//		framed1.setLayout(new GridLayout());
//		add(framed1);

//		colorChoice = new JLabel();
//		colorChoice.setText("   Choose Plate Color");


		
//		JPanel scoreboard = new JPanel();
//
//		scoreboard.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//		
//		JPanel frame1 = new JPanel();
//		frame1.setLayout(new BorderLayout());
//		(JLabel.NORTH);
//		
//		display = new JLabel();
//		display.setText(makeScoreboardHTML());
//		display.setHorizontalAlignment(JLabel.CENTER);
//		
//		add(display);
//
//		
//		JPanel panel = new JPanel();
//		panel.setLayout(new GridLayout());
//		add(panel);
//
		
//		
//		JPanel panel2 = new JPanel();
//		panel2.setLayout(new GridLayout());
//		add(panel2);
//


		//		JButton balance = new JButton("Balance");
		//		balance.setActionCommand("Balance");
		//		balance.addActionListener(this);
		//
		//		JButton sold = new JButton("Sold");
		//		sold.setActionCommand("Sold");
		//		sold.addActionListener(this);
		//
		//		JButton spoiled = new JButton("Spoiled");
		//		spoiled.setActionCommand("Spoiled");
		//		spoiled.addActionListener(this);
		
		

//		panel.add(sortLabel);
//		panel.add(sortDropDown);

		
		//		panel.add(balance, BorderLayout.WEST);
		//		panel.add(sold, BorderLayout.CENTER);
		//		panel.add(spoiled, BorderLayout.EAST);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String sorted = sortDropDown.getSelectedItem().toString();

		switch(sorted) {
		case "Balance":
			action = "Balance";
			break;
		case "Consumed":
			action = "Consumed";
			break;
		case "Spoiled":
			action = "Spoiled";
			break;
		}

	}

	private String makeScoreboardHTML() {

		String sb_html = "<html>";
		sb_html += "<h1>Scoreboard</h1>";

		// Create an array of all chefs and sort by balance.
		opponentChefs= game_model.getOpponentChefs();
		chefs = new Chef[opponentChefs.length+1];
		chefs[0] = game_model.getPlayerChef();

		for (int i=1; i<chefs.length; i++) {

			chefs[i] = opponentChefs[i-1];			
		}

		if (action.contentEquals("Balance")) {
			Arrays.sort(chefs, new HighToLowBalanceComparator());
		} else if (action.contentEquals("Spoiled")) {
			Arrays.sort(chefs, new HighToLowFoodSpoiledComparator());
		} else if (action.contentEquals("Consumed")) {
			Arrays.sort(chefs, new HighToLowFoodSoldComparator());
		}


		for (Chef c : chefs) {
			sb_html += "<b>" + c.getName() + "</b>" + " ($" + Math.round(c.getBalance()*100.0)/100.0 + ")" + "<br>";
			sb_html += "Total Consumed: " + String.valueOf(Math.round(c.getTotalConsumed()*100.0)/100.0) + " oz<br>";
			sb_html += "Total Spoiled: " + String.valueOf(Math.round(c.getTotalSpoiled()*100.0)/100.0) + " oz<br>";
			sb_html += " " + "<br>";
		}

		return sb_html;
	}

	public void refresh() {
		display.setText(makeScoreboardHTML());		
	}

	@Override
	public void handleBeltEvent(BeltEvent e) {
		if (e.getType() == BeltEvent.EventType.ROTATE) {

			refresh();
		}		
	}

}

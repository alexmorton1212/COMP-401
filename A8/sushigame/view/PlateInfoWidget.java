package sushigame.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JPanel;

import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;
import sushigame.model.SushiGameModel;

public class PlateInfoWidget extends JPanel implements BeltObserver, ActionListener {

	private SushiGameModel gameModel;
	private BeltView view;
	private PlateViewWidget[] widgetLabels;
	private JLabel display;
	private JSlider slider;
	private String print;
	private JButton select;


	public PlateInfoWidget(SushiGameModel gm, BeltView belt) {

		gameModel = gm;
		gameModel.getBelt().registerBeltObserver(this);
		view = belt;

		widgetLabels = view.getWidgetLabels().clone();

		print = "   Select a Position Number to get More Information about the Plate at that Position";

		display = new JLabel();
		setLayout(new BorderLayout());
		add(display, BorderLayout.CENTER);
		display.setText(print);

		slider = new JSlider(0,19,0);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		setPreferredSize(new Dimension(1000, 100));
		add(slider, BorderLayout.SOUTH);

		select = new JButton("Get Plate Info");
		select.setActionCommand("add");
		select.addActionListener(this);
		add(select, BorderLayout.WEST);

		refresh();

	}

	public void refresh() {
		display.setText(print);
		print = "   Select a Position Number to get More Information about the Plate at that Position";
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		refresh();
		char position = (char) slider.getValue();

		switch(e.getActionCommand()) {
		case "add":

			switch(position) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
			case 13:
			case 14:
			case 15:
			case 16:
			case 17:
			case 18:
			case 19:

				if (widgetLabels[position].getInfo().isEmpty()) {

					print = "    No Plate at this Position";
					refresh();
					break;

				} else {

					print = "   " + widgetLabels[position].getInfo();
					refresh();
					break;
				}
			}
		}
	}

	@Override
	public void handleBeltEvent(BeltEvent e) {
		if(e.getType() == BeltEvent.EventType.ROTATE) {
			refresh();
		}

	}

}

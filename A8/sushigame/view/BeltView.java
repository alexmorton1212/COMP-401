package sushigame.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import comp401sushi.Plate;
import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;

public class BeltView extends JPanel implements BeltObserver {

	private Belt belt;
	private PlateViewWidget[] widgetLabels;

	public BeltView(Belt b) {
		
		this.belt = b;
		belt.registerBeltObserver(this);
		setLayout(new GridLayout(belt.getSize()/2, 2));
		widgetLabels = new PlateViewWidget[belt.getSize()];
		
		for (int i = 0; i < belt.getSize(); i++) {
			
			Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
			
			PlateViewWidget plabel = new PlateViewWidget(b,i);
			plabel.setMinimumSize(new Dimension(100, 20));
			plabel.setPreferredSize(new Dimension(500, 20));
			plabel.setOpaque(true);
			plabel.setBackground(Color.LIGHT_GRAY);
			plabel.setBorder(border);
			this.add(plabel);
			widgetLabels[i] = plabel;
		}
		
		refresh();
	}
	
	public PlateViewWidget[] getWidgetLabels() {
		return widgetLabels.clone();
	}
	

	@Override
	public void handleBeltEvent(BeltEvent e) {	
		refresh();
	}

	private void refresh() {
		
		for (int i = 0; i < belt.getSize(); i++) {
			
			Plate p = belt.getPlateAtPosition(i);
			PlateViewWidget plabel = widgetLabels[i];
			
			if (p == null) {
				
				plabel.clearText();
				plabel.setBackground(Color.GRAY);
				plabel.backgroundText(i);
				plabel.setPreferredSize(new Dimension(150, 100));
				widgetLabels[i].clearInfo();
				
			} else {
				
				plabel.getPlateInfo(p);
				plabel.labelText();
				
				switch (p.getColor()) {
				
				case RED:
					plabel.setBackground(Color.RED); break;
					
				case GREEN:
					plabel.setBackground(Color.GREEN); break;
					
				case BLUE:
					plabel.setBackground(Color.BLUE); break;
					
				case GOLD:
					plabel.setBackground(Color.YELLOW); break;
				}
			}
		}
	}
	
	
	
}

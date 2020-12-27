package sushigame.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;
import sushigame.model.SushiGameModel;

public class SushiGameView extends JPanel implements ActionListener, BeltObserver {

	private PlayerChefView player_chef_ui;
	private List<RotationRequestListener> rotation_request_listeners;
	private JLabel controller_messages;
	ScoreboardWidget scoreboard;
	PlateInfoWidget plateInfo;
	
	public SushiGameView(SushiGameModel game_model) {
		setLayout(new BorderLayout());
		
		scoreboard = new ScoreboardWidget(game_model);
		add(scoreboard, BorderLayout.WEST);
				
		player_chef_ui = new PlayerChefView(game_model.getBelt().getSize());
		add(player_chef_ui, BorderLayout.EAST);
		
		BeltView belt_view = new BeltView(game_model.getBelt());
		add(belt_view, BorderLayout.CENTER);
		
		JPanel top_panel = new JPanel();
		top_panel.setLayout(new BorderLayout());
		
		JButton rotate_button = new JButton("Rotate");
		rotate_button.setBackground(Color.RED);
		rotate_button.setActionCommand("rotate");
		rotate_button.addActionListener(this);
		rotate_button.setPreferredSize(new Dimension(300, 50));
		top_panel.add(rotate_button, BorderLayout.WEST);
		
		controller_messages = new JLabel("   Controller messages.");
		top_panel.add(controller_messages, BorderLayout.CENTER);
		
		add(top_panel, BorderLayout.NORTH);
		
		JPanel bottom_panel = new JPanel();
		bottom_panel.setLayout(new BorderLayout());
		
		plateInfo = new PlateInfoWidget(game_model, belt_view);
		bottom_panel.add(plateInfo, BorderLayout.CENTER);
		
		add(bottom_panel, BorderLayout.SOUTH);
		
		
		rotation_request_listeners = new ArrayList<RotationRequestListener>();
		
		game_model.getBelt().registerBeltObserver(this);
	}
	
	public void registerPlayerChefListener(ChefViewListener cl) {
		player_chef_ui.registerChefListener(cl);
	}
	
	public void registerRotationRequestListener(RotationRequestListener rrl) {
		rotation_request_listeners.add(rrl);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("rotate")) {
			for (RotationRequestListener rrl : rotation_request_listeners) {
				rrl.handleRotationRequest();
			}
		}
	}
	
	public void setControllerMessage(String message) {
		controller_messages.setText("   NOTE: " + message);
	}

	@Override
	public void handleBeltEvent(BeltEvent e) {
		if (e.getType() == BeltEvent.EventType.ROTATE) {
			controller_messages.setText("");
		}
	}
	
	public void refreshScoreboard() {
		scoreboard.refresh();
	}
	
	public void refreshPlateInfo() {
		plateInfo.refresh();
	}
}

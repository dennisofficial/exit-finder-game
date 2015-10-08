package me.dennis.exitfinder.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import me.dennis.exitfinder.input.Keyboard;
import me.dennis.exitfinder.managers.RoomManager;
import me.dennis.exitfinder.utils.Settings;

@SuppressWarnings("serial")
public class JavaPanel extends JPanel implements ActionListener {

	private Settings S = Main.settings;
	private Keyboard K = Main.keyboard;
	private RoomManager RM = Main.roommanager;
	
	public JavaPanel() {
		setFocusable(true);
		requestFocus();
		
		K.setupKeys();
		
		addKeyListener(K);
		
		new Timer(1000/S.FPS, this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
	}
	
}

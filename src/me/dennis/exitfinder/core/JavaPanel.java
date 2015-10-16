package me.dennis.exitfinder.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import me.dennis.exitfinder.input.Keyboard;
import me.dennis.exitfinder.managers.RoomManager;
import me.dennis.exitfinder.utils.Settings;

@SuppressWarnings("serial")
public class JavaPanel extends JPanel implements ActionListener {

	private Settings S = Game.settings;
	private Keyboard K = Game.keyboard;
	private RoomManager RM = Game.roommanager;
	
	public JavaPanel() {
		setFocusable(true);
		requestFocus();
		
		K.setupKeys();
		RM.setupRooms();
		
		addKeyListener(K);
		
		new Timer(1000/S.FPS, this).start();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		RM.update();
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(new Color(0xEEEEEE));
		g.fillRect(0, 0, S.WIDTH, S.HEIGHT);
		RM.draw(g);
	}
	
}

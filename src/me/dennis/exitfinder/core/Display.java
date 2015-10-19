package me.dennis.exitfinder.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import me.dennis.exitfinder.input.Keyboard;
import me.dennis.exitfinder.managers.GrassManager;
import me.dennis.exitfinder.managers.RoomManager;
import me.dennis.exitfinder.utils.Settings;

@SuppressWarnings("serial")
public class Display extends JPanel implements ActionListener {

	private Settings S = Game.settings;
	private Keyboard K = Game.keyboard;
	private RoomManager RM = Game.roommanager;
	
	Camera cam;
	GrassManager gm;
	
	public Display() {
		requestFocus();
		setFocusable(true);
		
		K.setupKeys();
		RM.setupRooms();
		cam = new Camera();
		gm = new GrassManager();
		
		addKeyListener(K);
		
		new Timer(1000/S.FPS, this).start();
		new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		}).start();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		RM.update();
		cam.update();
		gm.check();
		K.reset();
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(new Color(0xEEEEEE));
		g.fillRect(0, 0, S.WIDTH, S.HEIGHT);
		g2d.translate((int) Camera.x, (int) Camera.y);
		RM.draw(g);
		g2d.translate((int) -Camera.x, (int) -Camera.x);
		g.dispose();
	}
	
}

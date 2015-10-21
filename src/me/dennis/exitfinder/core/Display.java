package me.dennis.exitfinder.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import me.dennis.exitfinder.input.Keyboard;
import me.dennis.exitfinder.input.Mouse;
import me.dennis.exitfinder.managers.GrassManager;
import me.dennis.exitfinder.managers.RoomManager;
import me.dennis.exitfinder.utils.Settings;

@SuppressWarnings("serial")
public class Display extends JPanel implements ActionListener, Runnable {

	private Settings S = Game.settings;
	private Keyboard K = Game.keyboard;
	private Mouse M = Game.mouse;
	private RoomManager RM = Game.roommanager;

	int tick;
	int fps;
	int display;
	Camera cam;
	GrassManager gm;
	
	public Display() {
		requestFocus();
		setFocusable(true);
		
		K.setupKeys();
		M.setupKeys();
		RM.setupRooms();
		cam = new Camera();
		gm = new GrassManager();
		
		addKeyListener(K);
		addMouseListener(M);
		addMouseMotionListener(M);
		
		new Timer(1000/60, this).start();
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (display < 2) {
				display++;
			}
			else {
				display = 0;
				System.out.println("FPS: " + fps + " Ticks: " + tick);
			}
			tick = 0;
			fps = 0;
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		RM.update();
		cam.update();
		gm.check();
		K.reset();
		M.reset();
		tick++;
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(new Color(0xEEEEEE));
		g.fillRect(0, 0, S.width, S.height);
		g2d.translate((int) Camera.x, (int) Camera.y);
		RM.draw(g);
		g2d.translate((int) -Camera.x, (int) -Camera.x);
		g.dispose();
		fps++;
		repaint();
	}
	
}

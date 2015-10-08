package me.dennis.exitfinder.core;

import javax.swing.JFrame;

import me.dennis.exitfinder.input.Keyboard;
import me.dennis.exitfinder.managers.RoomManager;
import me.dennis.exitfinder.utils.Settings;

public class Main {
	
	public static final Settings settings = new Settings();
	public static final Keyboard keyboard = new Keyboard();
	public static final RoomManager roommanager = new RoomManager();
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new JavaPanel());
		f.setVisible(true);
		f.setResizable(false);
		f.setSize(settings.WIDTH, settings.HEIGHT);
		f.setLocationRelativeTo(null);
	}
	
}

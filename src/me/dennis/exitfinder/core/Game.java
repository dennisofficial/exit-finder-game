package me.dennis.exitfinder.core;

import javax.swing.JFrame;

import me.dennis.exitfinder.input.Keyboard;
import me.dennis.exitfinder.managers.RoomManager;
import me.dennis.exitfinder.utils.KeyMap;
import me.dennis.exitfinder.utils.MapLoader;
import me.dennis.exitfinder.utils.Settings;

public class Game {
	
	public static final Settings settings = new Settings();
	public static final Keyboard keyboard = new Keyboard();
	public static final RoomManager roommanager = new RoomManager();
	public static final KeyMap keymap = new KeyMap();
	public static final MapLoader maploader = new MapLoader();
	
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
